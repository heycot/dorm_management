package com.example.dorm_management.services;

import com.example.dorm_management.entities.Cost;

public interface CostService {

    Cost findOneByIdAndLevel(Integer id, Integer level);

    Cost findOneByTypeAndLevel(Integer type, Integer level, Integer status);
}
