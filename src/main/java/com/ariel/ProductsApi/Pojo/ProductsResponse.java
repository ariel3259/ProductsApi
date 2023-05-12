package com.ariel.ProductsApi.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductsResponse {
    private long productsId;
    private String name;
    private double price;
    private int stock;
}
