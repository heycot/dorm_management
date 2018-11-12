package com.example.dorm_management.entities;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.beans.ConstructorProperties;

@Getter
@Setter
@Builder
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

    @ConstructorProperties({"name", "numberFloor", "status"})
    Area(String name, Integer numberFloor, Integer status) {
        this.name = name;
        this.numberFloor = numberFloor;
        this.status = status;
    }

    public static Area.AreaBuilder builder(){
        return new Area.AreaBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberFloor() {
        return this.numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Area() {
    }

    //==================================================================================================================

    public static class AreaBuilder {
        private String name;
        private Integer numberFloor;
        private Integer status;

        AreaBuilder() {
        }

        public Area.AreaBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Area.AreaBuilder numberFloor(Integer numberFloor) {
            this.numberFloor = numberFloor;
            return this;
        }

        public Area.AreaBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public Area build(){
            return new Area(this.name, this.numberFloor, this.status);
        }
    }
}
