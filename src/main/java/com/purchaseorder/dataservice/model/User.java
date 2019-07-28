package com.purchaseorder.dataservice.model;

public class User {
    public enum userType {Normal, Approver, Finance}

    private String nnumber;
    private String name;
    private String email;
    private boolean isAuthenticated;
    private Enum userType;

    public User(String nnumber, String name, String email, Boolean isAuthenticated, Enum userType) {
        this.nnumber = nnumber;
        this.name = name;
        this.email = email;
        this.isAuthenticated = isAuthenticated;
        this.userType = userType;
    }

    public String getNnumber() {
        return nnumber;
    }

    public void setNnumber(String nnumber) {
        this.nnumber = nnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public Enum getUserType() {
        return userType;
    }

    public void setUserType(Enum userType) {
        this.userType = userType;
    }
}

