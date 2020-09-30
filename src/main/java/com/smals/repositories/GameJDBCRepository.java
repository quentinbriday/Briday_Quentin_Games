package com.smals.repositories;

import com.smals.domain.*;
import com.smals.repositories.utils.JDBCConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameJDBCRepository {

    private static final GameJDBCRepository instance = new GameJDBCRepository();

    public static GameJDBCRepository getInstance() {
        return instance;
    }

    public Game getGame(int id){
        try (PreparedStatement preparedStatement = JDBCConnector.createConnection().prepareStatement("select * from Game as g " +
                "LEFT OUTER JOIN Category as c ON c.id = g.category_id " +
                "LEFT OUTER JOIN Difficulty as d ON d.id = g.difficulty_id " +
                "where g.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                Category category = new Category(resultSet.getString("c.category_name"), resultSet.getInt("c.id"));
                Difficulty difficulty = new Difficulty(resultSet.getString("d.difficulty_name"), resultSet.getInt("id"));
                Game game = new Game.Builder(resultSet.getString("game_name"))
                        .withId(resultSet.getInt("id"))
                        .withEditor(resultSet.getString("editor"))
                        .withAuthor(resultSet.getString("author"))
                        .withYearEdition(resultSet.getInt("year_edition"))
                        .withAge(resultSet.getString("age"))
                        .withMinPlayers(resultSet.getInt("min_players"))
                        .withMaxPlayers(resultSet.getInt("max_players"))
                        .withPlayDuration(resultSet.getString("play_duration"))
                        .withPrice(resultSet.getFloat("price"))
                        .withImage(resultSet.getString("image"))
                        .withCategory(category)
                        .withDifficulty(difficulty)
                        .build();
                return game;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Game getGameByName(String gameName) {
        try (PreparedStatement preparedStatement = JDBCConnector.createConnection().prepareStatement("select * from Game as g " +
                "LEFT OUTER JOIN Category as c ON c.id = g.category_id " +
                "LEFT OUTER JOIN Difficulty as d ON d.id = g.difficulty_id " +
                "where g.game_name LIKE ?")) {
            preparedStatement.setString(1, "%" + gameName + "%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                Category category = new Category(resultSet.getString("c.category_name"), resultSet.getInt("c.id"));
                Difficulty difficulty = new Difficulty(resultSet.getString("d.difficulty_name"), resultSet.getInt("id"));
                Game game = new Game.Builder(resultSet.getString("game_name"))
                        .withId(resultSet.getInt("id"))
                        .withEditor(resultSet.getString("editor"))
                        .withAuthor(resultSet.getString("author"))
                        .withYearEdition(resultSet.getInt("year_edition"))
                        .withAge(resultSet.getString("age"))
                        .withMinPlayers(resultSet.getInt("min_players"))
                        .withMaxPlayers(resultSet.getInt("max_players"))
                        .withPlayDuration(resultSet.getString("play_duration"))
                        .withPrice(resultSet.getFloat("price"))
                        .withImage(resultSet.getString("image"))
                        .withCategory(category)
                        .withDifficulty(difficulty)
                        .build();
                return game;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<Game>();
        try (PreparedStatement preparedStatement = JDBCConnector.createConnection().prepareStatement("select * from Game as g " +
                "LEFT OUTER JOIN Category as c ON c.id = g.category_id " +
                "LEFT OUTER JOIN Difficulty as d ON d.id = g.difficulty_id ")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                Category category = new Category(resultSet.getString("c.category_name"), resultSet.getInt("c.id"));
                Difficulty difficulty = new Difficulty(resultSet.getString("d.difficulty_name"), resultSet.getInt("d.id"));
                games.add( new Game.Builder(resultSet.getString("game_name"))
                        .withId(resultSet.getInt("id"))
                        .withEditor(resultSet.getString("editor"))
                        .withAuthor(resultSet.getString("author"))
                        .withYearEdition(resultSet.getInt("year_edition"))
                        .withAge(resultSet.getString("age"))
                        .withMinPlayers(resultSet.getInt("min_players"))
                        .withMaxPlayers(resultSet.getInt("max_players"))
                        .withPlayDuration(resultSet.getString("play_duration"))
                        .withPrice(resultSet.getFloat("price"))
                        .withImage(resultSet.getString("image"))
                        .withCategory(category)
                        .withDifficulty(difficulty)
                        .build());
            }
            games.sort((g1, g2) -> g1.getGameName().compareTo(g2.getGameName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }
/*
    public Connection createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/games"
                , "root",
                "");
    }

 */
}
