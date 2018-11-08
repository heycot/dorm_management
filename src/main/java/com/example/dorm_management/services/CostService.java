package com.example.dorm_management.services;

import com.example.dorm_management.entities.Cost;

import java.util.List;

public interface CostService {

    Cost findOneByIdAndLevel(Integer id, Integer level);

    Cost findOneByTypeAndLevel(Integer type, Integer level, Integer status);

    Cost findOneByTypeAndStatus(Integer  type, Integer status);

    List<Cost> findAll();

    Cost findOneById(Integer id);

    Cost findOneByTypeLevelAndStatus(Integer type, Integer level, Integer status);

    List<Cost> findAllByType(Integer type);

    Cost addOne(Cost costAdd);

    Cost editOne(Cost costEdit, Integer id);

    Cost changeStatus(Integer id, Integer status);
}
