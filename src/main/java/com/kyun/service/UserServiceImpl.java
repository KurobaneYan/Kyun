package com.kyun.service;

import com.kyun.dao.GenericDAOImpl;
import com.kyun.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private GenericDAOImpl<User, Integer> userDAO;

    private GenericDAOImpl<User, Integer> getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(GenericDAOImpl<User, Integer> userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        getUserDAO().create(user);
    }

    public List<User> getAllUsers() {
        return getUserDAO().list();
    }
}
