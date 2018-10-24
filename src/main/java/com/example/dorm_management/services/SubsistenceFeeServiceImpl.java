package com.example.dorm_management.services;

import com.example.dorm_management.entities.SubsistenceFee;
import com.example.dorm_management.respositories.SubsistenceFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsistenceFeeServiceImpl implements SubsistenceFeeService {

    @Autowired
    private SubsistenceFeeRepository subsistenceFeeRepository;

    @Override
    public List<SubsistenceFee> findALlByRoomId(Integer roomId) {
        return subsistenceFeeRepository.findALlByRoomId(roomId);
    }

    @Override
    public SubsistenceFee addOne(SubsistenceFee subsistenceFee){
        return subsistenceFeeRepository.save(subsistenceFee);
    }

    @Override
    public SubsistenceFee editOne(SubsistenceFee subsistenceFee, Integer id){
       try {
           SubsistenceFee subsistenceFeeEdit = subsistenceFeeRepository.findOne(id);
           subsistenceFeeEdit.setCostId(subsistenceFee.getCostId());
           subsistenceFeeEdit.setLevel(subsistenceFee.getLevel());
           subsistenceFeeEdit.setMonth(subsistenceFee.getMonth());
           subsistenceFeeEdit.setNewNumber(subsistenceFee.getNewNumber());
           subsistenceFeeEdit.setOldNumber(subsistenceFee.getOldNumber());
           subsistenceFeeEdit.setRoomId(subsistenceFee.getRoomId());
           subsistenceFeeEdit.setType(subsistenceFee.getType());
           subsistenceFeeEdit.setYear(subsistenceFee.getYear());
           subsistenceFeeEdit.setTotal(subsistenceFee.getTotal());
           subsistenceFeeEdit.setStatus(subsistenceFee.getStatus());

           subsistenceFeeRepository.save(subsistenceFeeEdit);

           return subsistenceFeeEdit;
       } catch (Exception e) {
           return null;
       }
    }
}
