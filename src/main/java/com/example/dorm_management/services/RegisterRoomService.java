package com.example.dorm_management.services;

import com.example.dorm_management.entities.RegisterRoom;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RegisterRoomService {
    RegisterRoom findOneById(Integer id);

    List<RegisterRoom> findAllByRoomId(Integer roomId);

    RegisterRoom addOne(RegisterRoom registerRoom);

    RegisterRoom edditOne(RegisterRoom registerRoom, Integer id);

    RegisterRoom acceptOne(RegisterRoom x);

    List<RegisterRoom> findAllAcceptedByRoomId(Integer id);


    List<RegisterRoom> findAllNotAcceptedByRoomId(Integer id);

}
