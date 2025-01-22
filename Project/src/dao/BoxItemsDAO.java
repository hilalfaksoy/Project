package dao;

import model.BoxItems;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The BoxItemsDAO class provides data access methods for managing the Box_Items table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */

public class BoxItemsDAO {
    private Connection connection;

    public BoxItemsDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertBoxItem(BoxItems boxItem) throws SQLException {
        String query = "INSERT INTO Box_Items (Box_ID, Product_ID, Quantity) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, boxItem.getBoxId());
            stmt.setInt(2, boxItem.getProductId());
            stmt.setInt(3, boxItem.getQuantity());
            stmt.executeUpdate();
        }
    }

    public BoxItems selectBoxItem(int boxItemId) throws SQLException {
        String query = "SELECT * FROM Box_Items WHERE Box_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, boxItemId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new BoxItems(
                        rs.getInt("Box_Item_ID"),
                        rs.getInt("Box_ID"),
                        rs.getInt("Product_ID"),
                        rs.getInt("Quantity")
                    );
                }
            }
        }
        return null;
    }

    public void updateBoxItem(BoxItems boxItem) throws SQLException {
        String query = "UPDATE Box_Items SET Box_ID = ?, Product_ID = ?, Quantity = ? WHERE Box_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, boxItem.getBoxId());
            stmt.setInt(2, boxItem.getProductId());
            stmt.setInt(3, boxItem.getQuantity());
            stmt.setInt(4, boxItem.getBoxItemId());
            stmt.executeUpdate();
        }
    }

    public void deleteBoxItem(int boxItemId) throws SQLException {
        String query = "DELETE FROM Box_Items WHERE Box_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, boxItemId);
            stmt.executeUpdate();
        }
    }

    public List<BoxItems> selectAllBoxItems() throws SQLException {
        List<BoxItems> boxItemsList = new ArrayList<>();
        String query = "SELECT * FROM Box_Items";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                BoxItems boxItem = new BoxItems(
                    rs.getInt("Box_Item_ID"),
                    rs.getInt("Box_ID"),
                    rs.getInt("Product_ID"),
                    rs.getInt("Quantity")
                );
                boxItemsList.add(boxItem);
            }
        }
        return boxItemsList;
    }
    
    
    public List<BoxItems> selectBoxItemsByBoxId(int boxId) throws SQLException {
        List<BoxItems> boxItemsList = new ArrayList<>();
        String query = "SELECT * FROM Box_Items WHERE Box_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, boxId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    BoxItems boxItem = new BoxItems(
                        rs.getInt("Box_Item_ID"),
                        rs.getInt("Box_ID"),
                        rs.getInt("Product_ID"),
                        rs.getInt("Quantity")
                    );
                    boxItemsList.add(boxItem);
                }
            }
        }
        return boxItemsList;
    }    
    
    
}

