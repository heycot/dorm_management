package com.example.dorm_management.services;

import com.example.dorm_management.entities.TimeRegister;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

public interface TimeRegisterService {

    List<TimeRegister> findAll();

    TimeRegister findOneById(Integer id);

    TimeRegister addOne(TimeRegister timeRegister);

    TimeRegister editOne(Integer id, TimeRegister timeRegister);

    TimeRegister changeStautusOne(Integer id, Integer status);

    TimeRegister findOneByDateBeginAndEnd(Timestamp dtBegin, Timestamp dtEnd);

    TimeRegister findOneCurrentTime(Timestamp curTime);
}
