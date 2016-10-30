package com.kyun.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {
    private Class<T> type;
    private SessionFactory sessionFactory;

    public GenericDAOImpl(Class<T> type) {
        this.type = type;
    }

    public void create(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(object);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!=null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    public T read(PK id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        T item = null;
        try {
            transaction = session.beginTransaction();
            item = session.get(type, id);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!=null) transaction.rollback();
        }
        finally {
            session.close();
        }
        return item;
    }

    public void update(T o) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(o);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!=null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    public void delete(T o) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(o);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!=null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> list() {
        Session session = this.sessionFactory.openSession();
        List<T> list = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(type);
            list = criteria.list();
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
        finally {
            session.close();
        }
        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
