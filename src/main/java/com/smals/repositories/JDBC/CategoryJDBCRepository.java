package com.smals.repositories.JDBC;

import com.smals.domain.Category;
import com.smals.repositories.utils.JDBCConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoryJDBCRepository {

    private static final CategoryJDBCRepository instance = new CategoryJDBCRepository();

    public static CategoryJDBCRepository getInstance() {
        return instance;
    }

    public Category getGameCategory(int id) {
        try (PreparedStatement preparedStatement = JDBCConnector.createConnection().prepareStatement("select * from Category where id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Category(resultSet.getString("category_name"), resultSet.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
