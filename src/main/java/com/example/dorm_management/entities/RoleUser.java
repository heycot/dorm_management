package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by vuong on 10/12/2018.
 */
@Data
@Entity
@Table(name = "role_user")
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "status")

    private Integer status;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;

   /* @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "role_id")
    private Set<Role> role;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

   /* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }*/

   /* public RoleUser(Integer status, User user, Set<Role> role) {

        this.status = status;
        this.user = user;
        this.role = role;
    }*/

    public RoleUser(Integer status, Integer userId, Integer roleId) {

        this.status = status;
        this.userId = userId;
        this.roleId = roleId;
    }
}
