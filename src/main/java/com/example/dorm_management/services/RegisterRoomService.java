package com.example.dorm_management.services;

import com.example.dorm_management.entities.RegisterRoom;

import java.util.List;

public interface RegisterRoomService {
    RegisterRoom findOneById(Integer id);

    List<RegisterRoom> findAllByRoomId(Integer roomId);

    RegisterRoom addOne(RegisterRoom registerRoom);
}
