package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rent_room", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RentRoomEntity {
    private Integer id;
    private Integer semesterId;
    private Integer userId;
    private Integer roomId;
    private String year;
    private Double bail;
    private Integer status;
    private SemesterEntity semesterBySemesterId;
    private UserEntity userByUserId;
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
//    @Column(name = "semester_id")
//    public Integer getSemesterId() {
//        return semesterId;
//    }
//
//    public void setSemesterId(Integer semesterId) {
//        this.semesterId = semesterId;
//    }
//
//    @Basic
//    @Column(name = "user_id")
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    @Basic
//    @Column(name = "room_id")
//    public Integer getRoomId() {
//        return roomId;
//    }
//
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
    @Column(name = "bail")
    public Double getBail() {
        return bail;
    }

    public void setBail(Double bail) {
        this.bail = bail;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentRoomEntity that = (RentRoomEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(semesterId, that.semesterId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(roomId, that.roomId) &&
                Objects.equals(year, that.year) &&
                Objects.equals(bail, that.bail) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, semesterId, userId, roomId, year, bail, status);
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
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
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
