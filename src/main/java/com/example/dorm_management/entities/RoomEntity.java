package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "dorm")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RoomEntity {
    private Integer id;
    private String name;
    private Integer gender;
    private Integer status;
    private Integer numberBed;
    private Integer studentMax;
    private Integer studentPresent;
    private Integer studentRegister;
    private Integer areaId;
    private Integer costId;
    private Integer floorId;
    private Integer functionId;
    private Collection<NotificationEntity> notificationsById;
    private Collection<RegisterRoomEntity> registerRoomsById;
    private Collection<RentEntity> rentsById;
    private Collection<RentRoomEntity> rentRoomsById;
    private AreaEntity areaByAreaId;
    private CostEntity costByCostId;
    private FloorEntity floorByFloorId;
    private RoomFunctionEntity roomFunctionByFunctionId;
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
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "number_bed")
    public Integer getNumberBed() {
        return numberBed;
    }

    public void setNumberBed(Integer numberBed) {
        this.numberBed = numberBed;
    }

    @Basic
    @Column(name = "student_max")
    public Integer getStudentMax() {
        return studentMax;
    }

    public void setStudentMax(Integer studentMax) {
        this.studentMax = studentMax;
    }

    @Basic
    @Column(name = "student_present")
    public Integer getStudentPresent() {
        return studentPresent;
    }

    public void setStudentPresent(Integer studentPresent) {
        this.studentPresent = studentPresent;
    }

    @Basic
    @Column(name = "student_register")
    public Integer getStudentRegister() {
        return studentRegister;
    }

    public void setStudentRegister(Integer studentRegister) {
        this.studentRegister = studentRegister;
    }

//    @Basic
//    @Column(name = "area_id")
//    public Integer getAreaId() {
//        return areaId;
//    }
//
//    public void setAreaId(Integer areaId) {
//        this.areaId = areaId;
//    }

//    @Basic
//    @Column(name = "cost_id")
//    public Integer getCostId() {
//        return costId;
//    }
//
//    public void setCostId(Integer costId) {
//        this.costId = costId;
//    }
//
//    @Basic
//    @Column(name = "floor_id")
//    public Integer getFloorId() {
//        return floorId;
//    }
//
//    public void setFloorId(Integer floorId) {
//        this.floorId = floorId;
//    }
//
//    @Basic
//    @Column(name = "function_id")
//    public Integer getFunctionId() {
//        return functionId;
//    }
//
//    public void setFunctionId(Integer functionId) {
//        this.functionId = functionId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(status, that.status) &&
                Objects.equals(numberBed, that.numberBed) &&
                Objects.equals(studentMax, that.studentMax) &&
                Objects.equals(studentPresent, that.studentPresent) &&
                Objects.equals(studentRegister, that.studentRegister) &&
                Objects.equals(areaId, that.areaId) &&
                Objects.equals(costId, that.costId) &&
                Objects.equals(floorId, that.floorId) &&
                Objects.equals(functionId, that.functionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, status, numberBed, studentMax, studentPresent, studentRegister, areaId, costId, floorId, functionId);
    }

    @OneToMany(mappedBy = "roomByRoomId")
    @JsonIgnore
    public Collection<NotificationEntity> getNotificationsById() {
        return notificationsById;
    }

    public void setNotificationsById(Collection<NotificationEntity> notificationsById) {
        this.notificationsById = notificationsById;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    @JsonIgnore
    public Collection<RegisterRoomEntity> getRegisterRoomsById() {
        return registerRoomsById;
    }

    public void setRegisterRoomsById(Collection<RegisterRoomEntity> registerRoomsById) {
        this.registerRoomsById = registerRoomsById;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    @JsonIgnore
    public Collection<RentEntity> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<RentEntity> rentsById) {
        this.rentsById = rentsById;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    @JsonIgnore
    public Collection<RentRoomEntity> getRentRoomsById() {
        return rentRoomsById;
    }

    public void setRentRoomsById(Collection<RentRoomEntity> rentRoomsById) {
        this.rentRoomsById = rentRoomsById;
    }

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public AreaEntity getAreaByAreaId() {
        return areaByAreaId;
    }

    public void setAreaByAreaId(AreaEntity areaByAreaId) {
        this.areaByAreaId = areaByAreaId;
    }

    @ManyToOne
    @JoinColumn(name = "cost_id", referencedColumnName = "id", nullable = false)
    public CostEntity getCostByCostId() {
        return costByCostId;
    }

    public void setCostByCostId(CostEntity costByCostId) {
        this.costByCostId = costByCostId;
    }

    @ManyToOne
    @JoinColumn(name = "floor_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public FloorEntity getFloorByFloorId() {
        return floorByFloorId;
    }

    public void setFloorByFloorId(FloorEntity floorByFloorId) {
        this.floorByFloorId = floorByFloorId;
    }

    @ManyToOne
    @JoinColumn(name = "function_id", referencedColumnName = "id", nullable = false)
    public RoomFunctionEntity getRoomFunctionByFunctionId() {
        return roomFunctionByFunctionId;
    }

    public void setRoomFunctionByFunctionId(RoomFunctionEntity roomFunctionByFunctionId) {
        this.roomFunctionByFunctionId = roomFunctionByFunctionId;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<SubsistenceFeeEntity> getSubsistenceFeesById() {
        return subsistenceFeesById;
    }

    public void setSubsistenceFeesById(Collection<SubsistenceFeeEntity> subsistenceFeesById) {
        this.subsistenceFeesById = subsistenceFeesById;
    }
}
