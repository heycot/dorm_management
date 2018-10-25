package com.example.dorm_management.services;

import com.example.dorm_management.entities.RentRoom;

public interface RentRoomService {

    RentRoom findOneByUserId(Integer userId, Integer status);

}
