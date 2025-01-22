package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 7/21/2024
 * Purpose:
 * This class provides utility methods for establishing a connection to the SQL Server database.
 */


public class SQLConnection {

    // Define the connection URL as a constant
    private static final String CONNECTION_URL =
            "jdbc:sqlserver://DESKTOP-T9U3SSQ\\SQLEXPRESS01:1433;"
            + "database=PETBOX;"
            + "integratedSecurity=true;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"
            + "loginTimeout=30;";

    /**
     * Gets a connection to the database.
     * 
     * @return A Connection object to the database.
     * @throws SQLException If a database access error occurs or the URL is incorrect.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL);
    }

    /**
     * Main method to test the connection to the database.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            // Code here
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
