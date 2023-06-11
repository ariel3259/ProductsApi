package com.ariel.ProductsApi.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ariel.ProductsApi.Abstractions.GenericRepository;
import com.ariel.ProductsApi.Abstractions.PageResponse;
import com.ariel.ProductsApi.Mappers.ProductsMapper;
import com.ariel.ProductsApi.Model.Products;
import com.ariel.ProductsApi.Pojo.ProductsRequest;
import com.ariel.ProductsApi.Pojo.ProductsResponse;
import com.ariel.ProductsApi.Pojo.ProductsResponsePage;
import com.ariel.ProductsApi.Pojo.ProductsUpdate;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ProductsService {

    private final GenericRepository<Products> productsRepository;
    private final ProductsMapper productsMapper;
    
    public PageResponse<ProductsResponse> getAll(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<Products> productsPage = productsRepository.findByStatus(pageRequest, true);
        long count = productsRepository.countByStatus(true);
        List<ProductsResponse> response = productsMapper.toProductsResponse(productsPage.getContent());
        return new ProductsResponsePage(response, count);
    }

    public ProductsResponse save(ProductsRequest request) {
        Products productToSave = productsMapper.toProducts(request);
        productToSave.setCreatedBy("Ariel");
        productToSave.setUpdatedBy("Ariel");
        productToSave.setStatus(true);
        Products productSaved = this.productsRepository.save(productToSave);
        return new ProductsResponse(productSaved.getId(), productSaved.getName(), productSaved.getPrice(), productSaved.getStock());
    }

    public ProductsResponse update(ProductsUpdate update, long id) {
      Products updated = productsMapper.toProducts(update);
      updated.setUpdatedBy("Ariel");
      updated.setId(id);
      productsRepository.save(updated);
      return productsMapper.toProductsResponse(updated);
    }
}
