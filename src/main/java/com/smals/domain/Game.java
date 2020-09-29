package com.smals.domain;

public class Game {

    private Integer id;
    private String gameName;
    private String editor;
    private String author;
    private int yearEdition;
    private String age;
    private int minPlayers;
    private int maxPlayers;
    private String playDuration;
    private float price;
    private String image;
    private Category category;
    private Difficulty difficulty;

    public Game(Integer id, String gameName, String editor, String author, int yearEdition, String age, int minPlayers, int maxPlayers, String playDuration, float price, String image, Category category, Difficulty difficulty) {
        this.id = id;
        this.gameName = gameName;
        this.editor = editor;
        this.author = author;
        this.yearEdition = yearEdition;
        this.age = age;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playDuration = playDuration;
        this.price = price;
        this.image = image;
        this.category = category;
        this.difficulty = difficulty;
    }

    public Game(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", editor='" + editor + '\'' +
                ", author='" + author + '\'' +
                ", yearEdition=" + yearEdition +
                ", age=" + age +
                ", minPlayers=" + minPlayers +
                ", maxPlayers=" + maxPlayers +
                ", playDuration=" + playDuration +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", difficulty=" + difficulty +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearEdition() {
        return yearEdition;
    }

    public void setYearEdition(int yearEdition) {
        this.yearEdition = yearEdition;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public String getPlayDuration() {
        return playDuration;
    }

    public void setPlayDuration(String playDuration) {
        this.playDuration = playDuration;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
