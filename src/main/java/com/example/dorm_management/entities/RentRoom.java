package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rent_room")
public class RentRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "semester_id")
    private Integer semesterId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "room_id")
    private  Integer roomId;

    private  String year;

    private  Float bail;

    private  Integer status;

    public RentRoom() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Float getBail() {
        return bail;
    }

    public void setBail(Float bail) {
        this.bail = bail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
