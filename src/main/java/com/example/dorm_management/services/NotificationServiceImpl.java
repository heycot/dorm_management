package com.example.dorm_management.services;

import com.example.dorm_management.entities.Notification;
import com.example.dorm_management.respositories.NotificationRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vuong on 10/22/2018.
 */
@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepositoty notificationRepositoty;
    @Override
    public boolean addNotification(Notification notification) {
        if(notification == null) return false;
        try {
             notificationRepositoty.save(notification);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteNotification(Integer id) {
        try {
            notificationRepositoty.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateNotification(Integer id, Notification notification) {
        try {
            Notification notification1 = notificationRepositoty.findOne(id);
            if(notification1 == null) return false;
            //TODO update status
            notification1.setStatus(notification.getStatus());
        }catch (Exception e){
            return true;
        }
        return false;
    }
}
