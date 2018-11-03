package com.example.dorm_management.DTO;

/**
 * Created by vuong on 11/1/2018.
 */
public class RegisterStudentUserDTO extends RegisterUserDTO {
    private String mssv;
    private String nameClass;

    public RegisterStudentUserDTO() {
        super();
    }

    public RegisterStudentUserDTO(String userName, String password, Integer gender, String phone, String address, String fullName, String mssv, String nameClass) {
        super(userName, password, gender, phone, address, fullName);
        this.mssv = mssv;
        this.nameClass = nameClass;
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
