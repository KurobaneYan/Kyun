package com.kyun.main;

import com.kyun.dao.GenericDAO;
import com.kyun.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");


        GenericDAO dao = (GenericDAO) context.getBean("userDAO");

        @SuppressWarnings("unchecked")
        List<User> users = dao.list();

        for (User u : users) {
            System.out.println(u.getName());
        }

        // close resources
        context.close();
    }
}
