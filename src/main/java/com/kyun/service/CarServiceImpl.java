package com.kyun.service;

import com.kyun.dao.GenericDAO;
import com.kyun.entity.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    private GenericDAO<Car, Integer> carDAO;

    private GenericDAO<Car, Integer> getCarDAO() {
        return carDAO;
    }

    public void setCarDAO(GenericDAO<Car, Integer> carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void addCar(Car car) {
        Car carInDB = getCarDAO().read(car.getId());
        if (!car.equals(carInDB) && carInDB != null)
            getCarDAO().create(car);
    }

    @Override
    public List<Car> getAllCars() {
        return getCarDAO().list();
    }
}
