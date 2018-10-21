package com.example.dorm_management.services;

import com.example.dorm_management.entities.Notification;
import com.example.dorm_management.respositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
