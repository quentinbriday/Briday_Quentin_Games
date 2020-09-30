package com.smals.domain.enums;

public enum DifficultyType {
    VERY_EASY(1),EASY(2),AVERAGE(3),DIFFICULT(4), VERY_DIFFICULT(5);

    private final int difficultyValue;

    DifficultyType(int difficultyValue) {
        this.difficultyValue = difficultyValue;
    }

    public int getDifficultyValue() {
        return difficultyValue;
    }
}
