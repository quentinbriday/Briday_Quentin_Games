package com.smals.domain;

import com.smals.domain.enums.DifficultyType;
import com.smals.domain.enums.DifficultyType2;

import java.util.*;
import java.util.stream.Collectors;

public class Difficulty {

    private String difficultyName;
    private Integer id;

    public Difficulty(String difficultyName, Integer id) {
        this.difficultyName = difficultyName;
        this.id = id;
    }

    public Difficulty(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    @Override
    public String toString() {
        return "Difficulty{" +
                "difficultyName='" + difficultyName + '\'' +
                ", id=" + id +
                '}';
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static boolean equalOrMore(Difficulty d1, DifficultyType difficulty){
        //TODO: Replace that by a system were each enum of difficulty contain a tab of less level difficulties,
        // then search if the d1.difficulty_name is not in this tab
        System.out.println(d1.id + " " + difficulty.getDifficultyValue());
        return d1.id >= difficulty.getDifficultyValue();
    }

    public static boolean equalOrMore(Difficulty d1, DifficultyType2 difficulty){
        //TODO: Replace that by a system were each enum of difficulty contain a tab of less level difficulties,
        // then search if the d1.difficulty_name is not in this tab
        List<String> strings = new ArrayList<String>(Arrays.asList(difficulty.getDifficultyValue().split(",")));
        return !strings.contains(d1.difficultyName);
    }
}
