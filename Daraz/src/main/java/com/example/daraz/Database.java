package com.example.daraz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
        private static final String URL = "jdbc:mysql://localhost:3306/stores";
    private static final String USER = "root";
    private static final String PASSWORD = "fxkyou606!";

    private Connection connection;

    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        connect();
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public Connection getConnection() {
        return connection;
    }
}
