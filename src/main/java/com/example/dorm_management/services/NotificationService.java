package com.example.dorm_management.services;

import com.example.dorm_management.entities.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> findOneByRoomId (Integer room_id);

    List<Notification> findOneBYUserId(Integer user_id);

    List<Notification> findAllOfUser(Integer user_id, Integer room_id);

    public boolean addNotification(Notification notification);
    public boolean deleteNotification(Integer id);
    public boolean updateNotification(Integer id, Notification notification);

    Notification readOne(Integer id, int i);
}
