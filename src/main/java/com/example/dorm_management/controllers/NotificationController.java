package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(NotificationController.BASE_URL)
public class NotificationController {

    public final static String BASE_URL = "/api/notification";

    @Autowired
    private NotificationService notificationService;

    private JsonResponse jsonResponse;


    @GetMapping("/user/{id}")
    public JsonResponse findAllOfUser(@PathVariable(value = "id") Integer user_id) {
        try {

        } catch (Exception e){

        }

        return null;
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
