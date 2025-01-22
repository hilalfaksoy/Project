package dao;

import model.Orders;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The OrdersDAO class provides data access methods for managing the Orders table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */

public class OrdersDAO {
    private Connection connection;

    public OrdersDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertOrder(Orders order) throws SQLException {
        String query = "INSERT INTO Orders (Subscription_ID, Box_ID, Shipping_Address, Total_Amount, Payment_Status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, order.getSubscriptionId());
            stmt.setInt(2, order.getBoxId());
            stmt.setString(3, "");
            stmt.setDouble(4, order.getTotalAmount());
            stmt.setString(5, order.getPaymentStatus());            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                    	order.setOrderId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating order failed, no ID obtained.");
                    }
                }
            }
        }
    }

    public Orders selectOrder(int orderId) throws SQLException {
        String query = "SELECT * FROM Orders WHERE Order_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Orders(
                        rs.getInt("Order_ID"),
                        rs.getInt("Subscription_ID"),
                        rs.getInt("Box_ID"),
                        rs.getTimestamp("Order_Date"),
                        rs.getString("Shipping_Address"),
                        rs.getDouble("Total_Amount"),
                        rs.getString("Payment_Status")
                    );
                }
            }
        }
        return null;
    }

    public void updateOrder(Orders order) throws SQLException {
        String query = "UPDATE Orders SET Subscription_ID = ?, Box_ID = ?, Shipping_Address = ?, Total_Amount = ?, Payment_Status = ?, Order_Date = CURRENT_TIMESTAMP WHERE Order_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, order.getSubscriptionId());
            stmt.setInt(2, order.getBoxId());
            stmt.setString(3, order.getShippingAddress());
            stmt.setDouble(4, order.getTotalAmount());
            stmt.setString(5, order.getPaymentStatus());
            stmt.setInt(6, order.getOrderId());
            stmt.executeUpdate();
        }
    }

    public void deleteOrder(int orderId) throws SQLException {
        String query = "DELETE FROM Orders WHERE Order_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        }
    }

    public List<Orders> selectAllOrders() throws SQLException {
        List<Orders> ordersList = new ArrayList<>();
        String query = "SELECT * FROM Orders";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Orders order = new Orders(
                    rs.getInt("Order_ID"),
                    rs.getInt("Subscription_ID"),
                    rs.getInt("Box_ID"),
                    rs.getTimestamp("Order_Date"),
                    rs.getString("Shipping_Address"),
                    rs.getDouble("Total_Amount"),
                    rs.getString("Payment_Status")
                );
                ordersList.add(order);
            }
        }
        return ordersList;
    }
}
