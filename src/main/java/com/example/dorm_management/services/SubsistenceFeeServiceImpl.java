package com.example.dorm_management.services;

import com.example.dorm_management.entities.Cost;
import com.example.dorm_management.entities.SubsistenceFee;
import com.example.dorm_management.entities.ViewSubsistence;
import com.example.dorm_management.respositories.SubsistenceFeeRepository;
import com.example.dorm_management.respositories.ViewSubsistenceFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsistenceFeeServiceImpl implements SubsistenceFeeService {

    @Autowired
    private SubsistenceFeeRepository subsistenceFeeRepository;


    @Autowired
    private CostService costService;

    @Autowired
    private ViewSubsistenceFeeRepository viewSubsistenceFeeRepository;

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
        if (subsistenceFee.getNewNumberElec() - subsistenceFee.getOldNumberElec() >= 100) {
            subsistenceFee.setLevelElec(2);
        } else {
            subsistenceFee.setLevelElec(1);
        }

        if (subsistenceFee.getNewNumberWater() - subsistenceFee.getOldNumberWater() >= 100) {
            subsistenceFee.setLevelWater(2);
        } else {
            subsistenceFee.setLevelWater(1);
        }

        Cost costsElec = costService.findOneByTypeAndLevel(2, subsistenceFee.getLevelElec(), 1);
        Cost costWater = costService.findOneByTypeAndLevel(3, subsistenceFee.getLevelWater(), 1 );

        subsistenceFee.setCostElec(costsElec.getValue());
        subsistenceFee.setCostWater(costWater.getValue());
        subsistenceFee.setTotalElec((subsistenceFee.getNewNumberElec() - subsistenceFee.getOldNumberElec()) * costsElec.getValue());
        subsistenceFee.setTotalWater((subsistenceFee.getNewNumberWater() - subsistenceFee.getOldNumberWater()) * costWater.getValue());

        subsistenceFee.setTotal(subsistenceFee.getTotalElec() + subsistenceFee.getTotalWater());
        subsistenceFee.setStatus(0);

        return subsistenceFeeRepository.save(subsistenceFee);
    }

    @Override
    public SubsistenceFee editOne(SubsistenceFee subsistenceFee, Integer id){
       try {

           //---------- change some information of subsistenceFee------------------------------------------------------
           if (subsistenceFee.getNewNumberElec() - subsistenceFee.getOldNumberElec() >= 100) {
               subsistenceFee.setLevelElec(2);
           } else {
               subsistenceFee.setLevelElec(1);
           }

           if (subsistenceFee.getNewNumberWater() - subsistenceFee.getOldNumberWater() >= 100) {
               subsistenceFee.setLevelWater(2);
           } else {
               subsistenceFee.setLevelWater(1);
           }

           Cost costsElec = costService.findOneByTypeAndLevel(2, subsistenceFee.getLevelElec(), 1);
           Cost costWater = costService.findOneByTypeAndLevel(3, subsistenceFee.getLevelWater(), 1 );

           subsistenceFee.setCostElec(costsElec.getValue());
           subsistenceFee.setCostWater(costWater.getValue());
           subsistenceFee.setTotalElec((subsistenceFee.getNewNumberElec() - subsistenceFee.getOldNumberElec()) * costsElec.getValue());
           subsistenceFee.setTotalWater((subsistenceFee.getNewNumberWater() - subsistenceFee.getOldNumberWater()) * costWater.getValue());

           subsistenceFee.setTotal(subsistenceFee.getTotalElec() + subsistenceFee.getTotalWater());
           subsistenceFee.setStatus(0);

           //------------ edit subsistenceFee --------------------------------------------------------------------------
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
           subsistenceFeeEdit.setCostWater(subsistenceFee.getCostWater());
           subsistenceFeeEdit.setCostElec(subsistenceFee.getCostElec());

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

            return subsistenceFeeRepository.save(subsistenceFee1);
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
    public List<SubsistenceFee> getAllSubsistenceNotPay(Integer status){
        return subsistenceFeeRepository.getAllSubsistenceNotPay(status);
    }

    @Override
    public List<ViewSubsistence> getAllViewSubsistenceByMonthAndYear(Integer month, String year) {
        return viewSubsistenceFeeRepository.getAllViewSubsistence(month, year);

    }

    @Override
    public List<SubsistenceFee> getAllSubsistenceByMonthAndYearAndRoomId(Integer roomId, Integer month, String year) {
        return subsistenceFeeRepository.getAllSubsistenceByMonthAndYearAndRoomId(roomId, month, year);
    }

    @Override
    public List<SubsistenceFee> getAllSubsistenceNotPayBYMonthAndYear(Integer month, String year){
        return subsistenceFeeRepository.getAllSubsistenceNotPayBYMonthAndYear(month, year, 0);
    }

    @Override
    public List<ViewSubsistence> findAllViewByMonthAndYearAndAreaId(Integer areaId, Integer month, String year) {
        return viewSubsistenceFeeRepository.findAllViewByMonthAndYearAndAreaId( areaId, month, year) ;
    }
}
