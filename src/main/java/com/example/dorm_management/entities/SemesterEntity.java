package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "semester", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SemesterEntity {
    private Integer id;
    private String name;
    private Integer month;
    private Integer monthBegin;
    private Integer monthEnd;
    private Collection<RegisterRoomEntity> registerRoomsById;
    private Collection<RentEntity> rentsById;
    private Collection<RentRoomEntity> rentRoomsById;

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
    @Column(name = "month")
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Basic
    @Column(name = "month_begin")
    public Integer getMonthBegin() {
        return monthBegin;
    }

    public void setMonthBegin(Integer monthBegin) {
        this.monthBegin = monthBegin;
    }

    @Basic
    @Column(name = "month_end")
    public Integer getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(Integer monthEnd) {
        this.monthEnd = monthEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemesterEntity that = (SemesterEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(month, that.month) &&
                Objects.equals(monthBegin, that.monthBegin) &&
                Objects.equals(monthEnd, that.monthEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, month, monthBegin, monthEnd);
    }

    @OneToMany(mappedBy = "semesterBySemesterId")
    @JsonIgnore
    public Collection<RegisterRoomEntity> getRegisterRoomsById() {
        return registerRoomsById;
    }

    public void setRegisterRoomsById(Collection<RegisterRoomEntity> registerRoomsById) {
        this.registerRoomsById = registerRoomsById;
    }

    @OneToMany(mappedBy = "semesterBySemesterId")
    @JsonIgnore
    public Collection<RentEntity> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<RentEntity> rentsById) {
        this.rentsById = rentsById;
    }

    @OneToMany(mappedBy = "semesterBySemesterId")
    @JsonIgnore
    public Collection<RentRoomEntity> getRentRoomsById() {
        return rentRoomsById;
    }

    public void setRentRoomsById(Collection<RentRoomEntity> rentRoomsById) {
        this.rentRoomsById = rentRoomsById;
    }
}
