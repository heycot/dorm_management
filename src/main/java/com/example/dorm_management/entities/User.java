package com.example.dorm_management.entities;

import com.example.dorm_management.libararies.EnumStatusUser;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private Integer gender;

    @Column(name = "role_id")
    private Integer roleId;

    private Integer status;



  /*  @OneToMany
    @JoinColumn(name = "role_id")
    private Set<Role> roles;*/

/*    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }*/
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    List<RoleUser> roleUsers;

    public List<RoleUser> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(List<RoleUser> roleUsers) {
        this.roleUsers = roleUsers;
    }

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private UserDetail userDetail;

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private StudentCode studentCode;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public StudentCode getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(StudentCode studentCode) {
        this.studentCode = studentCode;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User(String userName, String password, Integer gender, Integer status) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.status = status;
    }

    public User() {

    }

    public User(Integer id) {
        this.id = id;
        this.userName = "";
        this.password = "";
        this.gender = 0;
        this.status = 0;
    }

    public User(String userName, String password, Integer gender) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.status = 1;
    }


    public void setStatus(EnumStatusUser active) {
        this.status = active.getCode();
    }
}
