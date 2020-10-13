package com.smals.repositories.SPRINGDATA;

import com.smals.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
