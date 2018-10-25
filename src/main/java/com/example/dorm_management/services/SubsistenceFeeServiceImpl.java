package com.example.dorm_management.services;

import com.example.dorm_management.entities.SubsistenceFee;
import com.example.dorm_management.entities.ViewSubsistence;
import com.example.dorm_management.respositories.SubsistenceFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsistenceFeeServiceImpl implements SubsistenceFeeService {

    @Autowired
    private SubsistenceFeeRepository subsistenceFeeRepository;

    @Override
    public List<ViewSubsistence> findALlByRoomId(Integer roomId) {
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

    @Override
    public SubsistenceFee findOneById(Integer id) {
        return subsistenceFeeRepository.findOne(id);
    }

    @Override
    public ViewSubsistence changeStatusOne(Integer id, Integer status) {
        try {
            SubsistenceFee subsistenceFee1 = subsistenceFeeRepository.findOne(id);

            subsistenceFee1.setStatus(status);


            subsistenceFeeRepository.save(subsistenceFee1);

            ViewSubsistence viewSubsistence = subsistenceFeeRepository.findViewOne(id);
            return viewSubsistence;
        } catch (Exception e) {
            System.out.println(e.getCause());

            return  null;
        }
    }

    @Override
    public ViewSubsistence findViewOneById(Integer id) {
        return subsistenceFeeRepository.findViewOne(id);
    }

    @Override
    public List<ViewSubsistence> getAllSubsistenceNotPayBYMonthAndYear(Integer month, Integer year) {
        return subsistenceFeeRepository.getAllSubsistenceNotPayBYMonthAndYear(month, year);
    }

    @Override
    public List<ViewSubsistence> getAllSubsistenceNotPay(Integer status){
        return subsistenceFeeRepository.getAllSubsistenceNotPay(status);
    }
}
