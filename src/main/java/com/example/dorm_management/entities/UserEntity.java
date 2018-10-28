package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserEntity {
    private Integer id;
    private String password;
    private Integer gender;
    private Integer status;
    private Integer roleId;
    private Integer studentCode;
    private String userName;
    private Collection<NotificationEntity> notificationsById;
    private Collection<RegisterRoomEntity> registerRoomsById;
    private Collection<RentEntity> rentsById;
    private Collection<RentRoomEntity> rentRoomsById;
    private Collection<RoleEntity> rolesById;
    private Collection<RoleUserEntity> roleUsersById;
    private Collection<StudentCodeEntity> studentCodesById;
    private RoleEntity roleByRoleId;
    private Collection<UserDetailEntity> userDetailsById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    @Basic
//    @Column(name = "role_id")
//    public Integer getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Integer roleId) {
//        this.roleId = roleId;
//    }

    @Basic
    @Column(name = "student_code")
    public Integer getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Integer studentCode) {
        this.studentCode = studentCode;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(password, that.password) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(status, that.status) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(studentCode, that.studentCode) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, gender, status, roleId, studentCode, userName);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<NotificationEntity> getNotificationsById() {
        return notificationsById;
    }

    public void setNotificationsById(Collection<NotificationEntity> notificationsById) {
        this.notificationsById = notificationsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RegisterRoomEntity> getRegisterRoomsById() {
        return registerRoomsById;
    }

    public void setRegisterRoomsById(Collection<RegisterRoomEntity> registerRoomsById) {
        this.registerRoomsById = registerRoomsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RentEntity> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<RentEntity> rentsById) {
        this.rentsById = rentsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RentRoomEntity> getRentRoomsById() {
        return rentRoomsById;
    }

    public void setRentRoomsById(Collection<RentRoomEntity> rentRoomsById) {
        this.rentRoomsById = rentRoomsById;
    }

    @OneToMany(mappedBy = "userByRoleId")
    public Collection<RoleEntity> getRolesById() {
        return rolesById;
    }

    public void setRolesById(Collection<RoleEntity> rolesById) {
        this.rolesById = rolesById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RoleUserEntity> getRoleUsersById() {
        return roleUsersById;
    }

    public void setRoleUsersById(Collection<RoleUserEntity> roleUsersById) {
        this.roleUsersById = roleUsersById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<StudentCodeEntity> getStudentCodesById() {
        return studentCodesById;
    }

    public void setStudentCodesById(Collection<StudentCodeEntity> studentCodesById) {
        this.studentCodesById = studentCodesById;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserDetailEntity> getUserDetailsById() {
        return userDetailsById;
    }

    public void setUserDetailsById(Collection<UserDetailEntity> userDetailsById) {
        this.userDetailsById = userDetailsById;
    }
}
