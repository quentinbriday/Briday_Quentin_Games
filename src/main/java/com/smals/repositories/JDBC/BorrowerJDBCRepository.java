package com.smals.repositories.JDBC;

import com.smals.domain.Borrower;
import com.smals.repositories.utils.JDBCConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BorrowerJDBCRepository {

    private static final BorrowerJDBCRepository instance = new BorrowerJDBCRepository();

    public static BorrowerJDBCRepository getInstance() {
        return instance;
    }

    public Borrower getBorrower(int id) {
        try (PreparedStatement preparedStatement = JDBCConnector.createConnection().prepareStatement("select * from Borrower where id = ?")) {
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
}
