package service;

import java.sql.Connection;
import java.sql.SQLException;
import database.SQLConnection;
import dao.CustomizationsDAO;
import model.Customizations;

/**
 * The CustomizationsService class provides business logic and operations related to managing customizations.
 * It uses the CustomizationsDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class CustomizationsService {

    public void insertCustomization(Customizations customization) {
        try (Connection connection = SQLConnection.getConnection()) {
        	CustomizationsDAO customizationsDAO = new CustomizationsDAO(connection);
        	customizationsDAO.insertCustomizations(customization);
            //System.out.println("Customization inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomization(Customizations customization) {
        try (Connection connection = SQLConnection.getConnection()) {
        	CustomizationsDAO customizationsDAO = new CustomizationsDAO(connection);
        	customizationsDAO.updateCustomizations(customization);
            System.out.println("Customization updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customizations selectCustomization(int customizationId) {
        try (Connection connection = SQLConnection.getConnection()) {
        	CustomizationsDAO customizationsDAO = new CustomizationsDAO(connection);
            return customizationsDAO.selectCustomizations(customizationId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCustomization(int customizationId) {
        try (Connection connection = SQLConnection.getConnection()) {
        	CustomizationsDAO customizationsDAO = new CustomizationsDAO(connection);
        	customizationsDAO.deleteCustomizations(customizationId);
            System.out.println("Customization deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
