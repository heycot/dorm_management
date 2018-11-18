package com.example.dorm_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.sql.Timestamp;


@Getter
@Setter
@Builder
@Entity
@Data
@Table(name = "notification")
public class Notification {
    //------------------status ---------------------------
    public final static Integer NOTIFICATION_STATUS_READED   = 1;
    public final static Integer NOTIFICATION_STATUS_NOT_READ = 0;

    //-------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String content;

    private Integer status;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "user_id")
    private Integer userId;

    private Timestamp time;

    public Notification() {
    }

    public static Notification.NotificationBuilder builder() {
        return new Notification.NotificationBuilder();
    }

    @ConstructorProperties({"title", "content", "status", "roomId", "userId", "time"})
    Notification(String title, String content, Integer status, Integer roomId, Integer userId, Timestamp time) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.roomId = roomId;
        this.userId = userId;
        this.time = time;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    //==================================================================================================================

    public static class NotificationBuilder {

        private String title;
        private String content;
        private Integer status;
        private Integer roomId;
        private Integer userId;
        private Timestamp time;

        NotificationBuilder() {
        }

        public Notification.NotificationBuilder title(String title) {
            this.title = title;
            return this;
        }

        public Notification.NotificationBuilder content(String content) {
            this.content = content;
            return this;
        }

        public Notification.NotificationBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public Notification.NotificationBuilder roomId(Integer roomId) {
            this.roomId = roomId;
            return this;
        }

        public Notification.NotificationBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Notification.NotificationBuilder time(Timestamp time) {
            this.time = time;
            return this;
        }

        public Notification build(){
            return new Notification(this.title, this.content, this.status, this.roomId, this.userId, this.time);
        }
    }
}