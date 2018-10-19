package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Cost;
import com.example.dorm_management.entities.SubsistenceFee;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.CostService;
import com.example.dorm_management.services.SubsistenceFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(SubsistenceFeeController.BASE_URL)
public class SubsistenceFeeController {

    public final static String BASE_URL = "/api/subsistence";

    @Autowired
    private SubsistenceFeeService subsistenceFeeService;

    @Autowired
    private CostService costService;

    private JsonResponse jsonResponse;

    @GetMapping("/room/{id}")
    public JsonResponse findOneByRoomId(@PathVariable(value = "id") Integer roomId) {
        try {
            List<SubsistenceFee> subsistenceFeeList = subsistenceFeeService.findALlByRoomId(roomId);

            if (subsistenceFeeList.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", subsistenceFeeList);

            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return jsonResponse;
        }
    }

    @PutMapping("/add")
    public JsonResponse addOne(@Valid @RequestBody SubsistenceFee subsistenceFee){
        try {
            if (subsistenceFee.getNewNumber() - subsistenceFee.getOldNumber() >= 100) {
                subsistenceFee.setLevel(2);
            } else {
                subsistenceFee.setLevel(1);
            }

            Cost cost = costService.findOneByTypeAndLevel(subsistenceFee.getType(), subsistenceFee.getLevel(), 1);
            Float total = (subsistenceFee.getNewNumber() - subsistenceFee.getOldNumber()) * cost.getValue();

            subsistenceFee.setCostId(cost.getId());
            subsistenceFee.setTotal(total);
            subsistenceFee.setStatus(0);

            SubsistenceFee subsistenceFee1 = subsistenceFeeService.addOne(subsistenceFee);

            if (subsistenceFee1 == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error add", null);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", subsistenceFee1);
            }

            return jsonResponse;
        } catch (Exception e){
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return jsonResponse;
        }
    }

    @PutMapping("/edit/{id}")
    public JsonResponse editOne(@Valid @RequestBody SubsistenceFee subsistenceFee, @PathVariable(value = "id") Integer id){
        try {
            if (subsistenceFee.getNewNumber() - subsistenceFee.getOldNumber() >= 100) {
                subsistenceFee.setLevel(2);
            } else {
                subsistenceFee.setLevel(1);
            }

            Cost cost = costService.findOneByTypeAndLevel(subsistenceFee.getType(), subsistenceFee.getLevel(), 1);
            Float total = (subsistenceFee.getNewNumber() - subsistenceFee.getOldNumber()) * cost.getValue();

            subsistenceFee.setCostId(cost.getId());
            subsistenceFee.setTotal(total);

            SubsistenceFee subsistenceFeeEdit = subsistenceFeeService.editOne(subsistenceFee, id);
            if (subsistenceFeeEdit == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "error edit", null);
            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_EDIT_SUCCESS, "success", subsistenceFeeEdit);
            }

            return jsonResponse;
        } catch (Exception e){
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return jsonResponse;
        }
    }


    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, SubsistenceFee subsistenceFee){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(subsistenceFee));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<SubsistenceFee> subsistenceFeeList){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(subsistenceFeeList));

        return jsonResponse;
    }
}
