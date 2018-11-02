package com.example.dorm_management.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ViewRegisterRoom {

    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_full_name")
    private String fullName;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "class_name")
    private String className;

    @Column(name = "studentcode_code_value")
    private String studentCode;

    private String year;

    private Integer status;

    @Column(name = "time_censor")
    private Timestamp timeCensor;

    @Column(name = "time_register")
    private Timestamp timeRegister;

    @Column(name = "semester_id")
    private Integer semesterId;

    @Column(name = "semester_name")
    private String semesterName;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "floor_id")
    private Integer floorId;

    @Column(name = "floor_name")
    private String floorName;

    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "area_name")
    private String areaName;

    public ViewRegisterRoom() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getTimeCensor() {
        return timeCensor;
    }

    public void setTimeCensor(Timestamp timeCensor) {
        this.timeCensor = timeCensor;
    }

    public Timestamp getTimeRegister() {
        return timeRegister;
    }

    public void setTimeRegister(Timestamp timeRegister) {
        this.timeRegister = timeRegister;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
