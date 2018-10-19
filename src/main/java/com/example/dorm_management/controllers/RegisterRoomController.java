package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.RegisterRoom;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.RegisterRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(RegisterRoomController.BASE_URL)
public class RegisterRoomController {

    public final static String BASE_URL = "/api/register";

    @Autowired
    private RegisterRoomService registerRoomService;

    private JsonResponse jsonResponse;

    @GetMapping("/room/{id}")
    public JsonResponse findOneByRoomId(@PathVariable(value = "id") Integer id) {
        try {

            List<RegisterRoom> registerRooms = registerRoomService.findAllByRoomId(id);

            jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", registerRooms);
            return  jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return jsonResponse;
        }
    }

    @PutMapping("/add")
    public JsonResponse addOne(@Valid @RequestBody RegisterRoom registerRoom){
        try {

            registerRoom.setStatus(0);
            RegisterRoom registerRoom1 = registerRoomService.addOne(registerRoom);
            if (registerRoom1 == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error add", null);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", registerRoom1);
            }

            return jsonResponse;
        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return jsonResponse;
        }
    }

    public JsonResponse return_No_Object_JsonPresonse(Integer code, String message){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(null);

        return jsonResponse;
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, RegisterRoom registerRoom){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(registerRoom));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<RegisterRoom> registerRoomList){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(registerRoomList));

        return jsonResponse;
    }
}
