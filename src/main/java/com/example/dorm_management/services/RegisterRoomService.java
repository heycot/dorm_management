package com.example.dorm_management.services;

import com.example.dorm_management.entities.RegisterRoom;
import com.example.dorm_management.entities.TimeRegister;
import com.example.dorm_management.entities.ViewRegisterRoom;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RegisterRoomService {
    RegisterRoom findOneById(Integer id);

    List<ViewRegisterRoom> findAllByRoomId(Integer roomId);

    List<ViewRegisterRoom> findAllByUserId(Integer userId);

    RegisterRoom addOne(RegisterRoom registerRoom);

    RegisterRoom editOne(RegisterRoom registerRoom, Integer id);

    RegisterRoom acceptOne(Integer id);

    List<ViewRegisterRoom> findAllAcceptedByRoomId(Integer id);


    List<ViewRegisterRoom> findAllNotAcceptedByRoomId(Integer id);

    ViewRegisterRoom deleteOne(Integer registerId, boolean isRent);

    ViewRegisterRoom getOneViewById(Integer id);

    List<ViewRegisterRoom> findAllByAreaId(Integer id);

    List<ViewRegisterRoom> findAllByFloorId(Integer id);

    Integer countRegisterByRoomId(Integer roomId);

    List<TimeRegister> findAllTimeRegisterBySemesterId(Integer id);
    List<TimeRegister> findAllTimeRegister();
    TimeRegister findTimeRegisterById(Integer id);
    boolean addTimeRegister(TimeRegister timeRegister);
    boolean deleteTimeRegisterById(Integer id);
    boolean deleteTimeRegisterBySemesterId(Integer idSemester);
    boolean changeStatusById(Integer id);
    List<TimeRegister> findTimeRegisterByTime(String time);


}
