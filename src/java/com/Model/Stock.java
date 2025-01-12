
package com.Model;

public class Stock {
    private int stockID;
    private String stockName;
    private int stockQtt;
    private double stockPrice;
    
    public Stock() {
        
    }

    public Stock(int stockID, String stockName, int stockQtt, double stockPrice) {
        this.stockID = stockID;
        this.stockName = stockName;
        this.stockQtt = stockQtt;
        this.stockPrice = stockPrice;
    }

    public Stock(String stockName, int stockQtt, double stockPrice) {
        this.stockName = stockName;
        this.stockQtt = stockQtt;
        this.stockPrice = stockPrice;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockQtt() {
        return stockQtt;
    }

    public void setStockQtt(int stockQtt) {
        this.stockQtt = stockQtt;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }
    
}
