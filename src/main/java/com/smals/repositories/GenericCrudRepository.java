package com.smals.repositories;

import java.util.List;

public interface GenericCrudRepository<T> {
    void save(T entity);
    List<T> findAll();
    void delete(T entity);
    T findById(Integer id);
}
