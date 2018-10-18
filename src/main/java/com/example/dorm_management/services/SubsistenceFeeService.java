package com.example.dorm_management.services;

import com.example.dorm_management.entities.SubsistenceFee;

import java.util.List;

public interface SubsistenceFeeService {

    List<SubsistenceFee> findALlByRoomId(Integer roomId);

    SubsistenceFee addOne(SubsistenceFee subsistenceFee);

    SubsistenceFee editOne(SubsistenceFee subsistenceFee, Integer id);
}
