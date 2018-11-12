package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "subsistence_fee")
public class SubsistenceFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer month;

    private String year;

    private Float total;

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

    @Column(name = "total_water")
    private Float totalWater;

    @Column(name = "total_elec")
    private  Float totalElec;

    @Column(name = "room_id")
    private Integer roomId;

    public static SubsistenceFee.SubsistenceBuilder builder() {
        return new SubsistenceFee.SubsistenceBuilder();
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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

    public Float getTotalWater() {
        return totalWater;
    }

    public void setTotalWater(Float totalWater) {
        this.totalWater = totalWater;
    }

    public Float getTotalElec() {
        return totalElec;
    }

    public void setTotalElec(Float totalElec) {
        this.totalElec = totalElec;
    }

    @ConstructorProperties({"month", "year", "total", "levelWater", "levelElec", "status", "status", "newNumberWater", "newNumberElec",
            "oldNumberWater", "oldNumberElec", "costWater", "costElec", "totalWater", "totalElec", "roomId"})
    SubsistenceFee(Integer month, String year, Float total, Integer levelWater, Integer levelElec, Integer status, Integer newNumberWater, Integer newNumberElec, Integer oldNumberWater, Integer oldNumberElec, Float costWater, Float costElec, Float totalWater, Float totalElec, Integer roomId) {
        this.month = month;
        this.year = year;
        this.total = total;
        this.levelWater = levelWater;
        this.levelElec = levelElec;
        this.status = status;
        this.newNumberWater = newNumberWater;
        this.newNumberElec = newNumberElec;
        this.oldNumberWater = oldNumberWater;
        this.oldNumberElec = oldNumberElec;
        this.costWater = costWater;
        this.costElec = costElec;
        this.totalWater = totalWater;
        this.totalElec = totalElec;
        this.roomId = roomId;
    }

    //==================================================================================================================

    public static class SubsistenceBuilder {

        private Integer month;
        private String year;
        private Float total;
        private Integer levelWater;
        private Integer levelElec;
        private  Integer status;
        private Integer newNumberWater;
        private Integer newNumberElec;
        private Integer oldNumberWater;
        private Integer oldNumberElec;
        private Float costWater;
        private Float costElec;
        private Float totalWater;
        private Float totalElec;
        private Integer roomId;

        SubsistenceBuilder() {
        }

        public SubsistenceFee.SubsistenceBuilder month(Integer month) {
            this.month = month;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder year(String year) {
            this.year = year;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder total(Float total) {
            this.total = total;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder levelWater(Integer levelWater) {
            this.levelWater = levelWater;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder levelElec(Integer levelElec) {
            this.levelElec = levelElec;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder newNumberWater(Integer newNumberWater) {
            this.newNumberWater = newNumberWater;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder newNumberElec(Integer newNumberElec) {
            this.newNumberElec = newNumberElec;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder oldNumberWater(Integer oldNumberWater) {
            this.oldNumberWater = oldNumberWater;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder oldNumberElec(Integer oldNumberElec) {
            this.oldNumberElec = oldNumberElec;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder costWater(Float costWater) {
            this.costWater = costWater;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder costElec(Float costElec) {
            this.costElec = costElec;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder totalWater(Float totalWater) {
            this.totalWater = totalWater;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder totalElec(Float totalElec) {
            this.totalElec = totalElec;
            return this;
        }

        public SubsistenceFee.SubsistenceBuilder roomId(Integer roomId) {
            this.roomId = roomId;
            return this;
        }

        public SubsistenceFee build(){
            return new SubsistenceFee(this.month, this.year, this.total, this.levelWater, this.levelElec, this.status, this.newNumberWater,
                    this.newNumberElec, this.oldNumberWater, this.oldNumberElec, this.costWater, this.costElec, this.totalWater, this.totalElec, this.roomId);
        }
    }
}
