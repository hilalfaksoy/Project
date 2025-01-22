package dao;

import model.UserProfiles;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The UserProfilesDAO class provides data access methods for managing the User_Profiles table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */


public class UserProfilesDAO {
    private Connection connection;

    public UserProfilesDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertUserProfile(UserProfiles userProfile) throws SQLException {
        String query = "INSERT INTO User_Profiles (User_ID, Address, Phone_Number) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userProfile.getUserId());
            stmt.setString(2, userProfile.getAddress());
            stmt.setString(3, userProfile.getPhoneNumber());
            stmt.executeUpdate();
        }
    }

    public UserProfiles selectUserProfile(int profileId) throws SQLException {
        String query = "SELECT * FROM User_Profiles WHERE Profile_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, profileId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UserProfiles(
                        rs.getInt("Profile_ID"),
                        rs.getInt("User_ID"),
                        rs.getString("Address"),
                        rs.getString("Phone_Number")
                    );
                }
            }
        }
        return null;
    }

    public void updateUserProfile(UserProfiles userProfile) throws SQLException {
        String query = "UPDATE User_Profiles SET User_ID = ?, Address = ?, Phone_Number = ? WHERE Profile_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userProfile.getUserId());
            stmt.setString(2, userProfile.getAddress());
            stmt.setString(3, userProfile.getPhoneNumber());
            stmt.setInt(4, userProfile.getProfileId());
            stmt.executeUpdate();
        }
    }

    public void deleteUserProfile(int profileId) throws SQLException {
        String query = "DELETE FROM User_Profiles WHERE Profile_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, profileId);
            stmt.executeUpdate();
        }
    }

    public List<UserProfiles> selectAllUserProfiles() throws SQLException {
        List<UserProfiles> userProfileList = new ArrayList<>();
        String query = "SELECT * FROM User_Profiles";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                UserProfiles userProfile = new UserProfiles(
                    rs.getInt("Profile_ID"),
                    rs.getInt("User_ID"),
                    rs.getString("Address"),
                    rs.getString("Phone_Number")
                );
                userProfileList.add(userProfile);
            }
        }
        return userProfileList;
    }
}
