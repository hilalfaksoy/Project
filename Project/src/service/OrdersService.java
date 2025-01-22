package service;

import java.sql.Connection;
import java.sql.SQLException;
import database.SQLConnection;
import dao.OrdersDAO;
import model.Orders;

/**
 * The OrdersService class provides business logic and operations related to managing orders.
 * It uses the OrdersDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class OrdersService {

    public void insertOrder(Orders order) {
        try (Connection connection = SQLConnection.getConnection()) {
            OrdersDAO ordersDAO = new OrdersDAO(connection);
            ordersDAO.insertOrder(order);
            if (order.getOrderId() > 0) {
            } else {
                System.out.println("Failed to retrieve the Order ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(Orders order) {
        try (Connection connection = SQLConnection.getConnection()) {
            OrdersDAO ordersDAO = new OrdersDAO(connection);
            ordersDAO.updateOrder(order);
            System.out.println("Order updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Orders selectOrder(int orderId) {
        try (Connection connection = SQLConnection.getConnection()) {
            OrdersDAO ordersDAO = new OrdersDAO(connection);
            return ordersDAO.selectOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteOrder(int orderId) {
        try (Connection connection = SQLConnection.getConnection()) {
            OrdersDAO ordersDAO = new OrdersDAO(connection);
            ordersDAO.deleteOrder(orderId);
            System.out.println("Order deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
