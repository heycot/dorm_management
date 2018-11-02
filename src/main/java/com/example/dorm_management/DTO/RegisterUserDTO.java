package com.example.dorm_management.DTO;

/**
 * Created by vuong on 11/1/2018.
 */
public class RegisterUserDTO {
    private String userName;
    private String password;
    private Integer gender;
    private String phone;
    private String address;
    private String fullName;
    private String mssv;
    private String nameClass;

    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String userName, String password, Integer gender, String phone, String address, String fullName, String mssv, String nameClass) {

        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.mssv = mssv;
        this.nameClass = nameClass;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
