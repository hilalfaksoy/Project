package dao;


import model.Users;
import utils.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The UsersDAO class provides data access methods for managing the Users table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */

public class UsersDAO {
    private Connection connection;

    public UsersDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertUser(Users user) throws SQLException {
        String query = "INSERT INTO Users (Username, Password, Email, First_Name, Last_Name, Is_Admin) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, StringUtils.capitalizeFirstLetter(user.getFirstName()));
            stmt.setString(5, StringUtils.capitalizeFirstLetter(user.getLastName()));
            stmt.setBoolean(6, user.isAdmin());
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            }
        }
    }


    public Users selectUser(int userId) throws SQLException {
        String query = "SELECT * FROM Users WHERE User_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Users(
                        rs.getInt("User_ID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getTimestamp("Creat_Time"),
                        rs.getTimestamp("Update_Time"),
                        rs.getBoolean("Is_Admin")
                    );
                }
            }
        }
        return null;
    }

    public void updateUser(Users user) throws SQLException {
        String query = "UPDATE Users SET Username = ?, Password = ?, Email = ?, First_Name = ?, Last_Name = ?, Is_Admin = ?, Update_Time = CURRENT_TIMESTAMP WHERE User_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getFirstName());
            stmt.setString(5, user.getLastName());
            stmt.setBoolean(6, user.isAdmin());
            stmt.setInt(7, user.getUserId());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM Users WHERE User_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }

    public List<Users> selectAllUsers() throws SQLException {
        List<Users> usersList = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Users user = new Users(
                    rs.getInt("User_ID"),
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("Email"),
                    rs.getString("First_Name"),
                    rs.getString("Last_Name"),
                    rs.getTimestamp("Creat_Time"),
                    rs.getTimestamp("Update_Time"),
                    rs.getBoolean("Is_Admin")
                );
                usersList.add(user);
            }
        }
        return usersList;
    }
    
    public Users selectUserByUsernameOrEmailAndPassword(String usernameOrEmail, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usernameOrEmail);
            stmt.setString(2, usernameOrEmail);
            stmt.setString(3, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Users user = new Users();
                    user.setUserId(rs.getInt("User_ID"));
                    user.setUserName(rs.getString("Username"));
                    user.setPassword(rs.getString("Password"));
                    user.setEmail(rs.getString("Email"));
                    user.setFirstName(rs.getString("First_Name"));
                    user.setLastName(rs.getString("Last_Name"));
                    user.setAdmin(rs.getBoolean("Is_Admin"));
                    return user;
                }
            }
        }
        return null;
    }
    
    
    public Users selectUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Users user = new Users();
                    user.setUserId(rs.getInt("User_ID"));
                    user.setUserName(rs.getString("Username"));
                    user.setPassword(rs.getString("Password"));
                    user.setEmail(rs.getString("Email"));
                    user.setFirstName(rs.getString("First_Name"));
                    user.setLastName(rs.getString("Last_Name"));
                    user.setAdmin(rs.getBoolean("Is_Admin"));
                    return user;
                }
            }
        }
        return null;
    }
    
}
