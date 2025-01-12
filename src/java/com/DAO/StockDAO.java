package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Stock;

public class StockDAO {

    Connection connection = null;

    private String jdbcURL = "jdbc:mysql://localhost:3306/merchandiseshop";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String INSERT_STOCKS_SQL = "INSERT INTO Stock (stockName, stockQtt, stockPrice) VALUES " + " (?, ?, ?);";

    private static final String SELECT_STOCK_BY_ID = "select stockID, stockName, stockQtt, stockPrice from Stock where stockID=?";
    private static final String SELECT_ALL_STOCKS = "select * from Stock";
    private static final String DELETE_STOCKS_SQL = "delete from Stock where stockID = ?";
    private static final String UPDATE_STOCKS_SQL = "update Stock set stockName = ?, stockQtt = ?, stockPrice = ? where stockID=?";

    public StockDAO() {

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

    public void insertStock(Stock stock) throws SQLException {
        System.out.println(INSERT_STOCKS_SQL);
        try ( Connection connection = getConnection();  PreparedStatement preparedStatement
                = connection.prepareStatement(INSERT_STOCKS_SQL)) {
            preparedStatement.setString(1, stock.getStockName());
            preparedStatement.setInt(2, stock.getStockQtt());
            preparedStatement.setDouble(3, stock.getStockPrice());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Stock selectStock(int stockID) {
        Stock stock = null;
        try ( Connection connection = getConnection();
                  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STOCK_BY_ID);) {
            preparedStatement.setInt(1, stockID);
            
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String stockName = rs.getString("stockName");
                int stockQtt = rs.getInt("stockQtt");
                double stockPrice = rs.getDouble("stockPrice");

                stock = new Stock(stockID, stockName, stockQtt, stockPrice);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return stock;
    }

    public List<Stock> selectAllStocks() {
        List<Stock> stocks = new ArrayList<>();

        try ( Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STOCKS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int stockID = rs.getInt("stockID");
                String stockName = rs.getString("stockName");
                int stockQtt = rs.getInt("stockQtt");
                double stockPrice = rs.getDouble("stockPrice");
                
                stocks.add(new Stock(stockID, stockName, stockQtt, stockPrice));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return stocks;
    }
    
    public boolean deleteStock(int stockID) throws SQLException {
        boolean rowDeleted;
        try ( Connection connection = getConnection();  PreparedStatement statement
                = connection.prepareStatement(DELETE_STOCKS_SQL);) {
            statement.setInt(1, stockID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean updateStock(Stock stock) throws SQLException {
        boolean rowUpdated;
        try ( Connection connection = getConnection();  PreparedStatement statement
                = connection.prepareStatement(UPDATE_STOCKS_SQL);) {
            statement.setString(1, stock.getStockName());
            statement.setInt(2, stock.getStockQtt());
            statement.setDouble(3, stock.getStockPrice());
            statement.setInt(4, stock.getStockID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());

                Throwable t = ex.getCause();

                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
