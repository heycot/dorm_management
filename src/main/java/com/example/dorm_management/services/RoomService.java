package com.example.dorm_management.services;

import com.example.dorm_management.entities.Room;
import com.example.dorm_management.entities.ViewRoom;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface RoomService {
    List<ViewRoom> findRoomsByFloorId(Integer floorId);

    List<Room> findAllByFloorId(Integer floorId);

    List<ViewRoom> findRoomsByAreaId(Integer areaId);

    ViewRoom findRoomById(Integer id);

    Room addOne(Room room);

    Room editOne(Integer id, Room room);

    Room changeStatus(Integer roomId, Integer status);

    Integer changeStatusRoomByFloorId(Integer status, Integer floorId);

}
