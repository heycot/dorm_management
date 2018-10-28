package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subsistence_fee", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SubsistenceFeeEntity {
    private Integer id;
    private Integer month;
    private String year;
    private Double total;
    private Integer type;
    private Integer level;
    private Integer status;
    private Integer newNumber;
    private Integer oldNumber;
    private Integer costId;
    private Integer roomId;
    private CostEntity costByCostId;
    private RoomEntity roomByRoomId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "month")
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Basic
    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
    @Column(name = "new_number")
    public Integer getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(Integer newNumber) {
        this.newNumber = newNumber;
    }

    @Basic
    @Column(name = "old_number")
    public Integer getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(Integer oldNumber) {
        this.oldNumber = oldNumber;
    }

//    @Basic
//    @Column(name = "cost_id")
//    public Integer getCostId() {
//        return costId;
//    }
//
//    public void setCostId(Integer costId) {
//        this.costId = costId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubsistenceFeeEntity that = (SubsistenceFeeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(month, that.month) &&
                Objects.equals(year, that.year) &&
                Objects.equals(total, that.total) &&
                Objects.equals(type, that.type) &&
                Objects.equals(level, that.level) &&
                Objects.equals(status, that.status) &&
                Objects.equals(newNumber, that.newNumber) &&
                Objects.equals(oldNumber, that.oldNumber) &&
                Objects.equals(costId, that.costId) &&
                Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, year, total, type, level, status, newNumber, oldNumber, costId, roomId);
    }

    @ManyToOne
    @JoinColumn(name = "cost_id", referencedColumnName = "id", nullable = false)
    public CostEntity getCostByCostId() {
        return costByCostId;
    }

    public void setCostByCostId(CostEntity costByCostId) {
        this.costByCostId = costByCostId;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public RoomEntity getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(RoomEntity roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }
}
