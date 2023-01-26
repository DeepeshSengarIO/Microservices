package com.example.product_service.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    private String productId;
    private String name;
    private String userId;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public Product(String pId, String name, String userId) {
        this.productId = pId;
        this.name = name;
        this.userId = userId;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductIdId(String pId) {
        this.productId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
