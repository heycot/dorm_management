package com.example.dorm_management.services;

import com.example.dorm_management.entities.Floor;

import java.util.List;

public interface FloorService  {

    List<Floor> findFloorsByAreaId(Integer areaId);

    Floor findOneById(Integer id);

    Floor addOneFloor(Floor floor);

    Floor editOne(Integer id, Floor floor);

    Floor changeStatus(Integer id, Integer status);

    Integer changeStatusByAreaIdAndStatus(Integer status, Integer areaId);
}
