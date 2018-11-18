package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.*;
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
@RequestMapping(RoomController.BASE_URL)
public class RoomController {

    public final static String BASE_URL   = "/api/room";

    @Autowired
    private RoomService roomService;

    @Autowired
    private FloorService floorService;

    @Autowired
    private AreaService areaService;

    private JsonResponse jsonResponse;

    @GetMapping("/floor/{floor_id}")
    public JsonResponse findRoomsByFloorId( @PathVariable(value = "floor_id") Integer floorId ) {
        try {
            Floor floor = floorService.findOneById(floorId);
            if (floor == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND,"Không có tầng nào có id = " + floorId, null);
                LogError.log(API.CODE_API_NOTFOUND,  "find room by floor" ,LogError.FAIL, "");

            } else {
                List<ViewRoom> rooms = roomService.findRoomsByFloorId(floorId);
                if (rooms.size() > 0) {
                    jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "", rooms);
                    LogError.log(API.CODE_API_YES,  "find room by floor" ,LogError.SUCCESS, "total: " + rooms.size());

                } else {
                    jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có phòng nào!", null);
                    LogError.log(API.CODE_API_NOTFOUND,  "find room by floor" ,LogError.FAIL, "");

                }
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find room by floor" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @GetMapping("/area/{id}")
    public JsonResponse findRoomsByAreaId(@PathVariable(value = "id") Integer id) {
        try{
            Area area = areaService.findAreaById(id);
            if (area == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có nha nào có id = " + id, null);
                LogError.log(API.CODE_API_NOTFOUND,  "find room by area id" ,LogError.FAIL, "");

                return jsonResponse;
            } else {
                List<ViewRoom> rooms = roomService.findRoomsByAreaId(id);


                if (rooms.size() > 0) {
                    jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "Danh sach phong!", rooms);
                    LogError.log(API.CODE_API_YES,  "find room by area id" ,LogError.SUCCESS, "total: " + rooms.size());

                    return jsonResponse;
                } else {
                    jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "Không có phòng nào!", null);
                    LogError.log(API.CODE_API_NOTFOUND,  "find room by area id" ,LogError.FAIL, "");

                    return jsonResponse;
                }
            }
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find room by area id" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @GetMapping("/{id}")
    public JsonResponse findOneById( @PathVariable(value = "id") Integer id) {
        try{
            ViewRoom room = roomService.findRoomById(id);
            if (room != null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", room);
                LogError.log(API.CODE_API_YES,  "find room by id" ,LogError.SUCCESS, room.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find room by id" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find room by id" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PutMapping("/edit/{id}")
    public JsonResponse editOne(@Valid @RequestBody Room room, @PathVariable(value = "id") Integer id) {
        try{
            Room room1 = roomService.editOne(id, room);
            if (room1 != null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", room1);
                LogError.log(API.CODE_API_YES,  "edit one room" ,LogError.SUCCESS, room1.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "edit one room" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "edit one room" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PutMapping("/add-one")
    public JsonResponse findRoomsByAreaId(@Valid @RequestBody Room room) {
        try{
            Room room1 = roomService.addOne(room);
            if (room1 != null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", room1);
                LogError.log(API.CODE_API_YES,  "add one room" ,LogError.SUCCESS, room1.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "add one room" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "add one room" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PutMapping("/add-list")
    public JsonResponse findRoomsByAreaId(@Valid @RequestBody String jsonString) {
        try{
            int check = 0;
            ObjectMapper mapper = new ObjectMapper();

            List<Room> roomList = mapper.readValue(jsonString, new TypeReference<List<Room>>(){});

            for(Room room : roomList) {
                if (roomService.addOne(room) != null)
                    check++;
            }

            if (check == roomList.size() ){
                jsonResponse = return_List_Object_JsonPresonse_Room(API.CODE_API_YES, "success", roomList);
                LogError.log(API.CODE_API_YES,  "add list room" ,LogError.SUCCESS, "total: " + roomList.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "add list room" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "add list room" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PutMapping("/change-status-list/{status}")
    public JsonResponse changeStatusList(@Valid @RequestBody String jsonString, @PathVariable(value = "status") Integer status) {
        try{
            int check = 0;
            ObjectMapper mapper = new ObjectMapper();

            List<Room> roomList = mapper.readValue(jsonString, new TypeReference<List<Room>>(){});


            for(Room room : roomList) {
                if (roomService.changeStatus(room.getId(), status) != null)
                    check++;
            }

            if (check == roomList.size() ){
                jsonResponse = return_List_Object_JsonPresonse_Room(API.CODE_API_YES, "success", roomList);
                LogError.log(API.CODE_API_YES,  "change status list room" ,LogError.SUCCESS, "total: " + roomList.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "change status list room" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "change status list room" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @GetMapping("/change-status-one/{id}/{status}")
    public JsonResponse changeStatusOne(@PathVariable(value = "id") Integer id, @PathVariable(value = "status") Integer status) {
        try{

            Room room = roomService.changeStatus(id, status);

            if (room != null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", room);
                LogError.log(API.CODE_API_YES,  "change status one room" ,LogError.SUCCESS, room.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
                LogError.log(API.CODE_API_NO,  "change status one room" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "change status onr room" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, Object room){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(room));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<ViewRoom> rooms){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(rooms));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse_Room(Integer code, String message, List<Room> rooms){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(rooms));

        return jsonResponse;
    }
}
