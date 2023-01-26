package com.user.user_service.models;

public class Product {

    private String productId;
    private String name;
    private String userId;

    @Override
    public String toString() {
        return "Product{" +
                "pId='" + productId + '\'' +
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

    public void setProductId(String pId) {
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
