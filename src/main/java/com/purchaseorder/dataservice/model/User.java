package com.purchaseorder.dataservice.model;

import javax.crypto.SecretKey;

public class User {
    public enum userType {Normal, Approver, Finance}

    private String nnumber;
    private String name;
    private String email;
    private boolean isAuthenticated = false;
    private Enum userType;
    private SecretKey secret;

    public User(String nnumber, String name, String email, Boolean isAuthenticated, Enum userType) {
        this.nnumber = nnumber;
        this.name = name;
        this.email = email;
        this.isAuthenticated = isAuthenticated;
        this.userType = userType;
        //this.secret = secret;
    }

    @Override
    public String toString() {
        return "User{" +
                "nnumber='" + nnumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isAuthenticated=" + isAuthenticated +
                ", userType=" + userType +
                '}';
    }

    public String getNnumber() {
        return nnumber;
    }

    public void setNnumber(String nNumber) {
        this.nnumber = nNumber;
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

    public void authenticate() {
        isAuthenticated = true;
    }

    public Enum getUserType() {
        return userType;
    }

    public void setUserType(Enum userType) {
        this.userType = userType;
    }

    public SecretKey getSecret() {
        return secret;
    }

    public void setSecret(SecretKey secret) {
        this.secret = secret;
    }
}

