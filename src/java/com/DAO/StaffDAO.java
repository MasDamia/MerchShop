
package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Model.Staff;

public class StaffDAO {
    Connection connection = null;
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/merchandiseshop";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    
    public StaffDAO() {
        
    }
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            this.connection = connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public boolean registerStaff(Staff staff) {
        boolean isRegistered = false;

        try (Connection connection = getConnection()) {
            String query = "INSERT INTO Staff (username, password, emailAddress) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, staff.getUsername());
            preparedStatement.setString(2, staff.getPassword());
            preparedStatement.setString(3, staff.getEmailAddress());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                isRegistered = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRegistered;
    }
    
    public Staff validateStaff(String emailAddress, String password) {
        Staff staff = null;
        try ( Connection connection = getConnection()) {
            String query = "SELECT * FROM Staff WHERE emailAddress = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, emailAddress);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                staff = new Staff();
                staff.setStaffID(resultSet.getInt("staffID"));
                staff.setUsername(resultSet.getString("username"));
                staff.setPassword(resultSet.getString("password"));
                staff.setEmailAddress(resultSet.getString("emailAddress"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }
}
