package dao;

import model.Boxes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The BoxesDAO class provides data access methods for managing the Boxes table in the database.
 * It includes methods to insert, select, update, delete, and retrieve information about boxes.
 */

public class BoxesDAO {
    private Connection connection;

    public BoxesDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertBox(Boxes box) throws SQLException {
        String query = "INSERT INTO Boxes (Box_Type, Pet_Type, Month, Year) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, box.getBoxType());
            stmt.setString(2, box.getPetType());
            stmt.setInt(3, box.getMonth());
            stmt.setInt(4, box.getYear());
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        box.setBoxId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating box failed, no ID obtained.");
                    }
                }
            }
        }
    }

    public Boxes selectBox(int boxId) throws SQLException {
        String query = "SELECT * FROM Boxes WHERE Box_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, boxId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Boxes(
                        rs.getInt("Box_ID"),
                        rs.getString("Box_Type"),
                        rs.getString("Pet_Type"),
                        rs.getInt("Month"),
                        rs.getInt("Year"),
                        rs.getTimestamp("Create_Time"),
                        rs.getTimestamp("Update_Time")
                    );
                }
            }
        }
        return null;
    }

    public void updateBox(Boxes box) throws SQLException {
        String query = "UPDATE Boxes SET Box_Type = ?, Pet_Type = ?, Month = ?, Year = ?, Update_Time = CURRENT_TIMESTAMP WHERE Box_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, box.getBoxType());
            stmt.setString(2, box.getPetType());
            stmt.setInt(3, box.getMonth());
            stmt.setInt(4, box.getYear());
            stmt.setInt(5, box.getBoxId());
            stmt.executeUpdate();
        }
    }

    public void deleteBox(int boxId) throws SQLException {
        String query = "DELETE FROM Boxes WHERE Box_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, boxId);
            stmt.executeUpdate();
        }
    }

    public List<Boxes> selectAllBoxes() throws SQLException {
        List<Boxes> boxesList = new ArrayList<>();
        String query = "SELECT * FROM Boxes";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Boxes box = new Boxes(
                    rs.getInt("Box_ID"),
                    rs.getString("Box_Type"),
                    rs.getString("Pet_Type"),
                    rs.getInt("Month"),
                    rs.getInt("Year"),
                    rs.getTimestamp("Create_Time"),
                    rs.getTimestamp("Update_Time")
                );
                boxesList.add(box);
            }
        }
        return boxesList;
    }
    
    public int getBoxIdByTypeAndPetType(String boxType, String petType) throws SQLException {
        String sql = "SELECT Box_ID FROM Boxes WHERE Box_Type = ? AND Pet_Type = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, boxType);
            statement.setString(2, petType);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Box_ID");
                }
            }
        }
        return -1; // Return -1 or another value indicating no result
    }
    
    
    public double calculateTotalAmount(int boxId) throws SQLException {
        String sql = "SELECT SUM(p.Price * bi.Quantity) AS TotalPrice " +
                     "FROM Box_Items bi " +
                     "JOIN Products p ON bi.Product_ID = p.Product_ID " +
                     "WHERE bi.Box_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, boxId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("TotalPrice");
                }
            }
        }
        return 0.0;
    }

    public double getItemPrice(int productId) throws SQLException {
        String sql = "SELECT Price FROM Products WHERE Product_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("Price");
                }
            }
        }
        return 0.0;
    }
    
    
}

