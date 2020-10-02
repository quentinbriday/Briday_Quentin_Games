package com.smals.services;

import com.smals.domain.Game;
import com.smals.repositories.GameJDBCRepository;

import java.util.List;

public class GameService {

    private GameJDBCRepository gameJDBCRepository = GameJDBCRepository.getInstance();

    public Game findGameById(int id){
        return gameJDBCRepository.getGame(id);
    }

    public Game findGameByName(String gameName) {
        return gameJDBCRepository.getGameByName(gameName);
    }

    public List<Game> findAllGames() {
        return gameJDBCRepository.getAllGames();
    }
}