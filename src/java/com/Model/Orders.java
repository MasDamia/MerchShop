
package com.Model;

import java.util.Date;

public class Orders {
    protected int orderID;
    protected int customerID;
    protected int stockID;
    protected int orderQtt;
    protected double totalPrice;
    protected Date orderDate;
    protected String address;
    protected String stockName;
    
    public Orders() {
        
    }

    public Orders(int orderID, int customerID, int stockID, int orderQtt, double totalPrice, Date orderDate) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.stockID = stockID;
        this.orderQtt = orderQtt;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public Orders(int orderID, int customerID, int stockID, int orderQtt, double totalPrice, Date orderDate, String address) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.stockID = stockID;
        this.orderQtt = orderQtt;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.address = address;
    }

    public Orders(int orderID, int customerID, int stockID, int orderQtt, double totalPrice, Date orderDate, String address, String stockName) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.stockID = stockID;
        this.orderQtt = orderQtt;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.address = address;
        this.stockName = stockName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getOrderQtt() {
        return orderQtt;
    }

    public void setOrderQtt(int orderQtt) {
        this.orderQtt = orderQtt;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    
}
