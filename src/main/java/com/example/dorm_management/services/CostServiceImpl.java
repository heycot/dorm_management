package com.example.dorm_management.services;

import com.example.dorm_management.entities.Cost;
import com.example.dorm_management.respositories.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostServiceImpl implements CostService {

    @Autowired
    private CostRepository costRepository;

    @Override
    public Cost findOneByIdAndLevel(Integer id, Integer level) {
        return costRepository.findOneByIdAndLevel(id, level);
    }

    @Override
    public Cost findOneByTypeAndLevel(Integer type, Integer level, Integer status) {
        return costRepository.findOneByTypeAndLevel(type, level, status);
    }
}
