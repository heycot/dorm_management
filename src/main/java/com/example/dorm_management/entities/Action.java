package com.example.dorm_management.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by vuong on 10/12/2018.
 */
@Data
@Entity
@Table(name = "action")
public class Action {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Action() {

    }

    public Action(String name) {
        this.name = name;
    }

    public Action(Integer id, String name) {
        this.name = name;
        this.id = id;
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

}
