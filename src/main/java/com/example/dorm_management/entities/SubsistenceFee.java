package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "subsistence_fee")
public class SubsistenceFee {

    @Id
    private Integer id;

    private Integer month;

    private Integer year;

    private Float total;

//    private Integer type;

    @Column(name = "level_water")
    private Integer levelWater;

    @Column(name = "level_elec")
    private Integer levelElec;

    private  Integer status;

    @Column(name = "new_number_water")
    private Integer newNumberWater;

    @Column(name = "new_number_elec")
    private Integer newNumberElec;

    @Column(name = "old_number_water")
    private Integer oldNumberWater;

    @Column(name = "old_number_elec")
    private Integer oldNumberElec;

    @Column(name = "cost_water")
    private Float costWater;

    @Column(name = "cost_elec")
    private Float costElec;

    @Column(name = "room_id")
    private Integer roomId;

    public SubsistenceFee() {
    }

    public Float getCostWater() {
        return costWater;
    }

    public void setCostWater(Float costWater) {
        this.costWater = costWater;
    }

    public Float getCostElec() {
        return costElec;
    }

    public void setCostElec(Float costElec) {
        this.costElec = costElec;
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

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getLevelWater() {
        return levelWater;
    }

    public void setLevelWater(Integer levelWater) {
        this.levelWater = levelWater;
    }

    public Integer getLevelElec() {
        return levelElec;
    }

    public void setLevelElec(Integer levelElec) {
        this.levelElec = levelElec;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNewNumberWater() {
        return newNumberWater;
    }

    public void setNewNumberWater(Integer newNumberWater) {
        this.newNumberWater = newNumberWater;
    }

    public Integer getNewNumberElec() {
        return newNumberElec;
    }

    public void setNewNumberElec(Integer newNumberElec) {
        this.newNumberElec = newNumberElec;
    }

    public Integer getOldNumberWater() {
        return oldNumberWater;
    }

    public void setOldNumberWater(Integer oldNumberWater) {
        this.oldNumberWater = oldNumberWater;
    }

    public Integer getOldNumberElec() {
        return oldNumberElec;
    }

    public void setOldNumberElec(Integer oldNumberElec) {
        this.oldNumberElec = oldNumberElec;
    }

    public Integer getRoomId() {
        return roomId;
    }
}
