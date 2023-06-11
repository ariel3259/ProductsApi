package com.ariel.ProductsApi.Controllers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.ProductsApi.Abstractions.PageResponse;
import com.ariel.ProductsApi.Abstractions.ValidationController;
import com.ariel.ProductsApi.Pojo.ProductsRequest;
import com.ariel.ProductsApi.Pojo.ProductsResponse;
import com.ariel.ProductsApi.Pojo.ProductsUpdate;
import com.ariel.ProductsApi.Services.ProductsService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/api/products")
public class ProductsController extends ValidationController{
    
    private final ProductsService service;

    @GetMapping
    public List<ProductsResponse> getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletResponse res) {
        PageResponse<ProductsResponse> productsPage = service.getAll(page, limit);
        res.setHeader("x-total-count", String.valueOf(productsPage.getTotalItems()));
        return productsPage.getElements();
    }

    @PostMapping()
    public ResponseEntity<ProductsResponse> create(@Valid @RequestBody ProductsRequest request) {
        ProductsResponse response = this.service.save(request);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("{productsId}")
    public ResponseEntity<?> update(@RequestBody ProductsUpdate request, @PathVariable("productsId") long productsId) {
        return ResponseEntity.noContent().build();
    }
}
