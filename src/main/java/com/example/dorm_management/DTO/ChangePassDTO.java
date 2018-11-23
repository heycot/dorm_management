package com.example.dorm_management.DTO;

/**
 * Created by vuong on 11/23/2018.
 */
public class ChangePassDTO {
    private String name;
    private String oldPassword;
    private String newPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public ChangePassDTO() {

    }

    public ChangePassDTO(String name, String oldPassword, String newPassword) {

        this.name = name;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
