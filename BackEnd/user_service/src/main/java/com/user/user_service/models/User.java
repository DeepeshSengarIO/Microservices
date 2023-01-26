package com.user.user_service.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
public class User {

    private String userId;
    private String name;
    private String job;
    private String image;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", image='" + image + '\'' +
                ", products=" + products +
                '}';
    }

    List<Product> products = new ArrayList<>();

    public User(String userId, String name, String job, String image, List<Product> products) {
        this.name = name;
        this.job = job;
        this.image = image;
        this.products = products;
        this.userId = userId;
    }

    public User(String userId, String name, String job, String image) {
        this.name = name;
        this.job = job;
        this.image = image;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
