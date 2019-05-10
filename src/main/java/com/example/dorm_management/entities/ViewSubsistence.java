package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.beans.ConstructorProperties;

@Getter
@Setter
@Builder
@Entity
public class ViewSubsistence {

    @Id
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

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "floor_id")
    private Integer floorId;

    @Column(name = "floor_name")
    private String floorName;

    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "area_name")
    private String areaName;

    public static ViewSubsistence.ViewSubsistenceBuilder builder() {
        return new ViewSubsistence.ViewSubsistenceBuilder();
    }

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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    @ConstructorProperties({"id","month", "year", "total", "levelWater", "levelElec", "status", "status", "newNumberWater", "newNumberElec",
            "oldNumberWater", "oldNumberElec", "costWater", "costElec", "totalWater", "totalElec", "roomId", "roomName", "floorId",
            "floorName", "areaId", "areaName"})
    ViewSubsistence(Integer id, Integer month, String year, Float total, Integer levelWater, Integer levelElec, Integer status, Integer newNumberWater, Integer newNumberElec, Integer oldNumberWater, Integer oldNumberElec, Float costWater, Float costElec, Float totalWater, Float totalElec, Integer roomId, String roomName, Integer floorId, String floorName, Integer areaId, String areaName) {
        this.id = id;
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
        this.roomName = roomName;
        this.floorId = floorId;
        this.floorName = floorName;
        this.areaId = areaId;
        this.areaName = areaName;
    }

    //==================================================================================================================

    public static class ViewSubsistenceBuilder {

        private Integer id;
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
        private  Float totalElec;
        private Integer roomId;
        private String roomName;
        private Integer floorId;
        private String floorName;
        private Integer areaId;
        private String areaName;

        ViewSubsistenceBuilder() {
        }

        public ViewSubsistence.ViewSubsistenceBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder month(Integer month) {
            this.month = month;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder year(String year) {
            this.year = year;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder total(Float total) {
            this.total = total;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder levelWater(Integer levelWater) {
            this.levelWater = levelWater;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder levelElec(Integer levelElec) {
            this.levelElec = levelElec;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder newNumberWater(Integer newNumberWater) {
            this.newNumberWater = newNumberWater;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder newNumberElec(Integer newNumberElec) {
            this.newNumberElec = newNumberElec;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder oldNumberWater(Integer oldNumberWater) {
            this.oldNumberWater = oldNumberWater;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder oldNumberElec(Integer oldNumberElec) {
            this.oldNumberElec = oldNumberElec;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder costWater(Float costWater) {
            this.costWater = costWater;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder costElec(Float costElec) {
            this.costElec = costElec;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder totalWater(Float totalWater) {
            this.totalWater = totalWater;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder totalElec(Float totalElec) {
            this.totalElec = totalElec;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder roomId(Integer roomId) {
            this.roomId = roomId;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder roomName(String roomName) {
            this.roomName = roomName;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder floorId(Integer floorId) {
            this.floorId = floorId;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder floorName(String floorName) {
            this.floorName = floorName;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder areaId(Integer areaId) {
            this.areaId = areaId;
            return this;
        }

        public ViewSubsistence.ViewSubsistenceBuilder areaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public ViewSubsistence build(){
            return new ViewSubsistence(this.id, this.month, this.year, this.total, this.levelWater, this.levelElec, this.status, this.newNumberWater,
                    this.newNumberElec, this.oldNumberWater, this.oldNumberElec, this.costWater, this.costElec, this.totalWater, this.totalElec,
                    this.roomId, this.roomName, this.floorId, this.floorName, areaId, this.areaName);
        }
    }
}
