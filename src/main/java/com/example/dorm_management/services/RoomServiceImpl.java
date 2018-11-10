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
    public List<ViewRoom> findRoomsByFloorId(Integer floorId) {
        return viewRoomRepository.findRoomsByFloorId(floorId);
    }

    @Override
    public List<ViewRoom> findRoomsByAreaId(Integer areaId) {
        return viewRoomRepository.findRoomsByAreaId(areaId);
    }

    @Override
    public ViewRoom findRoomById(Integer id) {
        return viewRoomRepository.findViewRoomById(id);
    }

    @Override
    public Room addOne(Room room){
        try{
            return  roomRepository.save(room);
        } catch (Exception e){
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public Room editOne(Integer id, Room room){
        try{
            Room roomEdit = roomRepository.findOne(id);

            roomEdit.setCostId(room.getCostId());
            roomEdit.setFloorId(room.getFloorId());
            roomEdit.setFunctionId(room.getFunctionId());
            roomEdit.setNumberBed(room.getNumberBed());
            roomEdit.setGender(room.getGender());
            roomEdit.setStatus(room.getStatus());
            roomEdit.setName(room.getName());
            roomEdit.setStudentMax(room.getStudentMax());
            roomEdit.setStudentPresent(room.getStudentPresent());
            roomEdit.setStudentRegister(room.getStudentRegister());

            return  roomRepository.save(roomEdit);
        } catch (Exception e){
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public Room changeStatus(Integer roomId, Integer status) {
        try {
            Room roomEdit = roomRepository.findOne(roomId);

            roomEdit.setStatus(status);
            return roomEdit;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

}
