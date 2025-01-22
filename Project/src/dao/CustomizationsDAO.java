package dao;

import model.Customizations;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The CustomizationsDAO class provides data access methods for managing the Customizations table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */

public class CustomizationsDAO {
    private Connection connection;

    public CustomizationsDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertCustomizations(Customizations customization) throws SQLException {
        String query = "INSERT INTO Customizations (Order_ID, Subscription_ID) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, customization.getOrderId());
            stmt.setInt(2, customization.getSubscriptionId());
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        customization.setCustomizationId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating customization record failed, no ID obtained.");
                    }
                }
            }
        }
    }

    public Customizations selectCustomizations(int customizationId) throws SQLException {
        String query = "SELECT * FROM Customizations WHERE Customization_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customizationId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Customizations(
                        rs.getInt("Customization_ID"),
                        rs.getInt("Order_ID"),
                        rs.getInt("Subscription_ID")
                    );
                }
            }
        }
        return null;
    }

    public void updateCustomizations(Customizations customization) throws SQLException {
        String query = "UPDATE Customizations SET Order_ID = ?, Subscription_ID = ? WHERE Customization_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customization.getOrderId());
            stmt.setInt(2, customization.getSubscriptionId());
            stmt.setInt(3, customization.getCustomizationId());
            stmt.executeUpdate();
        }
    }

    public void deleteCustomizations(int customizationId) throws SQLException {
        String query = "DELETE FROM Customizations WHERE Customization_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customizationId);
            stmt.executeUpdate();
        }
    }

    public List<Customizations> selectAllCustomizations() throws SQLException {
        List<Customizations> customizationsList = new ArrayList<>();
        String query = "SELECT * FROM Customizations";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Customizations customizations = new Customizations(
                    rs.getInt("Customization_ID"),
                    rs.getInt("Order_ID"),
                    rs.getInt("Subscription_ID")
                );
                customizationsList.add(customizations);
            }
        }
        return customizationsList;
    }
}
