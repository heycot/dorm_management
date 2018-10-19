package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.RegisterRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRoomRepository extends JpaRepository<RegisterRoom, Integer> {

    @Query(value = "select * from register_room where id = ?1", nativeQuery = true)
    RegisterRoom findOneById(Integer id);

    @Query(value = "select * from register_room where room_id = ?1 order by id desc", nativeQuery = true)
    List<RegisterRoom> findAllByRoomId(Integer roomId);

    @Query(value = "select * from register_room where room_id = ?1 and status = ?2 order by id desc ", nativeQuery = true)
    List<RegisterRoom> findAllByRoomIdAndStatus(Integer id, Integer status);
}
