package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ViewSubsistence {

    private Integer id;

    private Integer month;

    private Integer year;

    private Float total;

    private Integer type;

    private Integer level;

    private  Integer status;

    @Column(name = "new_number")
    private Integer newNumberElect;

    @Column(name = "old_number")
    private Integer oldNumberElect;

    @Column(name = "cost_id")
    private Integer costIdElect;

    @Column(name = "name_cost")
    private String nameCost;

    @Column(name = "cost_value")
    private Float costValue;

    @Column(name = "room_id")
    private Integer roomId;

    public ViewSubsistence() {
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

    public Integer getNewNumberElect() {
        return newNumberElect;
    }

    public void setNewNumberElect(Integer newNumberElect) {
        this.newNumberElect = newNumberElect;
    }

    public Integer getOldNumberElect() {
        return oldNumberElect;
    }

    public void setOldNumberElect(Integer oldNumberElect) {
        this.oldNumberElect = oldNumberElect;
    }

    public Integer getCostIdElect() {
        return costIdElect;
    }

    public void setCostIdElect(Integer costIdElect) {
        this.costIdElect = costIdElect;
    }

    public String getNameCost() {
        return nameCost;
    }

    public void setNameCost(String nameCost) {
        this.nameCost = nameCost;
    }

    public Float getCostValue() {
        return costValue;
    }

    public void setCostValue(Float costValue) {
        this.costValue = costValue;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
