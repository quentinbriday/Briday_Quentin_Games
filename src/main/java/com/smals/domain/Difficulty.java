package com.smals.domain;

import com.smals.domain.enums.DifficultyType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Difficulty implements Serializable {

    @Column(name = "difficulty_name", nullable = false, insertable = false,updatable = false)
    @Enumerated(EnumType.STRING)
    private DifficultyType difficultyName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Difficulty(DifficultyType difficultyName, Integer id) {
        this.difficultyName = difficultyName;
        this.id = id;
    }

    public Difficulty() {
    }

    public Difficulty(DifficultyType difficultyName) {
        this.difficultyName = difficultyName;
    }

    public DifficultyType getDifficultyName() {
        return difficultyName;
    }

    @Override
    public String toString() {
        return "Difficulty{" +
                "difficultyName='" + difficultyName + '\'' +
                ", id=" + id +
                '}';
    }

    public void setDifficultyName(DifficultyType difficultyName) {
        this.difficultyName = difficultyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static boolean equalOrMore(Difficulty d1, DifficultyType difficulty) {
        List<String> strings = new ArrayList<String>(Arrays.asList(difficulty.getDifficultyValue().split(",")));
        return !strings.contains(d1.difficultyName);
    }
}
