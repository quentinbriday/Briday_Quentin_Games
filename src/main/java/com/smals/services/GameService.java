package com.smals.services;

import com.smals.domain.Game;
import com.smals.repositories.JDBC.GameJDBCRepository;
import com.smals.repositories.JPA.GameJPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

public class GameService {

//    private GameJDBCRepository gameJDBCRepository = GameJDBCRepository.getInstance();
    @Inject
    private GameJPARepository gameJPARepository;

    public Game findGameById(int id){
//        return gameJDBCRepository.getGame(id);
        return gameJPARepository.findGameById(id);
    }

    public Game findGameByName(String gameName) {
//        return gameJDBCRepository.getGameByName(gameName);
        return gameJPARepository.findGameByName(gameName);
    }

    public List<Game> findAllGames() {
//        return gameJDBCRepository.getAllGames();
        return gameJPARepository.findAllGames();
    }
}
