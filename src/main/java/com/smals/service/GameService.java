package com.smals.service;

import com.smals.domain.Borrow;
import com.smals.domain.Borrower;
import com.smals.domain.Category;
import com.smals.domain.Game;
import com.smals.repositories.GameJDBCRepository;

import java.util.List;

public class GameService {

    private GameJDBCRepository gameJDBCRepository = GameJDBCRepository.getInstance();

    public Category findGameCategoryById(int id){
        return gameJDBCRepository.getGameCategory(id);
    }

    public Game findGameById(int id){
        return gameJDBCRepository.getGame(id);
    }

    public Borrower findBorrowerById(int id){
        return gameJDBCRepository.getBorrower(id);
    }

    public Game findGameByName(String gameName) {
        return gameJDBCRepository.getGameByName(gameName);
    }

    public List<Game> findAllGames() {
        return gameJDBCRepository.getAllGames();
    }

    public List<Borrow> findAllBorrow() {
        return gameJDBCRepository.getAllBorrow();
    }
}
