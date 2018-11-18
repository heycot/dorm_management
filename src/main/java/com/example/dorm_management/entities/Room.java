package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "room")
public class Room {
    //------------------status ---------------------------
    public final static Integer ROOM_STATUS_ENABLE  = 1;
    public final static Integer ROOM_STATUS_DISABLE = 0;

    //-------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "floor_id")
    private Integer floorId;

    @Column(name = "cost_id")
    private Integer costId;

    @Column(name = "function_id")
    private Integer functionId;

    @Column(name = "number_bed")
    private Integer numberBed;

    private Integer gender;

    private Integer status;

    @Column(name = "student_max")
    private Integer studentMax;

    @Column(name = "student_present")
    private Integer studentPresent;

    @Column(name = "student_register")
    private Integer studentRegister;

    public Room(String name) {
        this.name = name;
    }

    public Room() {
    }

    public static Room.RoomBuilder builder() {
        return new Room.RoomBuilder();
    }

    @ConstructorProperties({"name", "floorId", "costId", "functionId", "numberBed", "gender", "status", "studentMax", "studentPresent", "studentRegister"})
    Room(String name, Integer floorId, Integer costId, Integer functionId, Integer numberBed, Integer gender, Integer status, Integer studentMax, Integer studentPresent, Integer studentRegister) {
        this.name = name;
        this.floorId = floorId;
        this.costId = costId;
        this.functionId = functionId;
        this.numberBed = numberBed;
        this.gender = gender;
        this.status = status;
        this.studentMax = studentMax;
        this.studentPresent = studentPresent;
        this.studentRegister = studentRegister;
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

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
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

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
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

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    //==================================================================================================================
    public static class RoomBuilder {

        private String name;
        private Integer floorId;
        private Integer costId;
        private Integer functionId;
        private Integer numberBed;
        private Integer gender;
        private Integer status;
        private Integer studentMax;
        private Integer studentPresent;
        private Integer studentRegister;

        RoomBuilder() {
        }

        public Room.RoomBuilder name(String name) {
            this.name = name;
            return this;
        }


        public Room.RoomBuilder floorId(Integer floorId) {
            this.floorId = floorId;
            return this;
        }

        public Room.RoomBuilder costId(Integer costId) {
            this.costId = costId;
            return this;
        }

        public Room.RoomBuilder functionId(Integer functionId) {
            this.functionId = functionId;
            return this;
        }

        public Room.RoomBuilder numberBed(Integer numberBed){
            this.numberBed = numberBed;
            return this;
        }

        public Room.RoomBuilder gender(Integer gender){
            this.gender = gender;
            return this;
        }

        public Room.RoomBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public Room.RoomBuilder studentMax(Integer studentMax) {
            this.studentMax = studentMax;
            return this;
        }

        public Room.RoomBuilder studentPresent(Integer studentPresent) {
            this.studentPresent = studentPresent;
            return this;
        }

        public Room.RoomBuilder studentRegister(Integer studentRegister) {
            this.studentRegister = studentRegister;
            return this;
        }

        public Room build(){
            return new Room(this.name, this.floorId, this.costId, this.functionId, this.numberBed, this.gender, this.status,
                    this.studentMax, this.studentPresent, this.studentRegister);
        }
    }

}
