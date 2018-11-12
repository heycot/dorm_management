package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "cost")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Float value;

    private Integer type;

    private  Integer level;

    private Integer status;

    public Cost() {
    }
    public static Cost.CostBuilder builder() {
        return new Cost.CostBuilder();
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

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ConstructorProperties({"name", "value", "type", "level", "status"})
    Cost(String name, Float value, Integer type, Integer level, Integer status) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.level = level;
        this.status = status;
    }

    //==================================================================================================================

    public static class CostBuilder {

        private String name;
        private Float value;
        private Integer type;
        private  Integer level;
        private Integer status;

        CostBuilder() {
        }

        public Cost.CostBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Cost.CostBuilder value(Float value) {
            this.value = value;
            return this;
        }

        public Cost.CostBuilder type(Integer type) {
            this.type = type;
            return this;
        }

        public Cost.CostBuilder level(Integer level) {
            this.level = level;
            return this;
        }

        public Cost.CostBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public Cost build(){
            return new Cost(this.name, this.value, this.type, this.level, this.status);
        }
    }
}
