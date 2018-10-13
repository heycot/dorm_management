package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "select * from room where floor_id = ?1 and area_id = ?2", nativeQuery = true)
    List<Room> findRoomsByFloorId(Integer floorId, Integer areaId);

    @Query(value = "select  * from room where area_id = ?1", nativeQuery = true)
    List<Room> findRoomsByAreaId(Integer id);
}
