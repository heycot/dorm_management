package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ViewSubsistence {

    @Id
    private Integer id;

    private Integer month;

    private Integer year;

    private Float total;

    private Integer type;

    private Integer level;

    private  Integer status;

    @Column(name = "new_number")
    private Integer newNumber;

    @Column(name = "old_number")
    private Integer oldNumber;

    @Column(name = "cost_id")
    private Integer costId;

//    @Column(name = "name_cost")
    private String nameCost;

//    @Column(name = "value_cost")
    private Float costValue;

//    @Column(name = "room_id")
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
