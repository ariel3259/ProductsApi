package com.ariel.ProductsApi.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.ariel.ProductsApi.Model.Products;
import com.ariel.ProductsApi.Pojo.ProductsRequest;
import com.ariel.ProductsApi.Pojo.ProductsResponse;
import com.ariel.ProductsApi.Pojo.ProductsUpdate;

@Mapper(componentModel="spring")
public interface ProductsMapper {
    @Mapping(target="productsId", source="id")
    ProductsResponse toProductsResponse(Products product);
    
    
    List<ProductsResponse> toProductsResponse(List<Products> products);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", defaultExpression = "java(new Date(System.currentTimeMilis()))", ignore = true)
    @Mapping(target = "updatedAt", defaultExpression = "java(new Date(System.currentTImeMilis()))", ignore = true)
    Products toProducts(ProductsRequest request);

    @Mapping(target="id", ignore=true)
    @Mapping(target="createdBy", ignore=true)
    @Mapping(target="updatedBy", ignore=true)
    @Mapping(target="status", ignore=true)
    @Mapping(target="name", conditionExpression="java(update.getName() != null)")
    @Mapping(target="stock", conditionExpression="java(update.getStock() != null)")
    @Mapping(target="price", conditionExpression="java(update.getPrice() != null)")
    @Mapping(target = "createdAt", defaultExpression = "java(new Date(System.currentTimeMilis()))", ignore = true)
    @Mapping(target = "updatedAt", defaultExpression = "java(new Date(System.currentTImeMilis()))", ignore = true)
    Products toProducts(ProductsUpdate update);
}
