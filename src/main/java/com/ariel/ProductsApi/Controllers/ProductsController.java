package com.ariel.ProductsApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.ProductsApi.Abstractions.PageResponse;
import com.ariel.ProductsApi.Pojo.ProductsResponse;
import com.ariel.ProductsApi.Services.ProductsService;

import jakarta.servlet.http.HttpServletResponse;

@RestController()
@RequestMapping("/api/products")
public class ProductsController {
    
    @Autowired
    private ProductsService service;

    @GetMapping
    public List<ProductsResponse> getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletResponse res) {
        PageResponse<ProductsResponse> productsPage = service.getAll(page, limit);
        res.setHeader("x-total-count", String.valueOf(productsPage.getTotalItems()));
        return productsPage.getElements();
    }
}
