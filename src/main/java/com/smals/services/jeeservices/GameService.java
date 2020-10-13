package com.smals.services.jeeservices;

import com.smals.domain.Game;
import com.smals.repositories.JPA.GameRepositoryImpl;

import javax.inject.Inject;
import java.util.List;

public class GameService {

    //    private GameJDBCRepository gameJDBCRepository = GameJDBCRepository.getInstance();
    @Inject
    private GameRepositoryImpl gameRepositoryImpl;

    public Game findGameById(int id) {
//        return gameJDBCRepository.getGame(id);
        return gameRepositoryImpl.findById(id);
    }

    public Game findGameByName(String gameName) {
//        return gameJDBCRepository.getGameByName(gameName);
        return gameRepositoryImpl.findGameByName(gameName);
    }

    public List<Game> findAllGames() {
//        return gameJDBCRepository.getAllGames();
        return gameRepositoryImpl.findAll();
    }
}
