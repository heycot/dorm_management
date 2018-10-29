package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Notification;
import com.example.dorm_management.entities.RentRoom;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.NotificationService;
import com.example.dorm_management.services.RentRoomService;
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

    @Autowired
    private RentRoomService rentRoomService;

    private JsonResponse jsonResponse;


    @GetMapping("/user/{id}")
    public JsonResponse findAllOfUser(@PathVariable(value = "id") Integer user_id) {
        try {

            RentRoom rentRoom = rentRoomService.findOneByUserId(user_id, 1);

//            List<Notification> notificationList = notificationService.findAllOfUser(user_id, rentRoom.getRoomId());


            List<Notification> notificationList = notificationService.findAllOfUser(user_id, 1);

            if (notificationList.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", notificationList);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
            }

            return jsonResponse;

        } catch (Exception e){
            System.out.println(e.getCause());

            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            return jsonResponse;
        }

    }

    @GetMapping("user/read/{id}")
    public JsonResponse readOne(@PathVariable(value = "id") Integer id) {
        try {

            Notification notification = notificationService.readOne(id, 1);
            if (notification ==  null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
            } else {

                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", notification);
            }

            return  jsonResponse;

        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return  jsonResponse;
        }
    }


    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, Notification notification){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(notification));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<Notification> notificationList){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(notificationList));

        return jsonResponse;
    }
}
