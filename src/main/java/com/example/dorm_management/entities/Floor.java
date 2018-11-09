package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "area_id")
    private Integer areaId;

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

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Floor(String name, Integer areaId, Integer status) {
        this.name = name;
        this.areaId = areaId;
        this.status = status;
    }

    public Floor() {
    }
}
