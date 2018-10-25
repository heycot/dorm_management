package com.example.dorm_management.services;

import com.example.dorm_management.entities.Room;
import com.example.dorm_management.entities.ViewRoom;

import java.util.List;

public interface RoomService {
    List<ViewRoom> findRoomsByFloorId(Integer floorId, Integer areaId);

    List<ViewRoom> findRoomsByAreaId(Integer areaId);

    ViewRoom findRoomById(Integer id);
}
