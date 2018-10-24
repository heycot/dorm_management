package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Cost;
import com.example.dorm_management.entities.Notification;
import com.example.dorm_management.entities.SubsistenceFee;
import com.example.dorm_management.entities.ViewSubsistence;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.CostService;
import com.example.dorm_management.services.NotificationService;
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
    private NotificationService notificationService;


    @Autowired
    private CostService costService;

    private JsonResponse jsonResponse;

    @GetMapping("/room/{id}")
    public JsonResponse findOneByRoomId(@PathVariable(value = "id") Integer roomId) {
        try {
            List<ViewSubsistence> subsistenceFeeList = subsistenceFeeService.findALlByRoomId(roomId);

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

                ViewSubsistence sb1 = subsistenceFeeService.findViewOneById()
                String content = "Phòng của bạn đã thanh toán hóa đơn điện nước thành công: \n"
                        + " tháng :" + sb1.getMonth() + " - " + sb1.getYear() + "\n"
                        + sb1.getNameCost() + " : \n"
                        + " Số cũ: " + sb1.getOldNumber() + " số mới: " + sb1.getNewNumber() + " = " + sb1.getTotal() + "\n"
                        + sb2.getNameCost() + " : \n"
                        + " Số cũ: " + sb1.getOldNumber() + " số mới: " + sb1.getNewNumber() + " = " + sb2.getTotal() + "\n"
                        + "Tổng tiền : " + ( sb1.getTotal() + sb2.getTotal()) + "VND";

                Notification notification = new Notification();
                notification.setTitle("Thanh toán hóa đơn thành công!");
                notification.setContent(content);
                notification.setRoomId(room_id);
                notification.setStatus(0);

                notificationService.addNotification(notification);

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

    @PutMapping("/pay/{room_id}/{sub_id_1}/{sub_id_2}")
    public JsonResponse payOne(@PathVariable(value = "room_id") Integer room_id, @PathVariable(value = "sub_id_1") Integer sub_id_1
                                ,  @PathVariable(value = "sub_id_1") Integer sub_id_2){
        try {

            ViewSubsistence sb1 = subsistenceFeeService.changeStatusOne(sub_id_1, 1);
            ViewSubsistence sb2 = subsistenceFeeService.changeStatusOne(sub_id_2, 1);
            if ( sb1 == null || sb2 == null) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "edit fail", null);
            } else {

                String content = "Phòng của bạn đã thanh toán hóa đơn điện nước thành công: \n"
                                + " tháng :" + sb1.getMonth() + " - " + sb1.getYear() + "\n"
                                + sb1.getNameCost() + " : \n"
                                + " Số cũ: " + sb1.getOldNumber() + " số mới: " + sb1.getNewNumber() + " = " + sb1.getTotal() + "\n"
                                + sb2.getNameCost() + " : \n"
                                + " Số cũ: " + sb1.getOldNumber() + " số mới: " + sb1.getNewNumber() + " = " + sb2.getTotal() + "\n"
                                + "Tổng tiền : " + ( sb1.getTotal() + sb2.getTotal()) + "VND";

                Notification notification = new Notification();
                notification.setTitle("Thanh toán hóa đơn thành công!");
                notification.setContent(content);
                notification.setRoomId(room_id);
                notification.setStatus(0);

                notificationService.addNotification(notification);
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_EDIT_SUCCESS, "edit fail", null);
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

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<ViewSubsistence> subsistenceFeeList){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(subsistenceFeeList));

        return jsonResponse;
    }
}
