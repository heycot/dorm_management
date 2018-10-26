package com.example.dorm_management.entities;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Data
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "user_id")
    private Integer user_id;

    private Integer status;

    public Notification(String title, String content, Integer roomId, Integer user_id, Integer status) {
        this.title = title;
        this.content = content;
        this.roomId = roomId;
        this.user_id = user_id;
        this.status = status;
    }

    public Notification() {}

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private User user;


//    public Notification(String title, String content, Integer status, Integer userId) {
//
//        this.title = title;
//        this.content = content;
//        this.status = status;
////        this.user = new User();
////        this.user.setId(userId);
//    }

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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
