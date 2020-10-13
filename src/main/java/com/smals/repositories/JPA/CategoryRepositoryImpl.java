package com.smals.repositories.JPA;

import com.smals.domain.Category;
import com.smals.repositories.GenericCrudRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoryRepositoryImpl implements GenericCrudRepository<Category> {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    private EntityManager entityManager;

//    public Category findCategoryById(int id) {
//        return entityManager
//                .find(Category.class, id);
//    }

    @Override
    public void save(Category entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<Category> findAll() {
        return entityManager
                .createQuery("SELECT c FROM Category c", Category.class)
                .getResultList();
    }

    @Override
    public void delete(Category entity) {
        entityManager.remove(entity);
    }

    @Override
    public Category findById(Integer id) {
        return entityManager.find(Category.class, id);
    }
}
