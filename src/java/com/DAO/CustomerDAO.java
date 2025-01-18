
package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Model.Customer;

public class CustomerDAO {
    Connection connection = null;
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/merchandiseshop";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    
    public CustomerDAO() {
        
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
    
    public boolean registerCustomer(Customer customer) {
        boolean isRegistered = false;

        try (Connection connection = getConnection()) {
            String query = "INSERT INTO Customer (username, password, emailAddress) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getEmailAddress());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                isRegistered = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRegistered;
    }
    
    public Customer validateCustomer(String username, String password) {
        Customer customer = null;
        try ( Connection connection = getConnection()) {
            String query = "SELECT * FROM Customer WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerID(resultSet.getInt("customerID"));
                customer.setUsername(resultSet.getString("username"));
                customer.setPassword(resultSet.getString("password"));
                customer.setEmailAddress(resultSet.getString("emailAddress"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
}
