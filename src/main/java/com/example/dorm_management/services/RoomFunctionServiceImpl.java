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
}
