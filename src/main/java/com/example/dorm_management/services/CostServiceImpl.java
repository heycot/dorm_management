package com.example.dorm_management.services;

import com.example.dorm_management.entities.Cost;
import com.example.dorm_management.respositories.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Cost findOneByTypeAndStatus(Integer type, Integer status){
        return costRepository.findOneByTypeAndStatus(type, status);
    }

    @Override
    public List<Cost> findAll() {
        return costRepository.findAll();
    }

    @Override
    public Cost findOneById(Integer id) {
        return costRepository.findOne(id);
    }

    @Override
    public Cost findOneByTypeLevelAndStatus(Integer type, Integer level, Integer status) {
        return costRepository.findOneByTypeAndLevel(type, level, status);
    }

    @Override
    public List<Cost> findAllByType(Integer type) {
        return costRepository.findAllByType(type);
    }

    @Override
    public Cost addOne(Cost costAdd) {
        return costRepository.save(costAdd);
    }

    @Override
    public Cost editOne(Cost costEdit, Integer id) {
        Cost cost = costRepository.findOne(id);

        cost.setLevel(costEdit.getLevel());
        cost.setName(costEdit.getName());
        cost.setStatus(costEdit.getStatus());
        cost.setType(costEdit.getType());
        cost.setValue(costEdit.getValue());

        return costRepository.save(cost);
    }

    @Override
    public Cost changeStatus(Integer id, Integer status) {
        Cost cost = costRepository.findOne(id);

        cost.setStatus(status);

        return costRepository.save(cost);
    }
}
