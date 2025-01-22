package service;

import java.sql.Connection;
import java.sql.SQLException;
import database.SQLConnection;
import dao.BoxesDAO;
import model.Boxes;

/**
 * The BoxesService class provides business logic and operations related to managing boxes.
 * It uses the BoxesDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class BoxesService {

    public void insertBox(Boxes box) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxesDAO boxesDAO = new BoxesDAO(connection);
            boxesDAO.insertBox(box);
            if (box.getBoxId() > 0) {
                System.out.println("User inserted successfully with ID: " + box.getBoxId());
            } else {
                System.out.println("Failed to retrieve the User ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBox(Boxes box) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxesDAO boxesDAO = new BoxesDAO(connection);
            boxesDAO.updateBox(box);
            System.out.println("Box updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boxes selectBox(int boxId) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxesDAO boxesDAO = new BoxesDAO(connection);
            return boxesDAO.selectBox(boxId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBox(int boxId) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxesDAO boxesDAO = new BoxesDAO(connection);
            boxesDAO.deleteBox(boxId);
            System.out.println("Box deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Retrieves the Box ID based on box type and pet type
    public int getBoxIdByTypeAndPetType(String boxType, String petType) throws SQLException {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxesDAO boxesDAO = new BoxesDAO(connection);
            return boxesDAO.getBoxIdByTypeAndPetType(boxType, petType);
        }
    }
    
    // Calculates the total amount based on the box ID
    public double calculateTotalAmount(int boxId) throws SQLException {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxesDAO boxesDAO = new BoxesDAO(connection);
            return boxesDAO.calculateTotalAmount(boxId);
        }
    }

    // Retrieves the item price based on the product ID
    public double getItemPrice(int productId) throws SQLException {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxesDAO boxesDAO = new BoxesDAO(connection);
            return boxesDAO.getItemPrice(productId);
        }
    }
}
