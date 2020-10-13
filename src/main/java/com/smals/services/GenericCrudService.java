package com.smals.services;

import java.util.List;

public interface GenericCrudService<T> {
    List<T> findAll();
    void save(T entity);
    void deleteById(int id);
    T findById(int id);
}
