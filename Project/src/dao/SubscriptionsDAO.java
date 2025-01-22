package dao;

import model.Subscriptions;
import utils.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The SubscriptionsDAO class provides data access methods for managing the Subscriptions table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */


public class SubscriptionsDAO {
    private Connection connection;

    public SubscriptionsDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertSubscription(Subscriptions subscription) throws SQLException {
        String query = "INSERT INTO Subscriptions (User_ID, Subscription_Type, Box_Type, Pet_Type, Start_Date, End_Date, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, subscription.getUserId());
            stmt.setString(2, StringUtils.capitalizeFirstLetter(subscription.getSubscriptionType()));
            stmt.setString(3, StringUtils.capitalizeFirstLetter(subscription.getBoxType()));
            stmt.setString(4, StringUtils.capitalizeFirstLetter(subscription.getPetType()));
            stmt.setTimestamp(5, subscription.getStartDate() != null ? subscription.getStartDate() : new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(6, subscription.getEndDate());
            stmt.setString(7, "Active");
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                    	subscription.setSubscriptionId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating subscription failed, no ID obtained.");
                    }
                }
            }
        }
    }
    

    public Subscriptions selectSubscription(int subscriptionId) throws SQLException {
        String query = "SELECT * FROM Subscriptions WHERE Subscription_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, subscriptionId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Subscriptions(
                        rs.getInt("Subscription_ID"),
                        rs.getInt("User_ID"),
                        rs.getString("Subscription_Type"),
                        rs.getString("Box_Type"),
                        rs.getString("Pet_Type"),
                        rs.getTimestamp("Start_Date"),
                        rs.getTimestamp("End_Date"),
                        rs.getTimestamp("Creat_Time"),
                        rs.getTimestamp("Update_Time"),
                        rs.getString("Status")
                    );
                }
            }
        }
        return null;
    }

    public void updateSubscription(Subscriptions subscription) throws SQLException {
        String query = "UPDATE Subscriptions SET User_ID = ?, Subscription_Type = ?, Box_Type = ?, Pet_Type = ?, Start_Date = ?, End_Date = ?, Update_Time = CURRENT_TIMESTAMP, Status = ? WHERE Subscription_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, subscription.getUserId());
            stmt.setString(2, subscription.getSubscriptionType());
            stmt.setString(3, StringUtils.capitalizeFirstLetter(subscription.getBoxType()));
            stmt.setString(4, StringUtils.capitalizeFirstLetter(subscription.getPetType()));
            stmt.setTimestamp(5, subscription.getStartDate());
            stmt.setTimestamp(6, subscription.getEndDate());
            stmt.setString(7, subscription.getStatus());
            stmt.setInt(8, subscription.getSubscriptionId());
            stmt.executeUpdate();
        }
    }

    public void deleteSubscription(int subscriptionId) throws SQLException {
        String query = "DELETE FROM Subscriptions WHERE Subscription_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, subscriptionId);
            stmt.executeUpdate();
        }
    }

    public List<Subscriptions> selectAllSubscriptions() throws SQLException {
        List<Subscriptions> subscriptionsList = new ArrayList<>();
        String query = "SELECT * FROM Subscriptions";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Subscriptions subscription = new Subscriptions(
                    rs.getInt("Subscription_ID"),
                    rs.getInt("User_ID"),
                    rs.getString("Subscription_Type"),
                    rs.getString("Box_Type"),
                    rs.getString("Pet_Type"),
                    rs.getTimestamp("Start_Date"),
                    rs.getTimestamp("End_Date"),
                    rs.getTimestamp("Creat_Time"),
                    rs.getTimestamp("Update_Time"),
                    rs.getString("Status")
                );
                subscriptionsList.add(subscription);
            }
        }
        return subscriptionsList;
    }
}

