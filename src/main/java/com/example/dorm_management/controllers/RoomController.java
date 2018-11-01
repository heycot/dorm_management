package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.*;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
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

    @GetMapping("/floor/{area_id}/{floor_id}")
    public JsonResponse findRoomsByFloorId(@PathVariable(value = "area_id") Integer areaId, @PathVariable(value = "floor_id") Integer floorId ) {
        Floor floor = floorService.findOneById(floorId);
        if (floor == null) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND,"Không có tầng nào có id = " + floorId, null);

        } else {
            List<ViewRoom> rooms = roomService.findRoomsByFloorId(floorId, areaId);
            if (rooms.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "", rooms);

            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có phòng nào!", null);

            }
        }

        return jsonResponse;
    }

    @GetMapping("/area/{id}")
    public JsonResponse findRoomsByAreaId(@PathVariable(value = "id") Integer id) {
        Area area = areaService.findAreaById(id);
        if (area == null) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có nha nào có id = " + id, null);

            return jsonResponse;
        } else {
            List<ViewRoom> rooms = roomService.findRoomsByAreaId(id);


            if (rooms.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "Danh sach phong!", rooms);

                return jsonResponse;
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có phòng nào!", null);

                return jsonResponse;
            }
        }
    }

    @PutMapping("/edit/{id}")
    public JsonResponse editOne(@Valid @RequestBody Room room, @PathVariable(value = "id") Integer id) {
        try{
            Room room1 = roomService.editOne(id, room);
            if (room1 != null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", room1);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            return jsonResponse;
        }
    }

    @PutMapping("/add-one")
    public JsonResponse findRoomsByAreaId(@Valid @RequestBody Room room) {
        try{
            Room room1 = roomService.addOne(room);
            if (room1 != null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", room1);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

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
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            return jsonResponse;
        }
    }

    @PutMapping("/change-status-list/{status}")
    public JsonResponse changeStatusList(@Valid @RequestBody String jsonString, @PathVariable(value = "status") Integer status) {
        try{
            int check = 0;
            ObjectMapper mapper = new ObjectMapper();

            List<Room> roomList = mapper.readValue(jsonString, new TypeReference<List<Room>>(){});

            if (status != 0 ){
                status = 1;
            }
            for(Room room : roomList) {
                if (roomService.changeStatus(room.getId(), status) != null)
                    check++;
            }

            if (check == roomList.size() ){
                jsonResponse = return_List_Object_JsonPresonse_Room(API.CODE_API_YES, "success", roomList);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            return jsonResponse;
        }
    }

    @GetMapping("/change-status-one/{id}/{status}")
    public JsonResponse changeStatusOne(@PathVariable(value = "id") Integer id, @PathVariable(value = "status") Integer status) {
        try{

            if (status != 0 ){
                status = 1;
            }

            Room room = roomService.changeStatus(id, status);

            if (room != null ){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", room);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "fail", null);
            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

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
