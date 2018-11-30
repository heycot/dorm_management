package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @NotNull
    @Column(name = "code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Action() {
    }

    public Action(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Action(String name, String code) {
        this.name = name;
        this.code = code;
    }
    @ManyToMany(mappedBy = "actions")
    @JsonIgnore
    public List<Group> groups;

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
