package com.example.servlet.repository;

import com.example.servlet.entity.ProductEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryOld {


    private ProductRepositoryOld() {

    }

    public static class ProductRepositoryHolder {
        public static final ProductRepositoryOld INSTANCE = new ProductRepositoryOld();
    }

    public static ProductRepositoryOld getInstance() {
        return ProductRepositoryHolder.INSTANCE;
    }

    public List<ProductEntity> getProducts() {
        final List<ProductEntity> productEntities = new ArrayList<>();
        try(Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_lesson", "postgres", "root");
            Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            while (resultSet.next()) {
                final long id = resultSet.getLong("id");
                final String title = resultSet.getString("title");
                final double price = resultSet.getDouble("price");
                productEntities.add(ProductEntity.builder().id(id).title(title).price(price).build());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productEntities;
    }

    public void addProduct(ProductEntity productEntity) {
//        products.add(productEntity);
    }
}
