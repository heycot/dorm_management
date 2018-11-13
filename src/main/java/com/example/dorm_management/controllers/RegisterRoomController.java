package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.*;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.LogError;
import com.example.dorm_management.services.CostService;
import com.example.dorm_management.services.NotificationService;
import com.example.dorm_management.services.RegisterRoomService;
import com.example.dorm_management.services.RentRoomService;
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

    @Autowired
    private CostService costService;

    @Autowired
    private RentRoomService rentRoomService;

    @Autowired
    private NotificationService notificationService;

    private JsonResponse jsonResponse;

    @GetMapping("/room/{id}")
    public JsonResponse findAllByRoomId(@PathVariable(value = "id") Integer id) {
        try {

            List<ViewRegisterRoom> registerRooms = registerRoomService.findAllByRoomId(id);

            if (registerRooms.size() > 0) {
                jsonResponse = return_List_Object_View_JsonPresonse(API.CODE_API_YES, "success", registerRooms);
                LogError.log(API.CODE_API_YES,  "find register by room" ,LogError.SUCCESS, "total: " + registerRooms.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find register by room" ,LogError.FAIL, "");
            }

            return  jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find register by room" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @GetMapping("/room-accepted/{id}")
    public JsonResponse findAllAcceptedByRoomId(@PathVariable(value = "id") Integer id) {
        try {

            List<ViewRegisterRoom> registerRooms = registerRoomService.findAllAcceptedByRoomId(id);

            if (registerRooms.size() > 0) {
                jsonResponse = return_List_Object_View_JsonPresonse(API.CODE_API_YES, "success", registerRooms);
                LogError.log(API.CODE_API_YES,  "room accepted" ,LogError.SUCCESS, "total: " + registerRooms.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NO,  "room accepted" ,LogError.FAIL, "");
            }

            return  jsonResponse;

        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "room accepted" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @GetMapping("/room-not-accepted/{id}")
    public JsonResponse findAllNotAcceptedByRoomId(@PathVariable(value = "id") Integer id) {
        try {

            List<ViewRegisterRoom> registerRooms = registerRoomService.findAllNotAcceptedByRoomId(id);

            if (registerRooms.size() > 0) {
                jsonResponse = return_List_Object_View_JsonPresonse(API.CODE_API_YES, "success", registerRooms);
                LogError.log(API.CODE_API_YES,  "room not accept register" ,LogError.SUCCESS, "total: " + registerRooms.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);

                LogError.log(API.CODE_API_NO,  "room not accept register" ,LogError.FAIL, "");
            }

            return  jsonResponse;

        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR , "find all register not accept by roomId" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PutMapping("/add")
    public JsonResponse addOne(@Valid @RequestBody RegisterRoom registerRoom){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            registerRoom.setStatus(0);
            RegisterRoom registerRoom1 = registerRoomService.addOne(registerRoom);
            if (registerRoom1 == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error add", null);
                LogError.log(API.CODE_API_NO,  "add one register" ,LogError.FAIL, "");
            } else {

                ViewRegisterRoom viewRegisterRoom = registerRoomService.getOneViewById(registerRoom1.getId());

                String content = "Bạn đã đăng ký thành công "
                        + "phòng: " + viewRegisterRoom.getRoomName() + "\n"
                        + " tầng: " + viewRegisterRoom.getFloorName() + "\n"
                        + " nhà: " + viewRegisterRoom.getAreaName() + "\n"
                        + "vào lúc: " + viewRegisterRoom.getTimeRegister();

                Notification notification = Notification.builder()
                        .userId(viewRegisterRoom.getUserId())
                        .status(0)
                        .content(content)
                        .title("Đăng ký phòng thành công!")
                        .time(timestamp).build();


                if (notificationService.addNotification(notification) == true) {

                    jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success and sent notification ", registerRoom1);
                    LogError.log(API.CODE_API_YES,  "add one register" ,LogError.SUCCESS, registerRoom1.getId().toString());
                } else {

                    jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success and not send notification ", registerRoom1);
                    LogError.log(API.CODE_API_NO,  "add one register" ,LogError.FAIL, "");
                }
            }

            return jsonResponse;
        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "add one register" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @PutMapping("/edit/{id}")
    public JsonResponse editOne(@Valid @RequestBody RegisterRoom registerRoom, @PathVariable(value = "id") Integer id){
        try {

            RegisterRoom registerRoom1 = registerRoomService.edditOne(registerRoom, id);
            if (registerRoom1 == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error add", null);
                LogError.log(API.CODE_API_NO,  "edit one register" ,LogError.FAIL, "");
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", registerRoom1);
                LogError.log(API.CODE_API_YES,  "edit one register" ,LogError.SUCCESS, registerRoom1.getId().toString());
            }

            return jsonResponse;
        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "edit one register" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @PutMapping("/accept")
    public JsonResponse accept(@Valid @RequestBody String jsonString){
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            ObjectMapper mapper = new ObjectMapper();
            List<RegisterRoom> registerRoomList = mapper.readValue(jsonString, new TypeReference<List<RegisterRoom>>(){});

            int check = 0;

            for (RegisterRoom x : registerRoomList) {
                System.out.println(x);
                x.setStatus(1);
                x.setTimeCensor(timestamp);
                if (registerRoomService.acceptOne(x) != null){

                    ViewRegisterRoom viewRegisterRoom = registerRoomService.getOneViewById(x.getId());

                    String content = "Bạn đã được duyệt đăng ký: "
                            + "phòng: " + viewRegisterRoom.getRoomName() + "\n"
                            + " tầng: " + viewRegisterRoom.getFloorName() + "\n"
                            + " nhà: " + viewRegisterRoom.getAreaName() + "\n"
                            + "vào lúc: " + viewRegisterRoom.getTimeCensor();

                    Notification notification = Notification.builder()
                            .userId(viewRegisterRoom.getUserId())
                            .status(0)
                            .content(content)
                            .title("Bạn đã được duyệt phòng!")
                            .time(timestamp).build();

                    if (notificationService.addNotification(notification) == true)
                        check++;
                }
            }
            if (check != registerRoomList.size()) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error accept", null);
                LogError.log(API.CODE_API_NO,  "accept List register" ,LogError.FAIL, "");
            } else {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", registerRoomList);
                LogError.log(API.CODE_API_YES,  "accept list register" ,LogError.SUCCESS, "total: " + registerRoomList.size());
            }

            return jsonResponse;
        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "accept list register" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PutMapping(value = "rent-room")
    public JsonResponse rentRoom(@Valid @RequestBody String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            int check = 0;

            List<RegisterRoom> registerRoomList = mapper.readValue(jsonString, new TypeReference<List<RegisterRoom>>(){});
            Cost cost = costService.findOneByTypeAndStatus(1, 1);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            for (RegisterRoom register: registerRoomList ) {
                if (registerRoomService.deleteOne(register.getId()) != true) {

                    RentRoom rentRoom = RentRoom.builder()
                            .semesterId(register.getSemesterId())
                            .userId(register.getUserId())
                            .roomId(register.getRoomId())
                            .year(register.getYear())
                            .status(1)
                            .bail(register.getNumber() * cost.getValue()).build();

//                    rentRoom.setSemesterId(register.getSemesterId());
//                    rentRoom.setUserId(register.getUserId());
//                    rentRoom.setRoomId(register.getRoomId());
//                    rentRoom.setYear(register.getYear());
//                    rentRoom.setStatus(1);
//                    rentRoom.setBail(register.getNumber() * cost.getValue());

                    rentRoomService.addOne(rentRoom);

                    ViewRegisterRoom viewRegisterRoom = registerRoomService.getOneViewById(register.getId());

                    String content = "Bạn đã thanh toán tiền phòng thành công: "
                            + "phòng: " + viewRegisterRoom.getRoomName() + "\n"
                            + " tầng: " + viewRegisterRoom.getFloorName() + "\n"
                            + " nhà: " + viewRegisterRoom.getAreaName() + "\n"
                            + "vào lúc: " + viewRegisterRoom.getTimeCensor();

                    Notification notification = Notification.builder()
                            .userId(viewRegisterRoom.getUserId())
                            .status(0)
                            .content(content)
                            .title("Duyệt phòng thành công!")
                            .time(timestamp).build();

//                    notification.setUserId(viewRegisterRoom.getUserId());
//                    notification.setStatus(0);
//
//                    notification.setContent(content);
//                    notification.setTitle("Duyệt phòng thành công!");
//                    notification.setTime(timestamp);

                    if (notificationService.addNotification(notification) == true)
                        check++;
                    check++;
                }
            }

            if (check == registerRoomList.size()) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", registerRoomList);
                LogError.log(API.CODE_API_YES,  "rent bail list" ,LogError.SUCCESS, "total: " + registerRoomList.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "rent bail list" ,LogError.FAIL, "");
            }

            return jsonResponse;

        } catch (Exception e){
            System.out.println(e.getCause());

            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "rent bail list" ,LogError.ERROR_EXCEPTION, "");
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

    public JsonResponse return_List_Object_View_JsonPresonse(Integer code, String message, List<ViewRegisterRoom> registerRoomList){
        jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(registerRoomList));

        return jsonResponse;
    }

}
