package com.example.dorm_management.entities;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "subsistence_fee")
public class SubsistenceFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer month;

    private Integer year;

    private Float total;

    private Integer type;

    private Integer level;

    private  Integer status;

    @NotNull
    @Column(name = "new_number")
    private Integer newNumber;

    @NotNull
    @Column(name = "old_number")
    private Integer oldNumber;

    @Column(name = "cost_id")
    private Integer costId;

    @NotNull
    @Column(name = "room_id")
    private Integer roomId;

    public SubsistenceFee(Integer month, Integer year, Float total, Integer type, Integer level, Integer status, Integer newNumber, Integer oldNumber, Integer costId, Integer roomId) {
        this.month = month;
        this.year = year;
        this.total = total;
        this.type = type;
        this.level = level;
        this.status = status;
        this.newNumber = newNumber;
        this.oldNumber = oldNumber;
        this.costId = costId;
        this.roomId = roomId;
    }

    public SubsistenceFee() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(Integer newNumber) {
        this.newNumber = newNumber;
    }

    public Integer getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(Integer oldNumber) {
        this.oldNumber = oldNumber;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
