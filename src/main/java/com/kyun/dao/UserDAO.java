package com.kyun.dao;

import com.kyun.entity.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    List<User> list();
}
