package com.example.daraz;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.TilePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.List;

public class HelloController {
    @FXML
    private TilePane tilePane;

    public void initialize() {
        ProductDAO productDAO = new ProductDAO();
        List<Products> products = productDAO.getAllProducts();

        for (Products product : products) {
            VBox vBox = createProductBox(product);
            tilePane.getChildren().add(vBox);
        }
    }

    private VBox createProductBox(Products product) {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(5);

        ImageView imageView = new ImageView(new Image(product.getImageUrl()));
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);

        Label nameLabel = new Label(product.getName());
        Label priceLabel = new Label("$" + product.getPrice());

        vBox.getChildren().addAll(imageView, nameLabel, priceLabel);
        return vBox;
    }
}

