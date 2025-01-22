package service;


import java.sql.Connection;
import java.sql.SQLException;
import database.SQLConnection;
import dao.OrderItemsDAO;
import model.OrderItems;

/**
 * The OrderItemsService class provides business logic and operations related to managing order items.
 * It uses the OrderItemsDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class OrderItemsService {

    public void insertOrderItem(OrderItems orderItem) {
        try (Connection connection = SQLConnection.getConnection()) {
            OrderItemsDAO orderItemsDAO = new OrderItemsDAO(connection);
            orderItemsDAO.insertOrderItem(orderItem);
            if (orderItem.getOrderItemId() > 0) {
            } else {
                System.out.println("Failed to retrieve the Order Item ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderItem(OrderItems orderItem) {
        try (Connection connection = SQLConnection.getConnection()) {
            OrderItemsDAO orderItemsDAO = new OrderItemsDAO(connection);
            orderItemsDAO.updateOrderItem(orderItem);
            System.out.println("Order item updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public OrderItems selectOrderItem(int orderItemId) {
        try (Connection connection = SQLConnection.getConnection()) {
            OrderItemsDAO orderItemsDAO = new OrderItemsDAO(connection);
            return orderItemsDAO.selectOrderItem(orderItemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteOrderItem(int orderItemId) {
        try (Connection connection = SQLConnection.getConnection()) {
            OrderItemsDAO orderItemsDAO = new OrderItemsDAO(connection);
            orderItemsDAO.deleteOrderItem(orderItemId);
            System.out.println("Order item deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

