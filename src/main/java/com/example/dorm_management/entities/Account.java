package com.example.dorm_management.entities;

import lombok.Data;

/**
 * Created by vuong on 10/28/2018.
 */
@Data
public class Account {
    private String userName;
    private String password;

    public Account() {
    }

    public Account(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
