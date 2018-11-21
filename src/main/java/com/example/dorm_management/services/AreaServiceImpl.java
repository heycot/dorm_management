package com.example.dorm_management.services;

import com.example.dorm_management.entities.Area;
import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.respositories.AreaRepository;
import com.example.dorm_management.respositories.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private FloorService floorService;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private RoomService roomService;

    @Override
    public List<Area> findAllAreas() {
        return areaRepository.findAll();
    }

    @Override
    public Area findAreaById(Integer id) {
        return areaRepository.findOne(id);
    }

    @Override
    public Area addNewArea(Area areaEntity) {
        try{
            return areaRepository.save(areaEntity);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }

    }

    @Override
    public boolean editArea(Area areaEntity, Area areaEntityEdit) {
        try{

            areaEntityEdit.setName(areaEntity.getName());
            areaEntityEdit.setNumberFloor(areaEntity.getNumberFloor());
            areaEntityEdit.setStatus(areaEntity.getStatus());

            areaRepository.save(areaEntityEdit);
            return  true;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }
    }

    @Override
    public Area changeStatus(Integer id, Integer status){
        try {

            if (status != Area.AREA_STATUS_ENABLE) {
                status =  Area.AREA_STATUS_DISABLE;
            }

            Area area = areaRepository.findOne(id);

            area.setStatus(status);

//            Integer statusFloor = floorService.changeStatusByAreaIdAndStatus(status, id);
            List<Floor> floors = floorService.findFloorsByAreaId(id);

            Integer check = 0;
            for (Floor f: floors ) {
                f.setStatus(status);
                floorRepository.save(f);
                check += roomService.changeStatusRoomByFloorId(status, id);
            }
            return areaRepository.save(area);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
