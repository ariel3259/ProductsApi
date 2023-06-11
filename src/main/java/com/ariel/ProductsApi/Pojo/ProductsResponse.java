package com.ariel.ProductsApi.Pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema
public class ProductsResponse {
    @Schema()
    private long productsId;
    @Schema()
    private String name;
    @Schema()
    private double price;
    @Schema()
    private int stock;
}
