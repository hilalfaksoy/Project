package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp; // Correct import
import database.SQLConnection;
import dao.SubscriptionsDAO;
import model.Subscriptions;
import utils.DateUtils;

/**
 * The SubscriptionsService class provides business logic and operations related to managing subscriptions.
 * It uses the SubscriptionsDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class SubscriptionsService {

	public void insertSubscription(Subscriptions subscription) {
        try (Connection connection = SQLConnection.getConnection()) {
            Timestamp endDate = DateUtils.calculateEndDate(subscription.getSubscriptionType(), subscription.getStartDate());
            subscription.setEndDate(endDate);

            SubscriptionsDAO subscriptionsDAO = new SubscriptionsDAO(connection);
            subscriptionsDAO.insertSubscription(subscription);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void updateSubscription(Subscriptions subscription) {
        try (Connection connection = SQLConnection.getConnection()) {
            Timestamp endDate = DateUtils.calculateEndDate(subscription.getSubscriptionType(), subscription.getStartDate());
            subscription.setEndDate(endDate);

            SubscriptionsDAO subscriptionsDAO = new SubscriptionsDAO(connection);
            subscriptionsDAO.updateSubscription(subscription);
            System.out.println("Subscription updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Subscriptions selectSubscription(int subscriptionId) {
        try (Connection connection = SQLConnection.getConnection()) {
            SubscriptionsDAO subscriptionsDAO = new SubscriptionsDAO(connection);
            return subscriptionsDAO.selectSubscription(subscriptionId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteSubscription(int subscriptionId) {
        try (Connection connection = SQLConnection.getConnection()) {
            SubscriptionsDAO subscriptionsDAO = new SubscriptionsDAO(connection);
            subscriptionsDAO.deleteSubscription(subscriptionId);
            System.out.println("Subscription deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

