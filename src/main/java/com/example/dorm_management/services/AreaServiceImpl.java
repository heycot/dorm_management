package com.example.dorm_management.services;

import com.example.dorm_management.entities.Area;
import com.example.dorm_management.respositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

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
}
