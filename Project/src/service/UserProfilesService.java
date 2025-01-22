package service;

import java.sql.Connection;
import java.sql.SQLException;
import database.SQLConnection;
import dao.UserProfilesDAO;
import model.UserProfiles;

/**
 * The UserProfilesService class provides business logic and operations related to managing user profiles.
 * It uses the UserProfilesDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class UserProfilesService {

    public void insertUserProfile(UserProfiles userProfile) {
        try (Connection connection = SQLConnection.getConnection()) {
            UserProfilesDAO userProfilesDAO = new UserProfilesDAO(connection);
            userProfilesDAO.insertUserProfile(userProfile);
            System.out.println("User profile inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserProfile(UserProfiles userProfile) {
        try (Connection connection = SQLConnection.getConnection()) {
            UserProfilesDAO userProfilesDAO = new UserProfilesDAO(connection);
            userProfilesDAO.updateUserProfile(userProfile);
            System.out.println("User profile updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserProfiles selectUserProfile(int userProfileId) {
        try (Connection connection = SQLConnection.getConnection()) {
            UserProfilesDAO userProfilesDAO = new UserProfilesDAO(connection);
            return userProfilesDAO.selectUserProfile(userProfileId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUserProfile(int userProfileId) {
        try (Connection connection = SQLConnection.getConnection()) {
            UserProfilesDAO userProfilesDAO = new UserProfilesDAO(connection);
            userProfilesDAO.deleteUserProfile(userProfileId);
            System.out.println("User profile deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

