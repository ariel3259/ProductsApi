package com.ariel.ProductsApi.Repositories;



import org.springframework.stereotype.Repository;

import com.ariel.ProductsApi.Abstractions.GenericRepository;
import com.ariel.ProductsApi.Model.Products;

@Repository()
public interface ProductsRepository extends GenericRepository<Products> {
}
