package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Area;
import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.AreaService;
import com.example.dorm_management.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(FloorController.BASE_URL)
public class FloorController {

    public final static String  BASE_URL = "/api/floor";


    @Autowired
    private FloorService floorService;

    @Autowired
    private AreaService areaService;

    private JsonResponse jsonResponse;

    @GetMapping("/{id}")
    public JsonResponse getFloorsByAreaId(@PathVariable(value = "id") Integer areaId) {
        /*Area area = areaService.findAreaById(areaId);
        if (area == null) {
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_ID_NOTFOUND,
                    "Không có khu nhà có id = " + areaId);

            return jsonResponse;
        } else {*/
            List<Floor> floors = floorService.findFloorsByAreaId(areaId);
            if ( floors.size() > 0) {

                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_NOTFOUND, "", floors);
                return  jsonResponse;
            }else {
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có tầng nào của nhà có id = " + areaId);
                return jsonResponse;
            }
//        }
    }

    public JsonResponse return_No_Object_JsonPresonse(Integer code, String message){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(null);

        return jsonResponse;
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, Floor floor){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(floor));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<Floor> floors){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(floors));

        return jsonResponse;
    }
}
