package com.example.dorm_management.services;

import com.example.dorm_management.entities.TimeRegister;
import com.example.dorm_management.respositories.TimeRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TimeRegisterServiceImpl implements TimeRegisterService {

    @Autowired
    private TimeRegisterRepository timeRegisterRepository;

    @Override
    public List<TimeRegister> findAll() {
        return timeRegisterRepository.findAll();
    }

    @Override
    public TimeRegister findOneById(Integer id) {
        return timeRegisterRepository.findOne(id);
    }

    @Override
    public TimeRegister addOne(TimeRegister timeRegister) {
        return timeRegisterRepository.save(timeRegister);
    }

    @Override
    public TimeRegister editOne(Integer id, TimeRegister timeRegister) {

        TimeRegister timeRegisterEdit = timeRegisterRepository.findOne(id);

        timeRegisterEdit.setStatus(timeRegister.getStatus());
        timeRegisterEdit.setDateBegin(timeRegister.getDateBegin());
        timeRegisterEdit.setDateEnd(timeRegister.getDateEnd());
        return timeRegisterRepository.save(timeRegisterEdit);
    }

    @Override
    public TimeRegister changeStautusOne(Integer id, Integer status) {
        if (status != TimeRegister.TIME_REGISTER_ENABLE) {
            status = TimeRegister.TIME_REGISTER_DISABLE;
        }
        TimeRegister timeRegister = timeRegisterRepository.findOne(id);

        timeRegister.setStatus(status);
        return timeRegisterRepository.save(timeRegister);
    }

    @Override
    public TimeRegister findOneByDateBeginAndEnd(Timestamp dtBegin, Timestamp dtEnd) {
        return timeRegisterRepository.findOneByDateBeginAndEnd(dtBegin, dtEnd);
    }

    @Override
    public TimeRegister findOneCurrentTime(Timestamp curTime) {
        return timeRegisterRepository.findOneCurrentTime(curTime);
    }
}