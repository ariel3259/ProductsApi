package com.ariel.ProductsApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ariel.ProductsApi.Abstractions.GenericRepository;
import com.ariel.ProductsApi.Abstractions.PageResponse;
import com.ariel.ProductsApi.Model.Products;
import com.ariel.ProductsApi.Pojo.ProductsPageResponse;
import com.ariel.ProductsApi.Pojo.ProductsRequest;
import com.ariel.ProductsApi.Pojo.ProductsResponse;

@Service()
public class ProductsService {
    @Autowired
    private GenericRepository<Products> productsRepository;
    
    public PageResponse<ProductsResponse> getAll(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<Products> productsPage = productsRepository.findByStatus(pageRequest, true);
        long count = productsRepository.countByStatus(true);
        List<Products> products = productsPage.getContent();
        List<ProductsResponse> productsResponse = products
            .stream()
            .map((product) -> {
                return new ProductsResponse(product.getId(), product.getName(), product.getPrice(), product.getStock());
            })
            .toList();
        return new ProductsPageResponse(productsResponse, count);
    }

    public ProductsResponse save(ProductsRequest request) {
        Products productToSave = new Products(request.getName(), request.getPrice(), request.getStock(), "Ariel", "Ariel", true);
        Products productSaved = this.productsRepository.save(productToSave);
        return new ProductsResponse(productSaved.getId(), productSaved.getName(), productSaved.getPrice(), productSaved.getStock());
    }
}
