package com.kyun.dao;

import com.kyun.entity.Car;

import java.util.List;

public interface CarDAO {
    void save(Car car);
    List<Car> list();
}
