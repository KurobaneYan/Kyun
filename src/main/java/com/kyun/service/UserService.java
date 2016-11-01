package com.kyun.service;

import com.kyun.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
}
