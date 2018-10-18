package com.example.dorm_management.services;

import com.example.dorm_management.entities.RegisterRoom;

public interface RegisterRoomService {
    RegisterRoom findOneByRoomId(Integer roomId);

    RegisterRoom addOne(RegisterRoom registerRoom);
}
