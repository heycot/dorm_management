package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.beans.ConstructorProperties;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
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

    private Integer number;

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

    public static ViewRegisterRoom.ViewRegisterRoomBuilder builder() {
        return new ViewRegisterRoom.ViewRegisterRoomBuilder();
    }

    public ViewRegisterRoom() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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


    @ConstructorProperties({"id", "userId", "fullName", "gender", "number", "className", "studentCode", "year", "status", "timeCensor",
            "timeRegister", "semesterId", "semesterName", "roomId", "roomName", "floorId", "floorName", "areaId", "areaName"})
    ViewRegisterRoom(Integer id, Integer userId, String fullName, Integer gender, Integer number, String className, String studentCode, String year, Integer status, Timestamp timeCensor, Timestamp timeRegister, Integer semesterId, String semesterName, Integer roomId, String roomName, Integer floorId, String floorName, Integer areaId, String areaName) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.gender = gender;
        this.number = number;
        this.className = className;
        this.studentCode = studentCode;
        this.year = year;
        this.status = status;
        this.timeCensor = timeCensor;
        this.timeRegister = timeRegister;
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.roomId = roomId;
        this.roomName = roomName;
        this.floorId = floorId;
        this.floorName = floorName;
        this.areaId = areaId;
        this.areaName = areaName;
    }

    //==================================================================================================================
    public static class ViewRegisterRoomBuilder {

        private Integer id;
        private Integer userId;
        private String fullName;
        private Integer gender;
        private Integer number;
        private String className;
        private String studentCode;
        private String year;
        private Integer status;
        private Timestamp timeCensor;
        private Timestamp timeRegister;
        private Integer semesterId;
        private String semesterName;
        private Integer roomId;
        private String roomName;
        private Integer floorId;
        private String floorName;
        private Integer areaId;
        private String areaName;

        ViewRegisterRoomBuilder() {
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder fullName(String  fullName) {
            this.fullName = fullName;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder gender(Integer gender) {
            this.gender = gender;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder number(Integer number) {
            this.number = number;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder className(String className) {
            this.className = className;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder studentCode(String studentCode) {
            this.studentCode = studentCode;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder year(String year) {
            this.year = year;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder timeCensor(Timestamp timeCensor) {
            this.timeCensor = timeCensor;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder timeRegister(Timestamp timeRegister) {
            this.timeRegister = timeRegister;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder semesterId(Integer semesterId) {
            this.semesterId = semesterId;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder semesterName(String semesterName) {
            this.semesterName = semesterName;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder roomId(Integer roomId) {
            this.roomId = roomId;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder roomName(String roomName) {
            this.roomName = roomName;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder floorId(Integer floorId) {
            this.floorId = floorId;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder floorName(String floorName) {
            this.floorName = floorName;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder areaId(Integer areaId) {
            this.areaId = areaId;
            return this;
        }

        public ViewRegisterRoom.ViewRegisterRoomBuilder areaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public ViewRegisterRoom build(){
            return new ViewRegisterRoom(this.id, this.userId, this.fullName, this.gender,this.number, this.className, this.studentCode, this.year,
                    this.status, this.timeCensor, this.timeRegister, this.semesterId, this.semesterName, this.roomId, this.roomName,
                    this.floorId, this.floorName, this.areaId, this.areaName);
        }
    }
}
