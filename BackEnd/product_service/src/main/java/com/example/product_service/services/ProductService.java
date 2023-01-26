package com.example.product_service.services;

import com.example.product_service.models.Product;

import java.util.List;

public interface ProductService {
    public Product save(Product product);
    public List<Product> getProductsOfUser(String userId);
}
