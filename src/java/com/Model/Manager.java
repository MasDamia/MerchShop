package com.Model;

public class Manager {
    protected int managerID;
    protected String username;
    protected String password;
    protected String emailAddress;

    public Manager() {

    }

    public Manager(int managerID, String username, String password, String emailAddress) {
        super();
        this.managerID = managerID;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
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
