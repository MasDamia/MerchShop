
package com.Model;

public class Customer {
    protected int customerID;
    protected String username;
    protected String password;
    protected String emailAddress;
    
    public Customer() {
        
    }

    public Customer(int customerID, String username, String password, String emailAddress) {
        this.customerID = customerID;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
}
