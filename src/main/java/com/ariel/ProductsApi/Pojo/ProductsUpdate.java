package com.ariel.ProductsApi.Pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class ProductsUpdate {
    @Schema(required=false)
    private String name;
    @Schema(required=false)
    private double price;
    @Schema(required=false)
    private int stock;    
}
