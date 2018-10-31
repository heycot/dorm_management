package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "area_id")
    private Integer areaId;

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

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "room")
//    @OneToMany(mappedBy="room",targetEntity=RentRoom.class, fetch=FetchType.EAGER)
//    private Collection<RentRoom> rentRooms;



    public Room(String name) {
        this.name = name;
    }

    public Room() {
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



}
