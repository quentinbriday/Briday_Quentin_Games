package com.smals.repositories.JPA;

import com.smals.domain.Borrow;
import com.smals.domain.Borrower;
import com.smals.repositories.GenericCrudRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BorrowerRepositoryImpl implements GenericCrudRepository<Borrower> {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    private EntityManager entityManager;

//    public Borrower findBorrowerById(int id) {
//        return entityManager
//                .createQuery("SELECT b FROM Borrower b WHERE b.id = :id", Borrower.class)
//                .setParameter("id", id)
//                //.setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
//                .getSingleResult();
//    }

    @Override
    public void save(Borrower entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<Borrower> findAll() {
        return entityManager.createQuery("SELECT b FROM Borrower b", Borrower.class).getResultList();
    }

    @Override
    public void delete(Borrower entity) {
        entityManager.remove(entity);
    }

    @Override
    public Borrower findById(Integer id) {
        return entityManager.find(Borrower.class, id);
    }
}
