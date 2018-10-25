package com.example.dorm_management.services;

import com.example.dorm_management.entities.RentRoom;
import com.example.dorm_management.respositories.RentRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentRoomServiceImpl implements RentRoomService {

    @Autowired
    private RentRoomRepository rentRoomRepository;

    @Override
    public RentRoom findOneByUserId(Integer userId, Integer status) {
        return rentRoomRepository.findOneByUserId(userId, status);
    }
}
