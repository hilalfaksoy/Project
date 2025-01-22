package dao;

import model.OrderItems;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The OrderItemsDAO class provides data access methods for managing the Order_Items table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */

public class OrderItemsDAO {
    private Connection connection;

    public OrderItemsDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertOrderItem(OrderItems orderItem) throws SQLException {
        String query = "INSERT INTO Order_Items (Order_ID, Product_ID, Quantity, Price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, orderItem.getOrderId());
            stmt.setInt(2, orderItem.getProductId());
            stmt.setInt(3, orderItem.getQuantity());
            stmt.setDouble(4, orderItem.getPrice());
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                    	orderItem.setOrderItemId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating order item failed, no ID obtained.");
                    }
                }
            }
        }
    }

    public OrderItems selectOrderItem(int orderItemId) throws SQLException {
        String query = "SELECT * FROM Order_Items WHERE Order_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderItemId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new OrderItems(
                        rs.getInt("Order_Item_ID"),
                        rs.getInt("Order_ID"),
                        rs.getInt("Product_ID"),
                        rs.getInt("Quantity"),
                        rs.getDouble("Price")
                    );
                }
            }
        }
        return null;
    }

    public void updateOrderItem(OrderItems orderItem) throws SQLException {
        String query = "UPDATE Order_Items SET Order_ID = ?, Product_ID = ?, Quantity = ?, Price = ? WHERE Order_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderItem.getOrderId());
            stmt.setInt(2, orderItem.getProductId());
            stmt.setInt(3, orderItem.getQuantity());
            stmt.setDouble(4, orderItem.getPrice());
            stmt.setInt(5, orderItem.getOrderItemId());
            stmt.executeUpdate();
        }
    }

    public void deleteOrderItem(int orderItemId) throws SQLException {
        String query = "DELETE FROM Order_Items WHERE Order_Item_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderItemId);
            stmt.executeUpdate();
        }
    }

    public List<OrderItems> selectAllOrderItems() throws SQLException {
        List<OrderItems> orderItemsList = new ArrayList<>();
        String query = "SELECT * FROM Order_Items";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                OrderItems orderItem = new OrderItems(
                    rs.getInt("Order_Item_ID"),
                    rs.getInt("Order_ID"),
                    rs.getInt("Product_ID"),
                    rs.getInt("Quantity"),
                    rs.getDouble("Price")
                );
                orderItemsList.add(orderItem);
            }
        }
        return orderItemsList;
    }
}
