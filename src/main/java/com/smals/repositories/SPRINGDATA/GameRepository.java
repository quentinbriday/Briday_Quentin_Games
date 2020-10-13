package com.smals.repositories.SPRINGDATA;

import com.smals.domain.Game;
import com.smals.domain.enums.DifficultyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    public List<Game> findAllByGameNameContaining(String gameName);
    public List<Game> findAllByDifficulty_DifficultyName(DifficultyType difficultyType);
    @Query("SELECT g FROM Game g where g.difficulty in (SELECT d1.id FROM Difficulty d1 where d1.id >= (select d2.id  FROM Difficulty d2 where d2.difficultyName = :difficultyType))")
    public List<Game> findGameWithDifficultyGreaterThan(DifficultyType difficultyType);
}
