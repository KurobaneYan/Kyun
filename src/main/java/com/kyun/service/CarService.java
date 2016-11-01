package com.kyun.service;

import com.kyun.entity.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    List<Car> getAllCars();
}
