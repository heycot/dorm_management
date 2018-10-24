package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vuong on 10/22/2018.
 */
public interface NotificationRepositoty extends JpaRepository<Notification, Integer> {
}
