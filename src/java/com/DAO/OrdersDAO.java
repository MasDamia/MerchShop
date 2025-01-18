
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
    
    public boolean placeOrder(Orders order) {
        String query ="INSERT INTO Orders (customerID, stockID, orderQtt, totalPrice, orderDate, address) VALUES (?, ?, ?, ?, ?, ?)";
         try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, order.getCustomerID());
            ps.setInt(2, order.getStockID());
            ps.setInt(3, order.getOrderQtt());
            ps.setDouble(4, order.getTotalPrice());
            ps.setDate(5, new java.sql.Date(order.getOrderDate().getTime()));
            ps.setString(6, order.getAddress());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Orders> getOrdersByCustomer(int customerID) {
        List<Orders> orders = new ArrayList<>();
        String query = "SELECT o.orderID, o.custID, o.stockID, o.orderQtt, o.totalPrice, o.orderDate, o.address, s.stockName FROM Orders o JOIN Stock s ON o.stockID = s.stockID WHERE o.custID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders order = new Orders(
                        rs.getInt("orderID"),
                        rs.getInt("custID"),
                        rs.getInt("stockID"),
                        rs.getInt("orderQtt"),
                        rs.getDouble("totalPrice"),
                        rs.getDate("orderDate"),
                        rs.getString("address"),
                        rs.getString("stockName")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    public boolean updateStockQuantity(int stockID, int newQuantity) {
        String query = "UPDATE Stock SET stockQtt = ? WHERE stockID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, newQuantity);
            ps.setInt(2, stockID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
