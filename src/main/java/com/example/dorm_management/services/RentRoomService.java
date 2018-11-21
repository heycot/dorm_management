package com.example.dorm_management.services;

import com.example.dorm_management.entities.RentRoom;

public interface RentRoomService {

    RentRoom findOneByUserId(Integer userId, Integer status);

    RentRoom addOne(RentRoom rentRoom);

    boolean changeStatus(RentRoom rentRoom, Integer status);

    Integer countPresentByRoomId(Integer roomId);
}
