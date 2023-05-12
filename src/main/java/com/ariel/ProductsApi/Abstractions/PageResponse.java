package com.ariel.ProductsApi.Abstractions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PageResponse<T> {
    private List<T> elements;
    private long totalItems;
}
