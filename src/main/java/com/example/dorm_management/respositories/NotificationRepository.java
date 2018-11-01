package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query(value = "select * from notification where room_id = ?1 order by id desc ", nativeQuery = true)
    List<Notification> findOneByRoomId(Integer room_id);

    @Query(value = "select * from notification where user_id = ?1 order by id desc ", nativeQuery = true)
    List<Notification> findOneBYUserId(Integer user_id);

    @Query(value = "select * from notification where user_id = ?1 or room_id = ?2 order by id desc ", nativeQuery = true)
    List<Notification> findAllOfUser(Integer user_id, Integer room_id);
}
