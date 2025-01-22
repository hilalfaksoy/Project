package dao;

import model.Products;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The ProductsDAO class provides data access methods for managing the Products table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */

public class ProductsDAO {
    private Connection connection;

    public ProductsDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new product into the database
    public void insertProduct(Products product) throws SQLException {
        String query = "INSERT INTO Products (Product_Name, Description, Price, Category, Pet_Type, Quantity, Create_Time, Update_Time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getCategory());
            stmt.setString(5, product.getPetType());
            stmt.setInt(6, product.getQuantity());
            stmt.setTimestamp(7, product.getCreateTime());
            stmt.setTimestamp(8, product.getUpdateTime());
            stmt.executeUpdate();
        }
    }

    // Select a product by its ID
    public Products selectProduct(int productId) throws SQLException {
        String query = "SELECT * FROM Products WHERE Product_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, productId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Products(
                        rs.getInt("Product_ID"),
                        rs.getString("Product_Name"),
                        rs.getString("Description"),
                        rs.getDouble("Price"),
                        rs.getString("Category"),
                        rs.getString("Pet_Type"),
                        rs.getInt("Quantity"),
                        rs.getTimestamp("Create_Time"),
                        rs.getTimestamp("Update_Time")
                    );
                }
            }
        }
        return null;
    }

    // Update an existing product in the database
    public void updateProduct(Products product) throws SQLException {
        String query = "UPDATE Products SET Product_Name = ?, Description = ?, Price = ?, Category = ?, Pet_Type = ?, Quantity = ?, Create_Time = ?, Update_Time = ? WHERE Product_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getCategory());
            stmt.setString(5, product.getPetType());
            stmt.setInt(6, product.getQuantity());
            stmt.setTimestamp(7, product.getCreateTime());
            stmt.setTimestamp(8, product.getUpdateTime());
            stmt.setInt(9, product.getProductId());
            stmt.executeUpdate();
        }
    }

    // Delete a product by its ID
    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM Products WHERE Product_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        }
    }

    // Select all products from the database
    public List<Products> selectAllProducts() throws SQLException {
        List<Products> productList = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Products product = new Products(
                    rs.getInt("Product_ID"),
                    rs.getString("Product_Name"),
                    rs.getString("Description"),
                    rs.getDouble("Price"),
                    rs.getString("Category"),
                    rs.getString("Pet_Type"),
                    rs.getInt("Quantity"),
                    rs.getTimestamp("Create_Time"),
                    rs.getTimestamp("Update_Time")
                );
                productList.add(product);
            }
        }
        return productList;
    }
 
    /**
     * Updates the quantity of a product in the database by decrementing it.
     * This method reduces the quantity of the specified product by the given amount.
     * It throws an exception if no rows are affected, indicating that the update failed.
     * 
     * @param productId the ID of the product whose quantity needs to be updated
     * @param quantityToDecrease the amount by which to decrease the product's quantity
     * @throws SQLException if a database access error occurs or if no rows are affected
     */
    public void updateProductQuantity(int productId, int quantityToDecrease) throws SQLException {
        String query = "UPDATE Products SET Quantity = Quantity - ? WHERE Product_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quantityToDecrease);
            stmt.setInt(2, productId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating product quantity failed, no rows affected.");
            }
        }
    }
}


