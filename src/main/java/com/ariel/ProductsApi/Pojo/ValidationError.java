package com.ariel.ProductsApi.Pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema
@AllArgsConstructor
@Getter
public class ValidationError {
    @Schema
    private String field;
    @Schema
    private String message;
}
