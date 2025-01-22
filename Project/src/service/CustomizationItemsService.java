package service;

import java.sql.Connection;
import java.sql.SQLException;
import database.SQLConnection;
import dao.CustomizationItemsDAO;
import model.CustomizationItems;

/**
 * The CustomizationItemsService class provides business logic and operations related to managing customization items.
 * It uses the CustomizationItemsDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class CustomizationItemsService {

    public void insertCustomizationItem(CustomizationItems customizationItem) {
        try (Connection connection = SQLConnection.getConnection()) {
        	CustomizationItemsDAO customizationItemsDAO = new CustomizationItemsDAO(connection);
        	customizationItemsDAO.insertCustomizationItems(customizationItem);
            System.out.println("Customization item inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomizationItem(CustomizationItems customizationItem) {
        try (Connection connection = SQLConnection.getConnection()) {
        	CustomizationItemsDAO customizationItemsDAO = new CustomizationItemsDAO(connection);
        	customizationItemsDAO.updateCustomizationItems(customizationItem);
            System.out.println("Customization item updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CustomizationItems selectCustomizationItem(int customizationItemId) {
        try (Connection connection = SQLConnection.getConnection()) {
        	CustomizationItemsDAO customizationItemsDAO = new CustomizationItemsDAO(connection);
            return customizationItemsDAO.selectCustomizationItems(customizationItemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCustomizationItem(int customizationItemId) {
        try (Connection connection = SQLConnection.getConnection()) {
        	CustomizationItemsDAO customizationItemsDAO = new CustomizationItemsDAO(connection);
        	customizationItemsDAO.deleteCustomizationItems(customizationItemId);
            System.out.println("Customization deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
