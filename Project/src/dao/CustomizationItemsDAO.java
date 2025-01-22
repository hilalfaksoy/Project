package dao;

import model.CustomizationItems;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The CustomizationItemsDAO class provides data access methods for managing the Customization_Items table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */

public class CustomizationItemsDAO {
    private Connection connection;

    public CustomizationItemsDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertCustomizationItems(CustomizationItems customizationItems) throws SQLException {
        String query = "INSERT INTO Customization_Items (Customization_ID, Added_Product_ID, Removed_Product_ID) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customizationItems.getCustomizationId());
            stmt.setObject(5, customizationItems.getAddedProductId(), Types.INTEGER);
            stmt.setObject(6, customizationItems.getRemovedProductId(), Types.INTEGER);
            stmt.executeUpdate();
        }
    }

    public CustomizationItems selectCustomizationItems(int customizationItemId) throws SQLException {
        String query = "SELECT * FROM Customization_Items WHERE Customization_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customizationItemId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CustomizationItems(
                    	rs.getInt("Customization_Item_ID"),
                        rs.getInt("Customization_ID"),
                        rs.getObject("Added_Product_ID", Integer.class),
                        rs.getObject("Removed_Product_ID", Integer.class)
                    );
                }
            }
        }
        return null;
    }

    public void updateCustomizationItems(CustomizationItems customizationItems) throws SQLException {
        String query = "UPDATE Customization_Items SET Customization_ID = ?, Added_Product_ID = ?, Removed_Product_ID = ? WHERE Customization_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customizationItems.getCustomizationId());
            stmt.setObject(5, customizationItems.getAddedProductId(), Types.INTEGER);
            stmt.setObject(6, customizationItems.getRemovedProductId(), Types.INTEGER);
            stmt.setInt(8, customizationItems.getCustomizationItemId());
            stmt.executeUpdate();
        }
    }

    public void deleteCustomizationItems(int customizationItemId) throws SQLException {
        String query = "DELETE FROM Customization_Items WHERE Customization_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customizationItemId);
            stmt.executeUpdate();
        }
    }

    public List<CustomizationItems> selectAllCustomizationItems() throws SQLException {
        List<CustomizationItems> customizationItemsList = new ArrayList<>();
        String query = "SELECT * FROM Customization_Items";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
            	CustomizationItems customizationItems = new CustomizationItems(
                    rs.getInt("Customization_Item_ID"),
                    rs.getInt("Customization_ID"),
                    rs.getObject("Added_Product_ID", Integer.class),
                    rs.getObject("Removed_Product_ID", Integer.class)
                );
            	customizationItemsList.add(customizationItems);
            }
        }
        return customizationItemsList;
    }
}

