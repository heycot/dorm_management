package com.example.dorm_management.services;

import com.example.dorm_management.entities.RoomFunction;
import com.example.dorm_management.respositories.RoomFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomFunctionServiceImpl implements RoomFunctionService {

    @Autowired
    private RoomFunctionRepository roomFunctionRepository;

    @Override
    public List<RoomFunction> getAllRoomFunction() {
        return roomFunctionRepository.findAll();
    }

    @Override
    public RoomFunction findOneByTypeAndStatus(Integer type, Integer status){
        return roomFunctionRepository.findOneByTypeAndStatus(type, status);
    }

    @Override
    public RoomFunction addOne(RoomFunction roomFunction){
        try {
            roomFunctionRepository.save(roomFunction);

            return roomFunction;
        } catch (Exception e) {
            System.out.println(e.getCause());

            return null;
        }
    }

    @Override
    public RoomFunction editOne(Integer id, RoomFunction roomFunction){
        try {
            RoomFunction roomFunctionEdit = roomFunctionRepository.findOne(id);

            roomFunctionEdit.setName(roomFunction.getName());
            roomFunctionEdit.setStatus(roomFunction.getStatus());

            return roomFunctionEdit;
        } catch (Exception e) {
            System.out.println(e.getCause());

            return null;
        }
    }

    @Override
    public RoomFunction changeStatus(Integer id, Integer status){
        try {
            RoomFunction roomFunctionEdit = roomFunctionRepository.findOne(id);

            roomFunctionEdit.setStatus(status);

            return roomFunctionEdit;
        } catch (Exception e) {
            System.out.println(e.getCause());

            return null;
        }
    }

}
