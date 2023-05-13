package com.ariel.ProductsApi.Pojo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ProductsRequest {
    @Schema(required=true)
    @NotBlank(message="Name is mandatory")
    private String name;
    
    @Schema(required=true)
    @Min(value=1,message="Price is mandatory")
    private double price;
    
    @Schema(required=true)
    @Min(value=1,message="stock is mandatory")
    private int stock;
}
