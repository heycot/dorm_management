package com.example.dorm_management.services;

import com.example.dorm_management.entities.SubsistenceFee;
import com.example.dorm_management.entities.ViewSubsistence;

import java.util.List;

public interface SubsistenceFeeService {

    List<ViewSubsistence> findALlByRoomId(Integer roomId);

    SubsistenceFee addOne(SubsistenceFee subsistenceFee);

    SubsistenceFee editOne(SubsistenceFee subsistenceFee, Integer id);

    SubsistenceFee findOneById(Integer id);

    ViewSubsistence changeStatusOne(Integer id, Integer status);

    ViewSubsistence findViewOneById(Integer id);
}
