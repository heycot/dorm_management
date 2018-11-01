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

    @Override
    public Floor addOneFloor(Floor floor) {

        return floorRepository.save(floor);
    }

    @Override
    public Floor editOne(Integer id, Floor floor){
        try {
            Floor floor1 = floorRepository.findOneById(id);

            floor1.setAreaId(floor.getAreaId());
            floor1.setName(floor.getName());
            floor1.setStatus(floor.getStatus());

            floorRepository.save(floor1);
            return floor1;
        } catch (Exception e){
            System.out.println(e.getCause());

            return null;
        }
    }

    @Override
    public Floor changeStatus(Integer id, Integer status){
        try {
            Floor floor = floorRepository.findOne(id);

            floor.setStatus(status);

            return floor;
        } catch (Exception e) {
            System.out.println(e.getCause());

            return null;
        }
    }
}
