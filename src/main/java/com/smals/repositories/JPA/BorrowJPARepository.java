package com.smals.repositories.JPA;

import com.smals.domain.Borrow;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BorrowJPARepository {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    private EntityManager entityManager;

    public List<Borrow> findAllBorrow(){
        return entityManager
                .createQuery("SELECT b FROM Borrow b", Borrow.class)
                .getResultList();
    }
}
