package com.example.dorm_management.services;

import com.example.dorm_management.entities.Room;
import com.example.dorm_management.entities.ViewRoom;
import com.example.dorm_management.respositories.RoomRepository;
import com.example.dorm_management.respositories.ViewRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ViewRoomRepository viewRoomRepository;

    @Override
    public List<ViewRoom> findRoomsByFloorId(Integer floorId, Integer areaId) {
        return viewRoomRepository.findRoomsByFloorId(floorId, areaId);
    }

    @Override
    public List<ViewRoom> findRoomsByAreaId(Integer areaId) {
        return viewRoomRepository.findRoomsByAreaId(areaId);
    }

    @Override
    public ViewRoom findRoomById(Integer id) {
        return viewRoomRepository.findViewRoomById(id);
    }
}
