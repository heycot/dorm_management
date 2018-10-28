package com.example.dorm_management.services;

import com.example.dorm_management.entities.AreaEntity;
import com.example.dorm_management.respositories.AreaEntiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaEntiryService {

    @Autowired
    private AreaEntiryRepository areaEntiryRepository;

    public AreaEntity findall(Integer id){
        return areaEntiryRepository.findOne(id);
    }
}
