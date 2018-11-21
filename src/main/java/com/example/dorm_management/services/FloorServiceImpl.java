package com.example.dorm_management.services;

import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.entities.Room;
import com.example.dorm_management.respositories.FloorRepository;
import com.example.dorm_management.respositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.management.Query;
import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private RoomService roomService;

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

            if (status != Floor.FLOOR_STATUS_ENABLE) {
                status = Floor.FLOOR_STATUS_DISABLE;
            }

            Floor floor = floorRepository.findOne(id);

            floor.setStatus(status);

            Integer result = roomService.changeStatusRoomByFloorId(status, id);
            return floorRepository.save(floor);
        } catch (Exception e) {
            System.out.println(e.getCause());

            return null;
        }
    }


    @Override
    public Integer changeStatusByAreaIdAndStatus(Integer status, Integer areaId) {

        if (status != Floor.FLOOR_STATUS_ENABLE) {
            status = Floor.FLOOR_STATUS_DISABLE;
        }

        Integer check = 0;
        List<Floor> floorList = floorRepository.getFloorsByAreaId(areaId);

        for(Floor floor : floorList) {
            floor.setStatus(status);
            if (floorRepository.save(floor) != null){
                check++;
            }
        }
        return check;
    }
}
