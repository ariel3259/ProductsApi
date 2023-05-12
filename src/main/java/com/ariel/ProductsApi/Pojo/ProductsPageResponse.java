package com.ariel.ProductsApi.Pojo;

import java.util.List;

import com.ariel.ProductsApi.Abstractions.PageResponse;

public class ProductsPageResponse extends PageResponse<ProductsResponse> {
    public ProductsPageResponse(List<ProductsResponse> items, long totalItems) {
        super(items, totalItems);
    }    
}
