package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room_function")
public class RoomFunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer status;

    public RoomFunction(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public RoomFunction() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
