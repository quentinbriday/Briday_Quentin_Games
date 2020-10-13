package com.smals.repositories.JPA;

import com.smals.domain.Difficulty;
import com.smals.repositories.GenericCrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class DifficultyRepositoryImpl implements GenericCrudRepository<Difficulty> {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    EntityManager entityManager;

    @Override
    public void save(Difficulty entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<Difficulty> findAll() {
        return entityManager
                .createQuery("SELECT d FROM Difficulty d", Difficulty.class)
                .getResultList();
    }

    @Override
    public void delete(Difficulty entity) {
        entityManager.remove(entity);
    }

    @Override
    public Difficulty findById(Integer id) {
        return entityManager.find(Difficulty.class, id);
    }
}
