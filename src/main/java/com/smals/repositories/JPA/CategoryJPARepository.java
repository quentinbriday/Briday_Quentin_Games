package com.smals.repositories.JPA;

import com.smals.domain.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryJPARepository {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    private EntityManager entityManager;

    public Category findCategoryById(int id){
        return entityManager
                .find(Category.class, id);
    }
}
