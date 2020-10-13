package com.smals.services;

import com.smals.domain.Game;
import com.smals.domain.enums.DifficultyType;
import com.smals.repositories.GenericCrudRepository;
import com.smals.repositories.SPRINGDATA.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GenericCrudService<Game> {

    private GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAllByName(String gameName){
        return gameRepository.findAllByGameNameContaining(gameName);
    }

    public List<Game> findAllByDifficulty(DifficultyType difficultyType){
        return gameRepository.findAllByDifficulty_DifficultyName(difficultyType);
    }

    public List<Game> findAllByDifficultyGreaterThan(DifficultyType difficultyType){
        return gameRepository.findGameWithDifficultyGreaterThan(difficultyType);
    }

    @Override
    public void save(Game entity) {
        gameRepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
        gameRepository.deleteById(id);
    }

    @Override
    public Game findById(int id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
