package com.example.dorm_management.services;

import com.example.dorm_management.entities.SubsistenceFee;
import com.example.dorm_management.entities.ViewSubsistence;

import java.util.List;

public interface SubsistenceFeeService {

    List<SubsistenceFee> findALlByRoomId(Integer roomId);

    List<SubsistenceFee> findALlWaterByRoomId(Integer roomId);

    List<SubsistenceFee> findALlElecByRoomId(Integer roomId);

    SubsistenceFee addOne(SubsistenceFee subsistenceFee);

    SubsistenceFee editOne(SubsistenceFee subsistenceFee, Integer id);

    SubsistenceFee findOneById(Integer id);

    SubsistenceFee changeStatusOne(Integer id, Integer status);

    SubsistenceFee findViewOneById(Integer id);

    List<SubsistenceFee> getAllSubsistenceNotPay(Integer status);

    List<ViewSubsistence> getAllViewSubsistenceByMonthAndYear(Integer month, String year);

    List<SubsistenceFee> getAllSubsistenceByMonthAndYearAndRoomId(Integer roomId, Integer month, String year);

    List<SubsistenceFee> getAllSubsistenceNotPayBYMonthAndYear(Integer month, String year);

    List<ViewSubsistence> findAllViewByMonthAndYearAndAreaId(Integer areaId, Integer month, String year);
}
