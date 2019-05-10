package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Room;
import com.example.dorm_management.entities.RoomFunction;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.LogError;
import com.example.dorm_management.services.RoomFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                LogError.log(API.CODE_API_YES,  "find all room function" ,LogError.SUCCESS, "total: " + roomFunctions.size());
                return jsonResponse;
            } else{
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found");
                LogError.log(API.CODE_API_NO,  "find all room function" ,LogError.FAIL, "");
                return jsonResponse;
            }
        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_ERROR, "error");
            LogError.log(API.CODE_API_ERROR,  "find all room function" ,LogError.ERROR_EXCEPTION, "");
            return  jsonResponse;
        }
    }

    @GetMapping("{type}/{status}")
    public JsonResponse findOneByType(@PathVariable(value = "type") Integer type, @PathVariable(value = "status") Integer status){
        try {
            RoomFunction roomFunction = roomFunctionService.findOneByTypeAndStatus(type, status);

            if (roomFunction != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", roomFunction);
                LogError.log(API.CODE_API_YES,  "find one room function by type and status" ,LogError.SUCCESS, roomFunction.getName());
            } else{
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found");

                LogError.log(API.CODE_API_NO,  "find one room function by type and status" ,LogError.FAIL, "");
            }
            return jsonResponse;

        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_ERROR, "error");
            LogError.log(API.CODE_API_ERROR,  "find one room function by type and status" ,LogError.ERROR_EXCEPTION, "");
            return  jsonResponse;
        }
    }

    @PutMapping("add")
    public JsonResponse addOne(@RequestBody RoomFunction roomFunction){
        try {
            RoomFunction result = roomFunctionService.addOne(roomFunction);

            if (result != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", result);
                LogError.log(API.CODE_API_YES,  "add one room function" ,LogError.SUCCESS, result.getName());
            } else{
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found");
                LogError.log(API.CODE_API_NO,  "add one room function" ,LogError.FAIL, "");
            }
            return jsonResponse;

        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_ERROR, "error");
            LogError.log(API.CODE_API_ERROR,  "add one room function" ,LogError.ERROR_EXCEPTION, "");
            return  jsonResponse;
        }
    }

    @PutMapping("edit/{id}")
    public JsonResponse addOne(@RequestBody RoomFunction roomFunction, @PathVariable(value = "id") Integer id){
        try {
            RoomFunction result = roomFunctionService.editOne(id, roomFunction);

            if (result != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", result);
                LogError.log(API.CODE_API_YES,  "edit one room function" ,LogError.SUCCESS, result.getName());
            } else{
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found");
                LogError.log(API.CODE_API_NO,  "edit one room function" ,LogError.FAIL, "");
            }
            return jsonResponse;

        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_ERROR, "error");
            LogError.log(API.CODE_API_ERROR,  "edit one room function" ,LogError.ERROR_EXCEPTION, "");
            return  jsonResponse;
        }
    }

    @GetMapping("change-status/{id}/{status}")
    public JsonResponse addOne(@PathVariable(value = "status") Integer status, @PathVariable(value = "id") Integer id){
        try {

            RoomFunction result = roomFunctionService.changeStatus(id, status);

            if (result != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", result);
                LogError.log(API.CODE_API_YES,  "change status one room function" ,LogError.SUCCESS, result.getName());
            } else{
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found");
                LogError.log(API.CODE_API_NO,  "change status one room function" ,LogError.FAIL, "");
            }
            return jsonResponse;

        } catch (Exception e){
            System.out.println(e.getCause());
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_ERROR, "error");
            LogError.log(API.CODE_API_ERROR,  "change status one room function" ,LogError.ERROR_EXCEPTION, "");
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
