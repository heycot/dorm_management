package com.example.dorm_management.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "register_room")
public class RegisterRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private Integer number;

    @Column(name = "semester_id")
    private Integer semesterId;

    @Column(name = "room_id")
    private Integer roomId;

    private String year;

    private Integer status;

//    @DateTimeFormat
    @Column(name = "time_censor")
    private Timestamp timeCensor;

    @Column(name = "time_register")
    private Timestamp timeRegister;

    public RegisterRoom(Integer userId, Integer number, Integer semesterId, Integer roomId, String year, Integer status, Timestamp timeCensor, Timestamp timeRegister) {
        this.userId = userId;
        this.number = number;
        this.semesterId = semesterId;
        this.roomId = roomId;
        this.year = year;
        this.status = status;
        this.timeCensor = timeCensor;
        this.timeRegister = timeRegister;
    }

    public RegisterRoom() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getTimeCensor() {
        return timeCensor;
    }

    public void setTimeCensor(Timestamp timeCensor) {
        this.timeCensor = timeCensor;
    }

    public Timestamp getTimeRegister() {
        return timeRegister;
    }

    public void setTimeRegister(Timestamp timeRegister) {
        this.timeRegister = timeRegister;
    }
}
