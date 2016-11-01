package com.kyun.main;

import com.kyun.entity.User;
import com.kyun.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

//        GenericDAO userDAO = (GenericDAO) context.getBean("userDAO");
//        GenericDAO userRoleDAO = (GenericDAO) context.getBean("userRoleDAO");
//        GenericDAO roleDAO = (GenericDAO) context.getBean("roleDAO");
//
//        User user = (User) userDAO.read(1);
//        System.out.println(user);
//
//        @SuppressWarnings("unchecked")
//        List<User> users = userDAO.list();
//
//        for (User u : users) {
//            System.out.println(u.getName());
//        }

        UserService userService = (UserService) context.getBean("userService");
        List<User> users = userService.getAllUsers();

        for (User u : users) {
            System.out.println(u.toString());
        }

        // close resources
        context.close();
    }
}
