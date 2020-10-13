package com.smals.repositories.JPA;

import com.smals.domain.Borrow;
import com.smals.repositories.GenericCrudRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BorrowRepositoryImpl implements GenericCrudRepository<Borrow> {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    private EntityManager entityManager;

//    public List<Borrow> findAllBorrow() {
//        return entityManager
//                .createQuery("SELECT b FROM Borrow b", Borrow.class)
//                .getResultList();
//    }

    @Override
    public void save(Borrow entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<Borrow> findAll() {
        return entityManager
                .createQuery("SELECT b FROM Borrow b", Borrow.class)
                .getResultList();
    }

    @Override
    public void delete(Borrow entity) {
        entityManager.remove(entity);
    }

    @Override
    public Borrow findById(Integer id) {
        return entityManager.find(Borrow.class, id);
    }
}
