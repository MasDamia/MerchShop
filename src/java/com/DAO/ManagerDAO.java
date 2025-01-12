/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Model.Manager;

/**
 *
 * @author masda
 */
public class ManagerDAO {

    Connection connection = null;

    private String jdbcURL = "jdbc:mysql://localhost:3306/merchandiseshop";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    public ManagerDAO() {

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

    public Manager validateManager(String username, String password) {
        Manager manager = null;
        try ( Connection connection = getConnection()) {
            String query = "SELECT * FROM Manager WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                manager = new Manager();
                manager.setManagerID(resultSet.getInt("managerID"));
                manager.setUsername(resultSet.getString("username"));
                manager.setPassword(resultSet.getString("password"));
                manager.setEmailAddress(resultSet.getString("emailAddress"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manager;
    }
}
