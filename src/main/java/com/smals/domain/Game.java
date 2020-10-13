package com.smals.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "game_name", nullable = false)
    private String gameName;
    private String editor;
    private String author;
    @Column(name = "year_edition")
    private int yearEdition;
    private String age;
    @Column(name = "min_players")
    private int minPlayers;
    @Column(name = "max_players")
    private int maxPlayers;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "play_duration")
    private String playDuration;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;
    private BigDecimal price;
    private String image;


    public Game() {
    }

    public Game(Builder builder) {
        this.id = builder.id;
        this.gameName = builder.gameName;
        this.editor = builder.editor;
        this.author = builder.author;
        this.yearEdition = builder.yearEdition;
        this.age = builder.age;
        this.minPlayers = builder.minPlayers;
        this.maxPlayers = builder.maxPlayers;
        this.playDuration = builder.playDuration;
        this.price = builder.price;
        this.image = builder.image;
        this.category = builder.category;
        this.difficulty = builder.difficulty;
    }

    public static class Builder {
        private Integer id;
        private String gameName;
        private String editor;
        private String author;
        private int yearEdition;
        private String age;
        private int minPlayers;
        private int maxPlayers;
        private String playDuration;
        private BigDecimal price;
        private String image;
        private Category category;
        private Difficulty difficulty;

        public Builder(String gameName) {
            this.gameName = gameName;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withEditor(String editor) {
            this.editor = editor;
            return this;
        }

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder withYearEdition(int yearEdition) {
            this.yearEdition = yearEdition;
            return this;
        }

        public Builder withAge(String age) {
            this.age = age;
            return this;
        }

        public Builder withMinPlayers(int minPlayers) {
            this.minPlayers = minPlayers;
            return this;
        }

        public Builder withMaxPlayers(int maxPlayers) {
            this.maxPlayers = maxPlayers;
            return this;
        }

        public Builder withPlayDuration(String playDuration) {
            this.playDuration = playDuration;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withImage(String image) {
            this.image = image;
            return this;
        }

        public Builder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder withDifficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
