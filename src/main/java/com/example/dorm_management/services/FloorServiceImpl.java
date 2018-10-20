package com.example.dorm_management.services;

import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.respositories.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorRepository floorRepository;

    @Override
    public List<Floor> findFloorsByAreaId(Integer areaId) {
        return floorRepository.getFloorsByAreaId(areaId);
    }

    @Override
    public Floor findOneById(Integer id) {
        return floorRepository.findOneById(id);
    }
}
