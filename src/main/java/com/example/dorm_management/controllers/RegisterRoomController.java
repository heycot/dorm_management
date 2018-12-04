package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.*;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.LogError;
import com.example.dorm_management.libararies.Utility;
import com.example.dorm_management.services.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
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
    private RoomService roomService;

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

    @GetMapping("/floor/{id}")
    public JsonResponse findAllByFloorId(@PathVariable(value = "id") Integer id) {
        try {

            List<ViewRegisterRoom> registerRooms = registerRoomService.findAllByFloorId(id);

            if (registerRooms.size() > 0) {
                jsonResponse = return_List_Object_View_JsonPresonse(API.CODE_API_YES, "success", registerRooms);
                LogError.log(API.CODE_API_YES,  "find register by floor" ,LogError.SUCCESS, "total: " + registerRooms.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find register by floor" ,LogError.FAIL, "");
            }

            return  jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find register by floor" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @GetMapping("/area/{id}")
    public JsonResponse findAllByAreaId(@PathVariable(value = "id") Integer id) {
        try {

            List<ViewRegisterRoom> registerRoomList = registerRoomService.findAllByAreaId(id);

            if (registerRoomList.size() > 0) {
                jsonResponse = return_List_Object_View_JsonPresonse(API.CODE_API_YES, "success", registerRoomList);
                LogError.log(API.CODE_API_YES,  "find register by area" ,LogError.SUCCESS, "total: " + registerRoomList.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find register by area" ,LogError.FAIL, "");
            }

            return  jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find register by area" ,LogError.ERROR_EXCEPTION, "");

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

            registerRoom.setStatus(RegisterRoom.REGISTER_STATUS_DISABLE);
            RegisterRoom registerRoom1 = registerRoomService.addOne(registerRoom);
            if (registerRoom1 == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error add", null);
                LogError.log(API.CODE_API_NO,  "add one register" ,LogError.FAIL, "");
            } else {
                ViewRegisterRoom viewRegisterRoom = registerRoomService.getOneViewById(registerRoom1.getId());

                roomService.updateRegisterRoom(viewRegisterRoom.getRoomId());
                String content = "Bạn đã đăng ký thành công "
                        + "phòng: " + viewRegisterRoom.getRoomName() + "\n"
                        + " tầng: " + viewRegisterRoom.getFloorName() + "\n"
                        + " nhà: " + viewRegisterRoom.getAreaName() + "\n"
                        + "vào lúc: " + viewRegisterRoom.getTimeRegister();

                Notification notification = Notification.builder()
                        .userId(viewRegisterRoom.getUserId())
                        .status(Notification.NOTIFICATION_STATUS_NOT_READ)
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

            RegisterRoom registerRoom1 = registerRoomService.editOne(registerRoom, id);
            roomService.updateRegisterRoom(registerRoom1.getRoomId());
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

            int check = 0;
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ObjectMapper mapper = new ObjectMapper();
            List<Integer> idList = mapper.readValue(jsonString, new TypeReference<List<Integer>>() { });

            for (Integer id : idList) {
                if (registerRoomService.acceptOne(id) != null){

                    ViewRegisterRoom viewRegisterRoom = registerRoomService.getOneViewById(id);

                    String content = "Bạn đã được duyệt đăng ký: "
                            + viewRegisterRoom.getRoomName() + "\n"
                            + viewRegisterRoom.getFloorName() + "\n"
                            + viewRegisterRoom.getAreaName() + "\n"
                            + "vào lúc: " + viewRegisterRoom.getTimeCensor();

                    Notification notification = Notification.builder()
                            .userId(viewRegisterRoom.getUserId())
                            .status(Notification.NOTIFICATION_STATUS_NOT_READ)
                            .content(content)
                            .title("Bạn đã được duyệt phòng!")
                            .time(timestamp).build();

                    if (notificationService.addNotification(notification) == true)
                        check++;
                }
            }
            if (check != idList.size()) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error accept", null);
                LogError.log(API.CODE_API_NO,  "accept List register" ,LogError.FAIL, "");

            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", null);
                LogError.log(API.CODE_API_YES,  "accept list register" ,LogError.SUCCESS, "total: " + check);

            }

            return jsonResponse;
        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "accept list register" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @GetMapping("/del/{id}")
    public JsonResponse deleteOne(@PathVariable(value = "id") Integer id){
        try {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ViewRegisterRoom viewRegisterRoom = registerRoomService.deleteOne(id, false);

            if(viewRegisterRoom != null) {

                String content = "Bạn đã xóa đăng ký thành công: "
                        + viewRegisterRoom.getRoomName() + "\n"
                        + viewRegisterRoom.getFloorName() + "\n"
                        + viewRegisterRoom.getAreaName();

                Notification notification = Notification.builder()
                        .userId(viewRegisterRoom.getUserId())
                        .status(Notification.NOTIFICATION_STATUS_NOT_READ)
                        .content(content)
                        .title("Bạn đã được duyệt phòng!")
                        .time(timestamp).build();

                roomService.updateRegisterRoom(viewRegisterRoom.getRoomId());
                boolean check = notificationService.addNotification(notification);

                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success and sent notification", null);
                LogError.log(API.CODE_API_YES,  "delete register" ,LogError.SUCCESS, "");
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "phòng đã duyệt không được xóa", null);
                LogError.log(API.CODE_API_NO,  "delete list register" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "delete list register" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PutMapping(value = "rent-room")
    public JsonResponse rentRoom(@Valid @RequestBody String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            int check = 0;

            List<Integer> idList = mapper.readValue(jsonString, new TypeReference<List<Integer>>(){});
            Cost cost = costService.findOneByTypeAndStatus(Cost.COST_TYPE_ROOM, Cost.COST_STATUS_ENABLE);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            for (Integer id: idList ) {
                ViewRegisterRoom viewRegisterRoom = registerRoomService.deleteOne(id, true);
                if (viewRegisterRoom != null) {

                    RentRoom rentRoom = RentRoom.builder()
                            .semesterId(viewRegisterRoom.getSemesterId())
                            .userId(viewRegisterRoom.getUserId())
                            .roomId(viewRegisterRoom.getRoomId())
                            .year(viewRegisterRoom.getYear())
                            .status(RentRoom.RENT_ROOM_STATUS_ENABLE)
                            .bail(viewRegisterRoom.getNumber() * cost.getValue()).build();

                    rentRoomService.addOne(rentRoom);

                    String content = "Bạn đã thanh toán tiền phòng thành công: "
                            + viewRegisterRoom.getRoomName() + "\n"
                            + viewRegisterRoom.getFloorName() + "\n"
                            + viewRegisterRoom.getAreaName() + "\n"
                            + "vào lúc: " + viewRegisterRoom.getTimeCensor();

                    Notification notification = Notification.builder()
                            .userId(viewRegisterRoom.getUserId())
                            .status(Notification.NOTIFICATION_STATUS_NOT_READ)
                            .content(content)
                            .title("Duyệt phòng thành công!")
                            .time(timestamp).build();

                    boolean b = notificationService.addNotification(notification);
                    check++;
                } else {
                    jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "chưa được duyệt nên k pay dc", null);
//                    LogError.log(API.CODE_API_NO,  "rent bail list" ,LogError.FAIL, "chưa được duyệt nên k pay dc");
                    return jsonResponse;
                }

                roomService.updateRegisterRoom(viewRegisterRoom.getRoomId());

                roomService.updatePresentRoom(viewRegisterRoom.getRoomId());
            }

            if (check == idList.size()) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", null);
                LogError.log(API.CODE_API_YES,  "rent bail list" ,LogError.SUCCESS, "total: " + idList.size());
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

    @GetMapping(value = "get-time-register")
    public JsonResponse getAllTimeRegister(){
        try{
            List<TimeRegister> timeRegisters = registerRoomService.findAllTimeRegister();
            return Utility.convertObjectToJSON(API.CODE_API_YES, "get time register success", timeRegisters);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_YES, "get time register fail");
        }
    }

    @GetMapping(value = "get-time-register/{id}")
    public JsonResponse getAllTimeRegisterById(@PathVariable(value = "id") Integer id){
        try{
            TimeRegister timeRegister = registerRoomService.findTimeRegisterById(id);
            return Utility.convertObjectToJSON(API.CODE_API_YES, "get time register success", timeRegister);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_YES, "get time register fail");
        }
    }

    @GetMapping(value = "get-time-register-by-semester/{id}")
    public JsonResponse getAllTimeRegisterBySemesterId(@PathVariable(value = "id") Integer id){
        try{
            List<TimeRegister> timeRegister = registerRoomService.findAllTimeRegisterBySemesterId(id);
            return Utility.convertObjectToJSON(API.CODE_API_YES, "get time register success", timeRegister);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_YES, "get time register fail");
        }
    }

    @PostMapping(value = "add-time-register")
    public JsonResponse addTimeRegister(@RequestBody TimeRegister timeRegister){
        try{
            boolean b = registerRoomService.addTimeRegister(timeRegister);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "add time reigster success", timeRegister);
            }
            return Utility.convertObjectToJSON(API.CODE_API_YES, "add time register fail", timeRegister);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_YES, "add time register fail");
        }
    }

    @GetMapping(value = "delete-time-register")
    public JsonResponse deleteTimeRegister(@PathVariable(value = "id") Integer id){
        try{
            boolean b = registerRoomService.deleteTimeRegisterById(id);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "delete time register success");
            }
            return Utility.convertObjectToJSON(API.CODE_API_YES, "delete time register fail");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_YES, "delete time register fail");
        }
    }

    @GetMapping(value = "delete-time-register-by-semester")
    public JsonResponse deleteTimeRegisterBySemesterId(@PathVariable(value = "id") Integer id){
        try{
            boolean b = registerRoomService.deleteTimeRegisterBySemesterId(id);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "delete time register success");
            }
            return Utility.convertObjectToJSON(API.CODE_API_YES, "delete time register fail");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_YES, "delete time register fail");
        }
    }

    @GetMapping(value = "change-status-semester/{id}")
    public JsonResponse changeStatusSemester(@PathVariable(value = "id") Integer id){
        try{
            boolean b = registerRoomService.changeStatusById(id);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "change status time register success");
            }
            return Utility.convertObjectToJSON(API.CODE_API_YES, "change status time register fail");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_YES, "change status time register fail");
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
