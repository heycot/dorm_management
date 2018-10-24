package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Room;
import com.example.dorm_management.entities.RoomFunction;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.RoomFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(RoomFunctionController.BASE_URL)
public class RoomFunctionController {

    public final static String BASE_URL   = "/api/room/function";

    @Autowired
    private RoomFunctionService roomFunctionService;

    private JsonResponse jsonResponse;

    @GetMapping
    public JsonResponse findAllRoomFunction(){
        try {
            List<RoomFunction> roomFunctions = roomFunctionService.getAllRoomFunction();
            if (roomFunctions.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "", roomFunctions);
                return jsonResponse;
            } else{
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found");
                return jsonResponse;
            }
        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_ERROR, "error");
            return  jsonResponse;
        }
    }

    public JsonResponse return_No_Object_JsonPresonse(Integer code, String message){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(null);

        return jsonResponse;
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, RoomFunction room){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(room));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<RoomFunction> rooms){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(rooms));

        return jsonResponse;
    }
}
