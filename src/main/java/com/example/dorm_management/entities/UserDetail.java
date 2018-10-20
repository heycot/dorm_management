package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by vuong on 10/12/2018.
 */
@Data
@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phone;
    private String  address;
    @Column(name = "full_name")
    private String fullName;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Account user;

    public UserDetail() {
    }

    public UserDetail(String phone, String address, String fullName, Integer id_user) {
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
        this.user = new Account(id_user, "", "", -1, -1, -1, -1);
    }

    public UserDetail(UserDetail userDetail){
        this.phone = userDetail.getPhone();
        this.address = userDetail.getAddress();
        this.fullName = userDetail.getFullName();
        this.user = userDetail.getUser();
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }
}
