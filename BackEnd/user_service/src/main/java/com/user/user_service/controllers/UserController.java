package com.user.user_service.controllers;

import com.user.user_service.models.Product;
import com.user.user_service.models.User;
import com.user.user_service.repository.UserRepository;
import com.user.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserProducts(@PathVariable String userId){
        User user = this.userService.getUser(userId);
        List Product = this.restTemplate.getForObject("http://localhost:9005/api/products/all/"+userId, List.class);
        user.setProducts(Product);
        return user;
    }

}
