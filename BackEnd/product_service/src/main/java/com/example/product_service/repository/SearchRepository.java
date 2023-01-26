package com.example.product_service.repository;

import com.example.product_service.models.Product;

import java.util.List;

public interface SearchRepository {
    List<Product> findProductById(String id);
}
