package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
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

    private String year;

    private Float bail;

    private Integer status;

    @Column(name = "room_id")
    private Integer roomId;

    public RentRoom() {
    }

    public static RentRoom.RentRoomBuilder builder() {
        return new RentRoom.RentRoomBuilder();
    }

    @ConstructorProperties({"semesterId", "userId", "year", "bail", "status", "roomId"})
    RentRoom(Integer semesterId, Integer userId, String year, Float bail, Integer status, Integer roomId) {
        this.semesterId = semesterId;
        this.userId = userId;
        this.year = year;
        this.bail = bail;
        this.status = status;
        this.roomId = roomId;
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

    //==================================================================================================================

    public static class RentRoomBuilder {

        private Integer semesterId;
        private Integer userId;
        private String year;
        private Float bail;
        private Integer status;
        private Integer roomId;

        RentRoomBuilder() {
        }

        public RentRoom.RentRoomBuilder semesterId(Integer semesterId) {
            this.semesterId = semesterId;
            return this;
        }

        public RentRoom.RentRoomBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public RentRoom.RentRoomBuilder year(String year) {
            this.year = year;
            return this;
        }

        public RentRoom.RentRoomBuilder bail(Float bail){
            this.bail = bail;
            return this;
        }

        public RentRoom.RentRoomBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public RentRoom.RentRoomBuilder roomId(Integer roomId) {
            this.roomId = roomId;
            return this;
        }

        public RentRoom build(){
            return new RentRoom(this.semesterId, this.userId, this.year, this.bail, this.status, this.roomId);
        }
    }
}
