package com.user.user_service.service;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.user.user_service.models.Product;
import com.user.user_service.models.User;
import com.user.user_service.repository.UserRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {

        ArrayList<User> user = new ArrayList<>();

        MongoDatabase database = client.getDatabase("crudapp");
        MongoCollection<Document> collection = database.getCollection("user");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "user_index")
                        .append("text",
                                new Document("query", "1")
                                        .append("path", "userId")))));

        result.forEach(doc-> user.add(converter.read(User.class, doc)));
        return user.get(0);
    }
}
