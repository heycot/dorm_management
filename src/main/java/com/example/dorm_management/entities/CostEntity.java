package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cost", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CostEntity {
    private Integer id;
    private String name;
    private Double value;
    private Integer type;
    private Integer level;
    private Integer status;
    private Collection<RoomEntity> roomsById;
    private Collection<SubsistenceFeeEntity> subsistenceFeesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostEntity that = (CostEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(value, that.value) &&
                Objects.equals(type, that.type) &&
                Objects.equals(level, that.level) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, type, level, status);
    }

    @OneToMany(mappedBy = "costByCostId")
    @JsonIgnore
    public Collection<RoomEntity> getRoomsById() {
        return roomsById;
    }

    public void setRoomsById(Collection<RoomEntity> roomsById) {
        this.roomsById = roomsById;
    }

    @OneToMany(mappedBy = "costByCostId")
    @JsonIgnore
    public Collection<SubsistenceFeeEntity> getSubsistenceFeesById() {
        return subsistenceFeesById;
    }

    public void setSubsistenceFeesById(Collection<SubsistenceFeeEntity> subsistenceFeesById) {
        this.subsistenceFeesById = subsistenceFeesById;
    }
}
