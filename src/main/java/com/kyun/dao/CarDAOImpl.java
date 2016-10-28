package com.kyun.dao;

import com.kyun.entity.Car;
import org.hibernate.SessionFactory;

import java.util.List;

public class CarDAOImpl implements CarDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Car car) {
//        Session session = this.sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.persist(car);
//        transaction.commit();
//        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Car> list() {
//        Session session = this.sessionFactory.openSession();
//        List<Car> carList = session.createQuery("from Car ").list();
//        session.close();
//        return carList;
        return null;
    }

}
