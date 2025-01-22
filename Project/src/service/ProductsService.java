package service;

import java.sql.Connection;
import java.sql.SQLException;
import database.SQLConnection;
import dao.ProductsDAO;
import model.Products;

/**
 * The ProductsService class provides business logic and operations related to managing products.
 * It uses the ProductsDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class ProductsService {

    public void insertProduct(Products product) {
        try (Connection connection = SQLConnection.getConnection()) {
            ProductsDAO productsDAO = new ProductsDAO(connection);
            productsDAO.insertProduct(product);
            System.out.println("Product inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Products product) {
        try (Connection connection = SQLConnection.getConnection()) {
            ProductsDAO productsDAO = new ProductsDAO(connection);
            productsDAO.updateProduct(product);
            System.out.println("Product updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Products selectProduct(int productId) {
        try (Connection connection = SQLConnection.getConnection()) {
            ProductsDAO productsDAO = new ProductsDAO(connection);
            return productsDAO.selectProduct(productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteProduct(int productId) {
        try (Connection connection = SQLConnection.getConnection()) {
            ProductsDAO productsDAO = new ProductsDAO(connection);
            productsDAO.deleteProduct(productId);
            System.out.println("Product deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates the quantity of a product by decrementing it based on the quantity to decrease.
     * @param productId the ID of the product
     * @param quantityToDecrease the quantity to be decremented
     * @throws SQLException if a database access error occurs
     */
    public void updateProductQuantity(int productId, int quantityToDecrease) throws SQLException {
        try (Connection connection = SQLConnection.getConnection()) {
            ProductsDAO productsDAO = new ProductsDAO(connection);
            productsDAO.updateProductQuantity(productId, quantityToDecrease);
            //System.out.println("Product quantity updated successfully!");
        }
    }
}


