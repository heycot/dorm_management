package com.example.dorm_management.entities;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "number_floor")
    private Integer numberFloor;

    private Integer status;

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

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Area(String name, Integer numberFloor, Integer status) {
        this.name = name;
        this.numberFloor = numberFloor;
        this.status = status;
    }

    public Area() {
    }
}
