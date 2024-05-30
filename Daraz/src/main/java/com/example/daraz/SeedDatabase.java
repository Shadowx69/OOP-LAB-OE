package com.example.daraz;

import java.util.ArrayList;
import java.util.List;

public class SeedDatabase {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<Products> products = new ArrayList<>();

        products.add(new Products(1, "OXVA", 10.99, "file:images/1.jpg"));
        products.add(new Products(2, "Caliburn", 20.99, "file:images/2.jpg"));
        products.add(new Products(3, "Caliburn", 30.99, "file:images/3.jpg"));
        products.add(new Products(4, "Argus", 40.99, "file:images/4.jpg"));
        products.add(new Products(5, "Voopoo", 50.99, "file:images/5.jpg"));

        productDAO.insertProducts(products);
        System.out.println("Products inserted successfully!");
    }
}

