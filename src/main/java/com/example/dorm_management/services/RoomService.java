package com.example.dorm_management.services;

import com.example.dorm_management.entities.Room;

import java.util.List;

public interface RoomService {
    List<Room> findRoomsByFloorId(Integer floorId, Integer areaId);

    List<Room> findRoomsByAreaId(Integer areaId);

    Room findRoomById(Integer id);
}
