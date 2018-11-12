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
public class ViewRoom {
    @Id
    private Integer id;

    private String name;

    private Integer gender;

    private Integer status;

    @Column(name = "number_bed")
    private Integer numberBed;

    @Column(name = "student_max")
    private Integer studentMax;

    @Column(name = "student_present")
    private Integer studentPresent;

    @Column(name = "student_register")
    private Integer studentRegister;

    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "cost_id")
    private Integer costId;

    @Column(name = "floor_id")
    private Integer floorId;

    @Column(name = "function_id")
    private Integer functionId;

    @Column(name = "name_floor")
    private String floorName;

    @Column(name = "name_function")
    private String functionName;

    @Column(name = "name_area")
    private String areaName;

    @Column(name = "name_cost")
    private String costName;

    @Column(name = "value_cost")
    private Float costValue;

    @Column(name = "level_cost")
    private Integer costLevel;

    public static ViewRoom.ViewRoomBuilder builder() {
        return new ViewRoom.ViewRoomBuilder();
    }

    public ViewRoom() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getNumberBed() {
        return numberBed;
    }

    public void setNumberBed(Integer numberBed) {
        this.numberBed = numberBed;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStudentMax() {
        return studentMax;
    }

    public void setStudentMax(Integer studentMax) {
        this.studentMax = studentMax;
    }

    public Integer getStudentPresent() {
        return studentPresent;
    }

    public void setStudentPresent(Integer studentPresent) {
        this.studentPresent = studentPresent;
    }

    public Integer getStudentRegister() {
        return studentRegister;
    }

    public void setStudentRegister(Integer studentRegister) {
        this.studentRegister = studentRegister;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public Float getCostValue() {
        return costValue;
    }

    public void setCostValue(Float costValue) {
        this.costValue = costValue;
    }

    public Integer getCostLevel() {
        return costLevel;
    }

    public void setCostLevel(Integer costLevel) {
        this.costLevel = costLevel;
    }
    @ConstructorProperties({"id", "name", "gender", "status", "numberBed", "studentMax", "studentPresent", "studentRegister", "areaId",
            "costId", "floorId", "functionId", "floorName", "functionName", "areaName", "costName", "costValue", "costLevel"})
    ViewRoom(Integer id, String name, Integer gender, Integer status, Integer numberBed, Integer studentMax, Integer studentPresent, Integer studentRegister, Integer areaId, Integer costId, Integer floorId, Integer functionId, String floorName, String functionName, String areaName, String costName, Float costValue, Integer costLevel) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.status = status;
        this.numberBed = numberBed;
        this.studentMax = studentMax;
        this.studentPresent = studentPresent;
        this.studentRegister = studentRegister;
        this.areaId = areaId;
        this.costId = costId;
        this.floorId = floorId;
        this.functionId = functionId;
        this.floorName = floorName;
        this.functionName = functionName;
        this.areaName = areaName;
        this.costName = costName;
        this.costValue = costValue;
        this.costLevel = costLevel;
    }

    //==================================================================================================================
    public static class ViewRoomBuilder {

        private Integer id;
        private String name;
        private Integer gender;
        private Integer status;
        private Integer numberBed;
        private Integer studentMax;
        private Integer studentPresent;
        private Integer studentRegister;
        private Integer areaId;
        private Integer costId;
        private Integer floorId;
        private Integer functionId;
        private String floorName;
        private String functionName;
        private String areaName;
        private String costName;
        private Float costValue;
        private Integer costLevel;

        ViewRoomBuilder() {
        }

        public ViewRoom.ViewRoomBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public ViewRoom.ViewRoomBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ViewRoom.ViewRoomBuilder gender(Integer gender){
            this.gender = gender;
            return this;
        }

        public ViewRoom.ViewRoomBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ViewRoom.ViewRoomBuilder numberBed(Integer numberBed){
            this.numberBed = numberBed;
            return this;
        }

        public ViewRoom.ViewRoomBuilder studentMax(Integer studentMax) {
            this.studentMax = studentMax;
            return this;
        }

        public ViewRoom.ViewRoomBuilder studentPresent(Integer studentPresent) {
            this.studentPresent = studentPresent;
            return this;
        }

        public ViewRoom.ViewRoomBuilder studentRegister(Integer studentRegister) {
            this.studentRegister = studentRegister;
            return this;
        }

        public ViewRoom.ViewRoomBuilder areaId(Integer areaId) {
            this.areaId = areaId;
            return this;
        }

        public ViewRoom.ViewRoomBuilder floorId(Integer floorId) {
            this.floorId = floorId;
            return this;
        }

        public ViewRoom.ViewRoomBuilder costId(Integer costId) {
            this.costId = costId;
            return this;
        }

        public ViewRoom.ViewRoomBuilder functionId(Integer functionId) {
            this.functionId = functionId;
            return this;
        }

        public ViewRoom.ViewRoomBuilder floorName(String floorName) {
            this.floorName = floorName;
            return this;
        }

        public ViewRoom.ViewRoomBuilder functionName(String functionName) {
            this.functionName = functionName;
            return this;
        }

        public ViewRoom.ViewRoomBuilder areaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public ViewRoom.ViewRoomBuilder costName(String costName) {
            this.costName = costName;
            return this;
        }

        public ViewRoom.ViewRoomBuilder costValue(Float costValue) {
            this.costValue = costValue;
            return this;
        }

        public ViewRoom.ViewRoomBuilder costLevel(Integer costLevel) {
            this.costLevel = costLevel;
            return this;
        }

        public ViewRoom build(){
            return new ViewRoom(this.id, this.name, this.gender, this.status, this.numberBed, this.studentMax, this.studentPresent,
                    this.studentRegister, this.areaId, this.floorId, this.costId, this.functionId, this.floorName, this.functionName,
                    this.areaName, this.costName, this.costValue, this.costLevel);
        }
    }


}
