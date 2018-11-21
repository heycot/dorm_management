package com.example.dorm_management.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "register_room")
public class RegisterRoom {
    //------------------status ---------------------------
    public final static Integer REGISTER_STATUS_ENABLE  = 1;
    public final static Integer REGISTER_STATUS_DISABLE = 0;

    //-------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    @NotNull
    private Integer number;

    @NotNull
    @Column(name = "semester_id")
    private Integer semesterId;

    @NotNull
    @Column(name = "room_id")
    private Integer roomId;

    @NotNull
    private String year;

    private Integer status;

    @Column(name = "time_censor")
    private Timestamp timeCensor;

    @Column(name = "time_register")
    private Timestamp timeRegister;

    @ConstructorProperties({"userId", "number", "semesterId", "roomId", "year", "status", "timeCensor", "timeRegister"})
    RegisterRoom(Integer userId, Integer number, Integer semesterId, Integer roomId, String year, Integer status, Timestamp timeCensor, Timestamp timeRegister) {
        this.userId = userId;
        this.number = number;
        this.semesterId = semesterId;
        this.roomId = roomId;
        this.year = year;
        this.status = status;
        this.timeCensor = timeCensor;
        this.timeRegister = timeRegister;
    }

    public static RegisterRoom.RegisterRoomBuilder builder() {
        return new RegisterRoom.RegisterRoomBuilder();
    }

    public RegisterRoom() {
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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

    //==================================================================================================================

    public static class RegisterRoomBuilder {

        private Integer userId;
        private Integer number;
        private Integer semesterId;
        private Integer roomId;
        private String year;
        private Integer status;
        private Timestamp timeCensor;
        private Timestamp timeRegister;

        RegisterRoomBuilder() {
        }

        public RegisterRoom.RegisterRoomBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public RegisterRoom.RegisterRoomBuilder number(Integer number) {
            this.number = number;
            return this;
        }

        public RegisterRoom.RegisterRoomBuilder semesterId(Integer semesterId) {
            this.semesterId = semesterId;
            return this;
        }


        public RegisterRoom.RegisterRoomBuilder roomId(Integer roomId) {
            this.roomId = roomId;
            return this;
        }

        public RegisterRoom.RegisterRoomBuilder year(String year) {
            this.year = year;
            return this;
        }

        public RegisterRoom.RegisterRoomBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public RegisterRoom.RegisterRoomBuilder timeCensor(Timestamp timeCensor) {
            this.timeCensor = timeCensor;
            return this;
        }


        public RegisterRoom.RegisterRoomBuilder timeRegister(Timestamp timeRegister) {
            this.timeRegister = timeRegister;
            return this;
        }

        public RegisterRoom build(){
            return new RegisterRoom(this.userId, this.number, this.semesterId, this.roomId, this.year, this.status, this.timeCensor, this.timeRegister);
        }
    }
}
