package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.TimeRegister;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.LogError;
import com.example.dorm_management.services.TimeRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = TimeRegisterController.BASE_URL)
public class TimeRegisterController {

    public final static String BASE_URL = "/api/time_register";

    @Autowired
    private TimeRegisterService timeRegisterService;

    private JsonResponse jsonResponse;

    @GetMapping
    public JsonResponse findAll() {
        List<TimeRegister> timeRegisterList = timeRegisterService.findAll();

        if (timeRegisterList.isEmpty()) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
            LogError.log(API.CODE_API_NOTFOUND,  "find all time register" ,LogError.ERROR_EXCEPTION, "");
        } else {
            jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", timeRegisterList);

            LogError.log(API.CODE_API_YES,  "find all time register" ,LogError.SUCCESS, "total: " + timeRegisterList.size());
        }

        return jsonResponse;
    }

    @GetMapping("/{id}")
    public JsonResponse findOneById(@PathVariable(value = "id") Integer id) {
        try {
            TimeRegister timeRegister = timeRegisterService.findOneById(id);

            if (timeRegister == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find one time register" ,LogError.NOT_FOUND, "");
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", timeRegister);
                LogError.log(API.CODE_API_YES,  "find one time register" ,LogError.SUCCESS, "begin: " + timeRegister.getDateBegin());
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find one time register" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @PostMapping("/add")
    public JsonResponse addOne(@Valid @RequestBody TimeRegister timeRegister) {
        try {
            TimeRegister timeRegisterAdd = timeRegisterService.addOne(timeRegister);

            if (timeRegisterAdd == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "add one time register" ,LogError.NOT_FOUND, "");
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", timeRegisterAdd);
                LogError.log(API.CODE_API_YES,  "add one time register" ,LogError.SUCCESS, "begin: " + timeRegisterAdd.getDateBegin());
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "add one time register" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @PutMapping("/edit/{id}")
    public JsonResponse editOne(@Valid @RequestBody TimeRegister timeRegister, @PathVariable(value = "id") Integer id) {
        try {
            TimeRegister timeRegisterAdd = timeRegisterService.editOne(id, timeRegister);

            if (timeRegisterAdd == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "edit one time register" ,LogError.NOT_FOUND, "");
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", timeRegisterAdd);
                LogError.log(API.CODE_API_YES,  "edit one time register" ,LogError.SUCCESS, "begin: " + timeRegisterAdd.getDateBegin());
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return jsonResponse;
        }
    }

    @GetMapping("/current")
    public JsonResponse findOneByCurrent() {
        try {
            Date date = new Date();
            Timestamp time=new Timestamp(date.getTime());
            TimeRegister timeRegister = timeRegisterService.findOneCurrentTime(time);

            if (timeRegister == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find one time register current" ,LogError.NOT_FOUND, "");
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", timeRegister);
                LogError.log(API.CODE_API_YES,  "find one time register current" ,LogError.SUCCESS, "begin: " + timeRegister.getDateBegin());
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find one time register current" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @GetMapping("/change_status/{id}/{status}")
    public JsonResponse changeStatus(@PathVariable(value = "id") Integer id, @PathVariable(value = "status") Integer status) {
        try {
            TimeRegister timeRegister = timeRegisterService.changeStautusOne(id, status);

            if (timeRegister == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "change one time register current" ,LogError.NOT_FOUND, "");
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", timeRegister);
                LogError.log(API.CODE_API_YES,  "change one time register current" ,LogError.SUCCESS, "begin: " + timeRegister.getDateBegin());
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "change one time register current" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }


    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, TimeRegister timeRegister){
        jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(timeRegister));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<TimeRegister> timeRegisterList){
        jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(timeRegisterList));

        return jsonResponse;
    }

}