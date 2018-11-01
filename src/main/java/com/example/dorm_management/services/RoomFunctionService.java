package com.example.dorm_management.services;

import com.example.dorm_management.entities.RoomFunction;

import java.util.List;

public interface RoomFunctionService {

    List<RoomFunction> getAllRoomFunction();

    RoomFunction findOneByTypeAndStatus(Integer type, Integer status);

    RoomFunction addOne(RoomFunction roomFunction);

    RoomFunction editOne(Integer id, RoomFunction roomFunction);

    RoomFunction changeStatus(Integer id, Integer status);
}
