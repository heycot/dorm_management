package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;

@Getter
@Setter
@Builder
@Entity
@Data
@Table(name = "floor")
public class Floor {
    //------------------status ---------------------------
    public final static Integer FLOOR_STATUS_ENABLE  = 1;
    public final static Integer FLOOR_STATUS_DISABLE = 0;

    //-------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
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

    @ConstructorProperties({"name", "areaId", "status"})
    Floor(String name, Integer areaId, Integer status) {
        this.name = name;
        this.areaId = areaId;
        this.status = status;
    }

    public Floor() {
    }

    public static Floor.FloorBuilder builder() {
        return new Floor.FloorBuilder();
    }

    //==================================================================================================================

    public static class FloorBuilder {

        private String name;

        private Integer areaId;

        private Integer status;

        FloorBuilder() {
        }

        public Floor.FloorBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Floor.FloorBuilder areaId(Integer areaId) {
            this.areaId = areaId;
            return this;
        }

        public Floor.FloorBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public Floor build(){
            return new Floor(this.name, this.areaId, this.status);
        }
    }
}
