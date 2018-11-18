package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.RegisterRoom;
import com.example.dorm_management.entities.RentRoom;
import com.example.dorm_management.entities.Room;
import com.example.dorm_management.entities.User;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.LogError;
import com.example.dorm_management.services.RentRoomService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class RentRoomController {

    public final static String BASE_URL = "/api/rent-room";

    @Autowired
    private RentRoomService rentRoomService;

    private JsonResponse jsonResponse;

    @PutMapping("/disable")
    public JsonResponse disableOne(@RequestBody String jsonString) {
        try {
            int check = 0;
            ObjectMapper mapper = new ObjectMapper();

            List<RentRoom> rentRoomList = mapper.readValue(jsonString, new TypeReference<List<RentRoom>>(){});

            for (RentRoom rentRoom: rentRoomList) {
                if (rentRoomService.changeStatus(rentRoom, RentRoom.RENT_ROOM_STATUS_DISABLE) != true) {
                    check++;
                }
            }

            if (check == rentRoomList.size()) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", rentRoomList);
                LogError.log(API.CODE_API_YES,  "disable rent room" ,LogError.SUCCESS, "total: " + rentRoomList.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "disable rent room" ,LogError.FAIL, "");
            }

            return jsonResponse;

        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "disable rent room" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }


    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, RentRoom rentRoom){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(rentRoom));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<RentRoom> rentRoomList){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(rentRoomList));

        return jsonResponse;
    }
}
