package com.example.dorm_management.services;

import com.example.dorm_management.entities.Area;

import java.util.List;

public interface AreaService {

    List<Area> findAllAreas();

    Area findAreaById(Integer id);

    Area addNewArea(Area areaEntity);

    boolean editArea(Area areaEntity, Area areaEntityEdit);
}
