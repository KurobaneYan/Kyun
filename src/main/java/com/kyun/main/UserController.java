package com.kyun.main;

import com.kyun.dao.GenericDAO;
import com.kyun.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public User user() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        GenericDAO dao = (GenericDAO) context.getBean("userDAO");

        @SuppressWarnings("unchecked")
        User user = (User) dao.read(1);
        System.out.println(user);


        // close resources
        context.close();
        return user;
    }
}
