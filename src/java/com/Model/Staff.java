
package com.Model;

public class Staff {
    private int staffID;
    private String username;
    private String password;
    private String emailAddress;
    
    public Staff() {
        
    }

    public Staff(int staffID, String username, String password, String emailAddress) {
        this.staffID = staffID;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
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
