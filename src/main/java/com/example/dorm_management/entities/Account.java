package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private Integer gender;

//    @Column(name = "role_id")
//    private Integer roleId;

  /*  @OneToMany
    @JoinColumn(name = "role_id")
    private Set<Role> roles;*/

/*    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }*/

    @Column(name = "student_code")
    private Integer studentCode;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    /*public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }*/

    public Integer getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Integer studentCode) {
        this.studentCode = studentCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Account(String userName, String password, Integer gender, Integer roleId, Integer studentCode, Integer status) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
//        this.roleId = roleId;
        this.studentCode = studentCode;
        this.status = status;
    }
    public Account(Integer userId, String userName, String password, Integer gender, Integer roleId, Integer studentCode, Integer status) {
        this.id = userId;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
//        this.roleId = roleId;
        this.studentCode = studentCode;
        this.status = status;
    }

    public Account() {
    }
}
