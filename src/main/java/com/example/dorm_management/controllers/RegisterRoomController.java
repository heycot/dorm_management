package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.RegisterRoom;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.RegisterRoomService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
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
    public JsonResponse findAllByRoomId(@PathVariable(value = "id") Integer id) {
        try {

            List<RegisterRoom> registerRooms = registerRoomService.findAllByRoomId(id);

            if (registerRooms.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", registerRooms);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
            }

            return  jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            return jsonResponse;
        }
    }

    @GetMapping("/room-accepted/{id}")
    public JsonResponse findAllAcceptedByRoomId(@PathVariable(value = "id") Integer id) {
        try {

            List<RegisterRoom> registerRooms = registerRoomService.findAllAcceptedByRoomId(id);

            if (registerRooms.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", registerRooms);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
            }

            return  jsonResponse;

        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            return jsonResponse;
        }
    }

    @GetMapping("/room-not-accepted/{id}")
    public JsonResponse findAllNotAcceptedByRoomId(@PathVariable(value = "id") Integer id) {
        try {

            List<RegisterRoom> registerRooms = registerRoomService.findAllNotAcceptedByRoomId(id);

            if (registerRooms.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", registerRooms);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
            }

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

    @PutMapping("/edit/{id}")
    public JsonResponse editOne(@Valid @RequestBody RegisterRoom registerRoom, @PathVariable(value = "id") Integer id){
        try {

            RegisterRoom registerRoom1 = registerRoomService.edditOne(registerRoom, id);
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

    @PutMapping("/accept")
    public JsonResponse accept(@Valid @RequestBody String jsonString){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            ObjectMapper mapper = new ObjectMapper();
            List<RegisterRoom> registerRoomList = mapper.readValue(jsonString, new TypeReference<List<RegisterRoom>>(){});

            int check = 0;

            for (RegisterRoom x : registerRoomList) {
                System.out.println(x);
                x.setStatus(0);
                x.setTimeCensor(timestamp);
                if (registerRoomService.acceptOne(x) != null){
                    check++;
                }
            }
            if (check != registerRoomList.size()) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error accept", null);
            } else {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", registerRoomList);
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
