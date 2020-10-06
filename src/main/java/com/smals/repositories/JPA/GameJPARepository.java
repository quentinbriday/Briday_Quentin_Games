package com.smals.repositories.JPA;

import com.smals.domain.Game;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameJPARepository {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    EntityManager entityManager;

    public Game findGameById(int id){
        return entityManager
                .find(Game.class, id);
    }

    public Game findGameByName(String name){
        return entityManager
                .createQuery("SELECT g FROM Game g WHERE g.game_name LIKE :name", Game.class)
                .setParameter("name", "%"+name+"%")
                //.setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
                .getSingleResult();
    }

    public List<Game> findAllGames(){
        return entityManager
                .createQuery("SELECT g from Game g", Game.class)
                .getResultList();
    }
}
