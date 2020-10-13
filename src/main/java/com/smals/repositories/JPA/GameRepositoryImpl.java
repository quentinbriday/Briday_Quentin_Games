package com.smals.repositories.JPA;

import com.smals.domain.Game;
import com.smals.repositories.GenericCrudRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameRepositoryImpl implements GenericCrudRepository<Game> {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    EntityManager entityManager;

//    public Game findGameById(int id) {
//        return entityManager
//                .find(Game.class, id);
//    }

    public Game findGameByName(String name) {
        return entityManager
                .createQuery("SELECT g FROM Game g WHERE g.gameName LIKE :name", Game.class)
                .setParameter("name", "%" + name + "%")
                .getResultList()
                .get(0);
    }

//    public List<Game> findAllGames() {
//        return entityManager
//                .createQuery("SELECT g from Game g", Game.class)
//                .getResultList();
//    }

    @Override
    public void save(Game entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<Game> findAll() {
        return entityManager
                .createQuery("SELECT g from Game g", Game.class)
                .getResultList();
    }

    @Override
    public void delete(Game entity) {
        entityManager.remove(entity);
    }

    @Override
    public Game findById(Integer id) {
        return entityManager.find(Game.class, id);
    }
}
