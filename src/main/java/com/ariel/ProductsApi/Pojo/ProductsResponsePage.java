package com.ariel.ProductsApi.Pojo;

import java.util.List;

import com.ariel.ProductsApi.Abstractions.PageResponse;

public class ProductsResponsePage extends PageResponse<ProductsResponse> {
    public ProductsResponsePage(List<ProductsResponse> items, long totalItems) {
        super(items, totalItems);
    }    
}
