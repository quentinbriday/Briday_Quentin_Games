package com.smals.domain;

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
}
