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

    @Autowired
    private RegisterRoomService registerRoomService;

    @Autowired
    private RentRoomService rentRoomService;

    @Override
    public List<ViewRoom> findRoomsByFloorId(Integer floorId) {
        return viewRoomRepository.findRoomsByFloorId(floorId);
    }

    @Override
    public List<Room> findAllByFloorId(Integer floorId) {
        return roomRepository.findAllByFloorId(floorId);
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
            room.setStudentRegister(0);
            room.setStudentPresent(0);
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

            roomEdit.setStudentRegister(registerRoomService.countRegisterByRoomId(id));
            roomEdit.setStudentPresent(rentRoomService.countPresentByRoomId(id));

            return  roomRepository.save(roomEdit);
        } catch (Exception e){
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public Room changeStatus(Integer roomId, Integer status) {
        try {
            if (status != Room.ROOM_STATUS_ENABLE) {
                status = Room.ROOM_STATUS_DISABLE;
            }

            Room roomEdit = roomRepository.findOne(roomId);

            roomEdit.setStatus(status);
            return roomRepository.save(roomEdit);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public Integer changeStatusRoomByFloorId(Integer status, Integer floorId) {
        if (status != Room.ROOM_STATUS_ENABLE) {
            status = Room.ROOM_STATUS_DISABLE;
        }

        Integer result = 0;
        List<Room> roomList = roomRepository.findAllByFloorId(floorId);
        for (Room room : roomList) {
            room.setStatus(status);
            if( roomRepository.save(room) != null) {
                result++;
            }
        }
        return  result;
    }

    @Override
    public void updateRegisterRoom(Integer roomId) {
        Room room = roomRepository.findOne(roomId);

        room.setStudentRegister(registerRoomService.countRegisterByRoomId(roomId));

        roomRepository.save(room);
    }

    @Override
    public void updatePresentRoom(Integer roomId) {
        Room room = roomRepository.findOne(roomId);

        room.setStudentPresent(rentRoomService.countPresentByRoomId(roomId));

        roomRepository.save(room);
    }

}
