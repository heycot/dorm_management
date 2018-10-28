package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "register_room", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RegisterRoomEntity {
    private Integer id;
    private Integer userId;
    private Integer number;
    private Integer semesterId;
    private Integer roomId;
    private String year;
    private Integer status;
    private Timestamp timeCensor;
    private Timestamp timeRegister;
    private UserEntity userByUserId;
    private SemesterEntity semesterBySemesterId;
    private RoomEntity roomByRoomId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "user_id")
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

//    @Basic
//    @Column(name = "semester_id")
//    public Integer getSemesterId() {
//        return semesterId;
//    }
//
//    public void setSemesterId(Integer semesterId) {
//        this.semesterId = semesterId;
//    }

//    @Basic
//    @Column(name = "room_id")
//    public Integer getRoomId() {
//        return roomId;
//    }

//    public void setRoomId(Integer roomId) {
//        this.roomId = roomId;
//    }

    @Basic
    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "time_censor")
    public Timestamp getTimeCensor() {
        return timeCensor;
    }

    public void setTimeCensor(Timestamp timeCensor) {
        this.timeCensor = timeCensor;
    }

    @Basic
    @Column(name = "time_register")
    public Timestamp getTimeRegister() {
        return timeRegister;
    }

    public void setTimeRegister(Timestamp timeRegister) {
        this.timeRegister = timeRegister;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterRoomEntity that = (RegisterRoomEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(number, that.number) &&
                Objects.equals(semesterId, that.semesterId) &&
                Objects.equals(roomId, that.roomId) &&
                Objects.equals(year, that.year) &&
                Objects.equals(status, that.status) &&
                Objects.equals(timeCensor, that.timeCensor) &&
                Objects.equals(timeRegister, that.timeRegister);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, number, semesterId, roomId, year, status, timeCensor, timeRegister);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "id", nullable = false)
    public SemesterEntity getSemesterBySemesterId() {
        return semesterBySemesterId;
    }

    public void setSemesterBySemesterId(SemesterEntity semesterBySemesterId) {
        this.semesterBySemesterId = semesterBySemesterId;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    public RoomEntity getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(RoomEntity roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }
}
