package com.example.dorm_management.DTO;

import lombok.Data;


/**
 * Created by vuong on 10/28/2018.
 */
@Data
public class AccountDTO {
    private String userName;
    private String password;
    private String studentCode;

    public AccountDTO() {
    }

    public AccountDTO(String userName, String password, String studentCode) {

        this.userName = userName;
        this.password = password;
        this.studentCode = studentCode;
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

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}
