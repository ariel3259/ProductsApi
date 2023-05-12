package com.ariel.ProductsApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.ProductsApi.Abstractions.PageResponse;
import com.ariel.ProductsApi.Abstractions.ValidationController;
import com.ariel.ProductsApi.Pojo.ProductsRequest;
import com.ariel.ProductsApi.Pojo.ProductsResponse;
import com.ariel.ProductsApi.Services.ProductsService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController()
@RequestMapping("/api/products")
public class ProductsController extends ValidationController {
    
    @Autowired
    private ProductsService service;

    @GetMapping
    public List<ProductsResponse> getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletResponse res) {
        PageResponse<ProductsResponse> productsPage = service.getAll(page, limit);
        res.setHeader("x-total-count", String.valueOf(productsPage.getTotalItems()));
        return productsPage.getElements();
    }

    @PostMapping
    public ResponseEntity<ProductsResponse> create(@RequestBody() ProductsRequest request) {
        ProductsResponse response = this.service.save(request);
        return ResponseEntity.ok(response);
    }

}
