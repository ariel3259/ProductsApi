package com.ariel.ProductsApi.Pojo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Schema
public class ProductsRequest {
    @NotBlank(message="Name is mandatory")
    @Schema(required=true)
    private String name;
    @NotNull(message="Price is mandatory")
    @Schema(required=true)
    private double price;
    @NotNull(message="stock is mandatory")
    @Schema(required=true)
    private int stock;
}
