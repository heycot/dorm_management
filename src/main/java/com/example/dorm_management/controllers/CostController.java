package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Cost;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.LogError;
import com.example.dorm_management.services.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(CostController.BASE_URL)
public class CostController {

    public final static String BASE_URL = "/api/cost";

    @Autowired
    private CostService costService;

    private JsonResponse jsonResponse;

    @GetMapping
    public JsonResponse findAllCost(){
        try {
            List<Cost> costList = costService.findAll();

            if (costList.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", costList);
                LogError.log(API.CODE_API_YES,  "find add cost" ,LogError.SUCCESS, "total: " + costList.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find all cost" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            LogError.log(API.CODE_API_ERROR,  "find all cost" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }

    }

    @GetMapping("/{id}")
    public JsonResponse findOneById(@PathVariable(value = "id") Integer id){
        try {
            Cost cost = costService.findOneById(id);

            if (cost != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", cost);
                LogError.log(API.CODE_API_NOTFOUND,  "find one cost by id" ,LogError.SUCCESS, cost.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find one cost by id" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            LogError.log(API.CODE_API_NOTFOUND,  "find one cost by id" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }

    }

    @GetMapping("/{type}/{level}/{status}")
    public JsonResponse findOneByTypeLevelAndStatus(@PathVariable(value = "type") Integer type, @PathVariable(value = "level") Integer level,
                                                    @PathVariable(value = "status") Integer status){
        try {
            Cost cost = costService.findOneByTypeLevelAndStatus(type, level, status);

            if (cost != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", cost);
                LogError.log(API.CODE_API_YES,  "get one cost by type, level and status" ,LogError.SUCCESS, cost.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find one cost by type, level and status" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find one cost by type, level and status" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }

    }

    @GetMapping("/type-cost/{type}")
    public JsonResponse findAllByType(@PathVariable(value = "type") Integer type){
        try {
            List<Cost> costList = costService.findAllByType(type);

            if (costList.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", costList);
                LogError.log(API.CODE_API_YES,  "find cost by type" ,LogError.SUCCESS, "total: " + costList.size());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NOTFOUND,  "find cost by type" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "find cost by type" ,LogError.FAIL, "");

            return jsonResponse;
        }

    }

    @PutMapping("/add")
    public JsonResponse addOne(@Valid @RequestBody Cost costAdd){
        try {
            Cost cost = costService.addOne(costAdd);

            if (cost != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", cost);
                LogError.log(API.CODE_API_YES,  "add new cost" ,LogError.SUCCESS, cost.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NO,  "add new cost" ,LogError.FAIL, "");
            }

                return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "add new cost" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PostMapping("/edit/{id}")
    public JsonResponse editOne(@Valid @RequestBody Cost costEdit, @PathVariable(value = "id") Integer id){
        try {
            Cost cost = costService.editOne(costEdit, id);

            if (cost != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", cost);
                LogError.log(API.CODE_API_YES,  "edit one cost" ,LogError.SUCCESS, cost.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NO,  "edit one cost" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "edit one cost" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    @PostMapping("/change-st/{id}/{status}")
    public JsonResponse changeStatus( @PathVariable(value = "id") Integer id, @PathVariable(value = "status") Integer status){
        try {
            if (status != 0) {
                status = 1;
            }

            Cost cost = costService.changeStatus(id, status);

            if (cost != null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", cost);
                LogError.log(API.CODE_API_YES,  "change status one cost" ,LogError.SUCCESS, cost.getName());
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
                LogError.log(API.CODE_API_NO,  "change status one cost" ,LogError.FAIL, "");
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            LogError.log(API.CODE_API_ERROR,  "change status one cost" ,LogError.ERROR_EXCEPTION, "");

            return jsonResponse;
        }
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, Cost cost){
        jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(cost));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<Cost> costList){
        jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(costList));

        return jsonResponse;
    }
}
