package com.smals.repositories;

import com.smals.domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameJDBCRepository {

    private static final GameJDBCRepository instance = new GameJDBCRepository();

    public static GameJDBCRepository getInstance() {
        return instance;
    }

    public Category getGameCategory(int id) {
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from Category where id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                return new Category(resultSet.getString("category_name"), resultSet.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Game getGame(int id){
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from Game as g " +
                "LEFT OUTER JOIN Category as c ON c.id = g.category_id " +
                "LEFT OUTER JOIN Difficulty as d ON d.id = g.difficulty_id " +
                "where g.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                Category category = new Category(resultSet.getString("c.category_name"), resultSet.getInt("c.id"));
                Difficulty difficulty = new Difficulty(resultSet.getString("d.difficulty_name"), resultSet.getInt("id"));
                Game game = new Game(resultSet.getInt("id"), resultSet.getString("game_name"), resultSet.getString("editor"), resultSet.getString("author"), resultSet.getInt("year_edition"), resultSet.getString("age"), resultSet.getInt("min_players"), resultSet.getInt("max_players"), resultSet.getString("play_duration"), resultSet.getFloat("price"), resultSet.getString("image"), category, difficulty);
                return game;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Borrower getBorrower(int id) {
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from Borrower where id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                return new Borrower(resultSet.getString("borrower_name"), resultSet.getString("city"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Game getGameByName(String gameName) {
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from Game as g " +
                "LEFT OUTER JOIN Category as c ON c.id = g.category_id " +
                "LEFT OUTER JOIN Difficulty as d ON d.id = g.difficulty_id " +
                "where g.game_name LIKE ?")) {
            preparedStatement.setString(1, "%" + gameName + "%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                Category category = new Category(resultSet.getString("c.category_name"), resultSet.getInt("c.id"));
                Difficulty difficulty = new Difficulty(resultSet.getString("d.difficulty_name"), resultSet.getInt("id"));
                Game game = new Game(resultSet.getInt("id"), resultSet.getString("game_name"), resultSet.getString("editor"), resultSet.getString("author"), resultSet.getInt("year_edition"), resultSet.getString("age"), resultSet.getInt("min_players"), resultSet.getInt("max_players"), resultSet.getString("play_duration"), resultSet.getFloat("price"), resultSet.getString("image"), category, difficulty);
                return game;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<Game>();
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from Game as g " +
                "LEFT OUTER JOIN Category as c ON c.id = g.category_id " +
                "LEFT OUTER JOIN Difficulty as d ON d.id = g.difficulty_id ")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                Category category = new Category(resultSet.getString("c.category_name"), resultSet.getInt("c.id"));
                Difficulty difficulty = new Difficulty(resultSet.getString("d.difficulty_name"), resultSet.getInt("id"));
                Game game = new Game(resultSet.getInt("id"), resultSet.getString("game_name"), resultSet.getString("editor"), resultSet.getString("author"), resultSet.getInt("year_edition"), resultSet.getString("age"), resultSet.getInt("min_players"), resultSet.getInt("max_players"), resultSet.getString("play_duration"), resultSet.getFloat("price"), resultSet.getString("image"), category, difficulty);
                games.add(game);
            }
            games.sort((g1, g2) -> g1.getGameName().compareTo(g2.getGameName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

    public List<Borrow> getAllBorrow() {
        List<Borrow> borrows = new ArrayList<Borrow>();
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from Borrow as b " +
                "LEFT OUTER JOIN Game as g ON g.id = b.game_id " +
                "LEFT OUTER JOIN Borrower as b2 ON b2.id = b.borrower_id ")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                Game game = new Game(resultSet.getString("g.game_name"));
                Borrower borrower = new Borrower(resultSet.getString("b2.borrower_name"));
                Borrow borrow = new Borrow(resultSet.getInt("id"), game, borrower, resultSet.getDate("borrow_date"), resultSet.getDate("return_date"));
                borrows.add(borrow);
            }

            borrows = borrows.stream()
                            .sorted(Comparator.comparing(Borrow::getBorrowDate))
                            .sorted((b1, b2) -> b1.getBorrower().getBorrowerName().compareToIgnoreCase(b2.getBorrower().getBorrowerName()))
                            .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrows;
    }

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
}
