package com.kyun.dao;

import java.io.Serializable;
import java.util.List;


/*
    @T - type
    @PK - Primary Key for search in db
 */
public interface GenericDAO <T, PK extends Serializable> {

    void create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);

    List<T> list();
}
