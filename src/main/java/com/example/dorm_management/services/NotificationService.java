package com.example.dorm_management.services;

import com.example.dorm_management.entities.Notification;

/**
 * Created by vuong on 10/22/2018.
 */
public interface NotificationService {
    public boolean addNotification(Notification notification);
    public boolean deleteNotification(Integer id);
    public boolean updateNotification(Integer id, Notification notification);
}
