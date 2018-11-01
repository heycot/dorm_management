package com.example.dorm_management.services;

import com.example.dorm_management.entities.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dorm_management.respositories.NotificationRepository;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> findOneByRoomId(Integer room_id) {
        return notificationRepository.findOneByRoomId(room_id);
    }

    @Override
    public List<Notification> findOneBYUserId(Integer user_id) {

        return notificationRepository.findOneBYUserId(user_id);
    }

    @Override
    public List<Notification> findAllOfUser(Integer user_id, Integer room_id) {
        return notificationRepository.findAllOfUser(user_id, room_id);
    }

    @Override
    public boolean addNotification(Notification notification) {
        if(notification == null) return false;
        try {
             notificationRepository.save(notification);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteNotification(Integer id) {
        try {
            notificationRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateNotification(Integer id, Notification notification) {
        try {
            Notification notification1 = notificationRepository.findOne(id);
            if(notification1 == null) return false;
            //TODO update status
            notification1.setStatus(notification.getStatus());
        }catch (Exception e){
            return true;
        }
        return false;
    }

    @Override
    public Notification readOne(Integer id, int status){
        try{
            Notification notification = notificationRepository.findOne(id);

            notification.setStatus(status);

            notificationRepository.save(notification);
            return  notification;
        } catch (Exception e) {
            return  null;
        }
    }

    @Override
    public Notification deleteOne(Integer id){
        try {
            Notification notification = notificationRepository.findOne(id);
            notificationRepository.delete(id);

            return notification;
        } catch (Exception e) {
            System.out.println(e.getCause());

            return null;
        }

    }
}
