package com.kyun.main;

import com.kyun.entity.Car;
import com.kyun.entity.User;
import com.kyun.service.CarService;
import com.kyun.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        UserService userService = (UserService) context.getBean("userService");
        List<User> users = userService.getAllUsers();

        for (User u : users) {
            System.out.println(u.toString());
        }

        CarService carService = (CarService) context.getBean("carService");

        Car car = new Car();
        car.setId(1);
        car.setName("Lancer");
        car.setManufacturer("Mitsubishi");
        car.setPrice(new BigDecimal(79999.99));
        car.setProductionYear(2016);
        car.setAmountLeft(100);
        car.setBodyStyle("4-door sedan");
        car.setCarClass("Compact car");

        carService.addCar(car);

        System.out.println(car);

        // close resources
        context.close();
    }
}
