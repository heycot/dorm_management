package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "area", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AreaEntity {
    private Integer id;
    private String name;
    private Integer numberFloor;
    private Integer status;
    private Collection<FloorEntity> floorsById;
    private Collection<RoomEntity> roomsById;

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
    @Column(name = "number_floor")
    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
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
        AreaEntity that = (AreaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(numberFloor, that.numberFloor) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberFloor, status);
    }

    @OneToMany(mappedBy = "areaByAreaId")
    public Collection<FloorEntity> getFloorsById() {
        return floorsById;
    }

    public void setFloorsById(Collection<FloorEntity> floorsById) {
        this.floorsById = floorsById;
    }

    @OneToMany(mappedBy = "areaByAreaId")
    @JsonIgnore
    public Collection<RoomEntity> getRoomsById() {
        return roomsById;
    }

    public void setRoomsById(Collection<RoomEntity> roomsById) {
        this.roomsById = roomsById;
    }
}
