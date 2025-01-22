package service;

import java.sql.Connection;
import java.sql.SQLException;
import database.SQLConnection;
import dao.UsersDAO;
import model.Users;

/**
 * The UsersService class provides business logic and operations related to managing users.
 * It uses the UsersDAO class to interact with the database and perform CRUD operations.
 * 
 */

public class UsersService {

	public void insertUser(Users user) {
	    try (Connection connection = SQLConnection.getConnection()) {
	        UsersDAO usersDAO = new UsersDAO(connection);
	        usersDAO.insertUser(user);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


    public void updateUser(Users user) {
        try (Connection connection = SQLConnection.getConnection()) {
            UsersDAO usersDAO = new UsersDAO(connection);
            usersDAO.updateUser(user);
            System.out.println("User updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Users selectUser(int userId) {
        try (Connection connection = SQLConnection.getConnection()) {
            UsersDAO usersDAO = new UsersDAO(connection);
            return usersDAO.selectUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Users selectUserByEmail(String email) throws SQLException {
    	try (Connection connection = SQLConnection.getConnection()) {
    	UsersDAO usersDAO = new UsersDAO(connection);
        return usersDAO.selectUserByEmail(email);}
    }
    
    
    public Users selectUserByUsernameOrEmailAndPassword(String usernameOrEmail, String password) {
        try (Connection connection = SQLConnection.getConnection()) {
            UsersDAO usersDAO = new UsersDAO(connection);
            return usersDAO.selectUserByUsernameOrEmailAndPassword(usernameOrEmail, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

    public void deleteUser(int userId) {
        try (Connection connection = SQLConnection.getConnection()) {
            UsersDAO usersDAO = new UsersDAO(connection);
            usersDAO.deleteUser(userId);
            System.out.println("User deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

