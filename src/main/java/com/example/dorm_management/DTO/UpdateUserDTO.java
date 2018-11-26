package com.example.dorm_management.DTO;

/**
 * Created by vuong on 11/26/2018.
 */
public class UpdateUserDTO {
    private Integer gender;
    private String phone;
    private String  address;
    private String fullName;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(Integer gender, String phone, String address, String fullName) {
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
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
}
