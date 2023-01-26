package com.user.user_service.service;

import com.user.user_service.models.User;

public interface UserService {
    User save(User user);
    User getUser(String id);
}
