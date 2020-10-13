package com.smals.domain.enums;

//TRAINER: Watch out with classes that almost have the same name,
// better to remove the duplicate commit to git and if you need it again, take it from the git history.
// otherwise it could be confusing on which class you actually need
public enum DifficultyType2 {
    VERY_EASY("Very easy", ""),EASY("Easy", "very easy"),AVERAGE("Average", "very easy,easy"),DIFFICULT("Difficult", "very easy,easy,average"),VERY_DIFFICULT("Very difficult", "very easy,easy,average,difficult");

    private final String description;
    private final String difficultyValue;

    DifficultyType2(String description, String difficultyValue) {
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
