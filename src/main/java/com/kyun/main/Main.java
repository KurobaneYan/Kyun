package com.kyun.main;

import com.kyun.dao.UserDAO;
import com.kyun.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);

//        User user = new User();
//        user.setName("Exal");
//        user.setSurname("Lukchu");
//        user.setEmail("exal.lukchu@gmail.com");
//
//        userDAO.save(user);

        List<User> users = userDAO.list();

        for (User u : users) {
            System.out.println("U: " + u + " " + u.getEmail());
        }

        // close resources
        context.close();
    }
}
