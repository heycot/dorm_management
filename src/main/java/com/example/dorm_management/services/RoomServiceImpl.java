package com.example.dorm_management.services;

import com.example.dorm_management.entities.Room;
import com.example.dorm_management.respositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomREpository;

    @Override
    public List<Room> findRoomsByFloorId(Integer floorId, Integer areaId) {
        return roomREpository.findRoomsByFloorId(floorId, areaId);
    }

    @Override
    public List<Room> findRoomsByAreaId(Integer areaId) {
        return roomREpository.findRoomsByAreaId(areaId);
    }

    @Override
    public Room findRoomById(Integer id) {
        return roomREpository.findOne(id);
    }
}
