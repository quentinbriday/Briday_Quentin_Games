package com.smals.repositories.JPA;

import com.smals.domain.Borrower;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Stateless
public class BorrowerJPARepository {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    private EntityManager entityManager;

    public Borrower findBorrowerById(int id){
        return entityManager
                .createQuery("SELECT b FROM Borrower b WHERE b.id = :id", Borrower.class)
                .setParameter("id", id)
                //.setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
                .getSingleResult();
    }
}
