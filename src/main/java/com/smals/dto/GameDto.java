package com.smals.dto;

import com.smals.domain.Category;
import com.smals.domain.Difficulty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Data
public class GameDto {
    private Integer id;
    private String gameName;
    private String editor;
    private String author;
    private int yearEdition;
    private String age;
    private int minPlayers;
    private int maxPlayers;
    private CategoryDto categoryDto;
    private String playDuration;
    private DifficultyDto difficultyDto;
    private BigDecimal price;
    private String image;
}
