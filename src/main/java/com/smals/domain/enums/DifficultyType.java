package com.smals.domain.enums;

public enum DifficultyType {
    VERY_EASY("Very easy", ""), EASY("Easy", "very easy"), AVERAGE("Average", "very easy,easy"), DIFFICULT("Difficult", "very easy,easy,average"), VERY_DIFFICULT("Very difficult", "very easy,easy,average,difficult");

    private final String description;
    private final String difficultyValue;

    DifficultyType(String description, String difficultyValue) {
        this.description = description;
        this.difficultyValue = difficultyValue;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficultyValue() {
        return difficultyValue;
    }
}
