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
    public List<SubsistenceFee> findALlWaterByRoomId(Integer roomId) {
//        return subsistenceFeeRepository.findALlWaterByRoomId(roomId, 2);
        return null;
    }

    @Override
    public List<SubsistenceFee> findALlElecByRoomId(Integer roomId) {
//        return subsistenceFeeRepository.findALlElecByRoomId(roomId, 3);
        return null;

    }

    @Override
    public SubsistenceFee addOne(SubsistenceFee subsistenceFee){
        return subsistenceFeeRepository.save(subsistenceFee);
    }

    @Override
    public SubsistenceFee editOne(SubsistenceFee subsistenceFee, Integer id){
       try {
           SubsistenceFee subsistenceFeeEdit = subsistenceFeeRepository.findOne(id);

           subsistenceFeeEdit.setMonth(subsistenceFee.getMonth());
           subsistenceFeeEdit.setRoomId(subsistenceFee.getRoomId());
           subsistenceFeeEdit.setYear(subsistenceFee.getYear());
           subsistenceFeeEdit.setTotal(subsistenceFee.getTotal());
           subsistenceFeeEdit.setStatus(subsistenceFee.getStatus());
           subsistenceFeeEdit.setLevelElec(subsistenceFee.getLevelElec());
           subsistenceFeeEdit.setLevelWater(subsistenceFee.getLevelWater());
           subsistenceFeeEdit.setNewNumberElec(subsistenceFee.getNewNumberElec());
           subsistenceFeeEdit.setNewNumberWater(subsistenceFee.getNewNumberWater());
           subsistenceFeeEdit.setOldNumberElec(subsistenceFee.getOldNumberElec());
           subsistenceFeeEdit.setOldNumberWater(subsistenceFee.getOldNumberWater());

           subsistenceFeeRepository.save(subsistenceFeeEdit);

           return subsistenceFeeEdit;
       } catch (Exception e) {
           return null;
       }
    }

    @Override
    public SubsistenceFee findOneById(Integer id) {
        return subsistenceFeeRepository.findOne(id);
    }

    @Override
    public SubsistenceFee changeStatusOne(Integer id, Integer status) {
        try {
            SubsistenceFee subsistenceFee1 = subsistenceFeeRepository.findOne(id);

            subsistenceFee1.setStatus(status);

            subsistenceFeeRepository.save(subsistenceFee1);

            return subsistenceFee1;
        } catch (Exception e) {
            System.out.println(e.getCause());

            return  null;
        }
    }

    @Override
    public SubsistenceFee findViewOneById(Integer id) {
        return subsistenceFeeRepository.findViewOne(id);
    }

    @Override
    public List<SubsistenceFee> getAllSubsistenceNotPayBYMonthAndYear(Integer month, Integer year) {
        return subsistenceFeeRepository.getAllSubsistenceNotPayBYMonthAndYear(month, year);
    }

    @Override
    public List<SubsistenceFee> getAllSubsistenceNotPay(Integer status){
        return subsistenceFeeRepository.getAllSubsistenceNotPay(status);
    }
}
