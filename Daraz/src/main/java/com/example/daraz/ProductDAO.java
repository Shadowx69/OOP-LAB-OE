package com.example.daraz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAO {
    private Database dbConnector;

    public ProductDAO() {
        dbConnector = new Database();
    }

    public List<Products> getAllProducts() {
        List<Products> products = new ArrayList<>();
        try {
            String query = "SELECT * FROM products";
            ResultSet resultSet = dbConnector.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String imageUrl = resultSet.getString("image_url");
                products.add(new Products(id, name, price, imageUrl));
            }

            dbConnector.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void insertProducts(List<Products> products) {
        String query = "INSERT INTO products (name, price, image_url) VALUES (?, ?, ?)";
        try {
            dbConnector.connect();
            Connection connection = dbConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (Products product : products) {
                preparedStatement.setInt(1, product.getId());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setDouble(3, product.getPrice());
                preparedStatement.setString(4, product.getImageUrl());
                preparedStatement.executeUpdate();
            }
            preparedStatement.executeBatch();
            dbConnector.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
