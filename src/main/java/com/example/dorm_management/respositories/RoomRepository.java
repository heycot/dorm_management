package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

//    @Query(value = "update room set status = ?1 where floor_id = ?2", nativeQuery = false)
//    Integer changeStatusRoomByFloorId(Integer status, Integer floorId);

    @Query(value = "select * from  room where floor_id = ?1 order by name asc", nativeQuery = true)
    List<Room> findAllByFloorId(Integer floorId);
}
