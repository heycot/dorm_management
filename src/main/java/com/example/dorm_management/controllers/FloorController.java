package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.entities.RentRoom;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.LogError;
import com.example.dorm_management.services.AreaService;
import com.example.dorm_management.services.FloorService;
import com.example.dorm_management.services.RoomService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(FloorController.BASE_URL)
public class FloorController {

    public final static String  BASE_URL = "/api/floor";


    @Autowired
    private FloorService floorService;


    private JsonResponse jsonResponse;

    @GetMapping("/{id}")
    public JsonResponse getFloorsByAreaId(@PathVariable(value = "id") Integer areaId) {
        try {
            List<Floor> floors = floorService.findFloorsByAreaId(areaId);
            if (floors.size() > 0) {

                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", floors);
                LogError.log(API.CODE_API_YES,  "find one by id" ,LogError.SUCCESS, "total: " + floors.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có tầng nào của nhà có id = " + areaId, null);

                LogError.log(API.CODE_API_NOTFOUND,  "find one by id" ,LogError.FAIL, "");
            }
            return jsonResponse;

        } catch (Exception e){
            System.out.println(e.getCause());

            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find one by id" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PutMapping("/add-one")
    public JsonResponse addOneFloor(@Valid @RequestBody Floor floor) {
        try {
            if (floorService.addOneFloor(floor) != null){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ADD_SUCCESS, "success", floor);
                LogError.log(API.CODE_API_YES,  "add one floor" ,LogError.SUCCESS, "");
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "add one floor" ,LogError.FAIL, "");
            }
            return jsonResponse;

        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "fail", null);
            LogError.log(API.CODE_API_ERROR,  "add one floor" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @PutMapping("/edit/{id}")
    public JsonResponse addOneFloor(@Valid @RequestBody Floor floor, @PathVariable(value = "id") Integer id) {
        try {
            if (floorService.editOne(id, floor) != null){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_EDIT_SUCCESS, "success", floor);
                LogError.log(API.CODE_API_YES,  "edit one floor" ,LogError.SUCCESS, floor.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "edit one floor" ,LogError.FAIL, "");
            }
            return jsonResponse;

        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "fail", null);
            LogError.log(API.CODE_API_ERROR,  "edit one floor" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @GetMapping("/change-status/{id}/{status}")
    public JsonResponse addOneFloor(@PathVariable(value = "id") Integer id, @PathVariable(value = "status") Integer status) {
        try {
            if (status != 0) {
                status = 1;
            }

            Floor floor = floorService.changeStatus(id, status);

            if ( floor != null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_EDIT_SUCCESS, "successful", floor);
                LogError.log(API.CODE_API_YES,  "change status one floor" ,LogError.SUCCESS, floor.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "change status one floor" ,LogError.FAIL, "");
            }

            return jsonResponse;

        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "fail", null);
            LogError.log(API.CODE_API_ERROR,  "change status one floor" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @PutMapping("/add-list")
    public JsonResponse addListFloor(@Valid @RequestBody String jsonString) {
        try {
            int check = 0;
            ObjectMapper mapper = new ObjectMapper();

            List<Floor> floorList = mapper.readValue(jsonString, new TypeReference<List<Floor>>(){});

            for (Floor floor : floorList ) {
                if (floorService.addOneFloor(floor) != null) {
                    check++;
                }
            }

            if (check == floorList.size()) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_ADD_SUCCESS, "success", floorList);
                LogError.log(API.CODE_API_YES,  "add list floor" ,LogError.SUCCESS, "total: " + floorList.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "add list floor" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "fail", null);
            LogError.log(API.CODE_API_ERROR,  "add list floor" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
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
