package com.example.product_service.controllers;

import com.example.product_service.models.Product;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductServiceImpl productServiceImpl;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productServiceImpl.save(product);
    }
    @GetMapping("/all")
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public List<Product> getById(@PathVariable String id){
        return productServiceImpl.findProductById(id);
    }
}
