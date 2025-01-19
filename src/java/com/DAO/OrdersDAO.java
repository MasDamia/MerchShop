
package com.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Model.Orders;

public class OrdersDAO {
    Connection connection = null;

    private String jdbcURL = "jdbc:mysql://localhost:3306/merchandiseshop";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    
    private static final String INSERT_ORDER_SQL = "INSERT INTO orders (customerID, stockID, orderQtt, totalPrice, orderDate, address) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    
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
    
    public OrdersDAO() {
        
    }
    
    public void placeOrder(List<Orders> ordersList) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL);
            
            for (Orders order : ordersList) {
                preparedStatement.setInt(1, order.getCustomerID());
                preparedStatement.setInt(2, order.getStockID());
                preparedStatement.setInt(3, order.getOrderQtt());
                preparedStatement.setDouble(4, order.getTotalPrice());
                preparedStatement.setDate(5, new java.sql.Date(order.getOrderDate().getTime()));
                preparedStatement.setString(6, order.getAddress());
                preparedStatement.addBatch();
            }
            
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Orders> getAllOrders() {
        List<Orders> ordersList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("orderID");
                int customerID = rs.getInt("customerID");
                int stockID = rs.getInt("stockID");
                int orderQtt = rs.getInt("orderQtt");
                double totalPrice = rs.getDouble("totalPrice");
                Date orderDate = rs.getDate("orderDate");
                String address = rs.getString("address");
    
                Orders order = new Orders(orderID, customerID, stockID, orderQtt, totalPrice, orderDate, address);
                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }
    
    /*public boolean updateStockQuantity(int stockID, int newQuantity) {
        String query = "UPDATE Stock SET stockQtt = ? WHERE stockID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, newQuantity);
            ps.setInt(2, stockID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }*/
}
