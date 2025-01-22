package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import database.SQLConnection;
import dao.BoxItemsDAO;
import model.BoxItems;

/**
 * The BoxItemsService class provides business logic and operations related to managing box items.
 * It uses the BoxItemsDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class BoxItemsService {

    public void insertBoxItem(BoxItems boxItem) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxItemsDAO boxItemsDAO = new BoxItemsDAO(connection);
            boxItemsDAO.insertBoxItem(boxItem);
            System.out.println("Box item inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBoxItem(BoxItems boxItem) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxItemsDAO boxItemsDAO = new BoxItemsDAO(connection);
            boxItemsDAO.updateBoxItem(boxItem);
            System.out.println("Box item updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BoxItems selectBoxItem(int boxItemId) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxItemsDAO boxItemsDAO = new BoxItemsDAO(connection);
            return boxItemsDAO.selectBoxItem(boxItemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBoxItem(int boxItemId) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxItemsDAO boxItemsDAO = new BoxItemsDAO(connection);
            boxItemsDAO.deleteBoxItem(boxItemId);
            System.out.println("Box item deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<BoxItems> getBoxItemsByBoxId(int boxId) {
        try (Connection connection = SQLConnection.getConnection()) {
            BoxItemsDAO boxItemsDAO = new BoxItemsDAO(connection);
            return boxItemsDAO.selectBoxItemsByBoxId(boxId); // Ensure this returns a List<BoxItems>
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
