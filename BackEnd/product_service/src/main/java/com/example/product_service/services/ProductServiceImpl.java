package com.example.product_service.services;

import com.example.product_service.models.Product;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.repository.SearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Component
public class ProductServiceImpl implements ProductService, SearchRepository {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsOfUser(String userId) {
        return null;
    }

    @Override
    public List<Product> findProductById(String id) {
        final List<Product> productList = new ArrayList<>();

        MongoDatabase database = client.getDatabase("crudapp");
        MongoCollection<Document> collection = database.getCollection("products");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "product_index")
                        .append("text",
                                new Document("query", id)
                                        .append("path", "userId")))));

        result.forEach(doc-> productList.add(converter.read(Product.class, doc)));

        return productList;
    }
}
