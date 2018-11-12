package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.*;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.CostService;
import com.example.dorm_management.services.NotificationService;
import com.example.dorm_management.services.SubsistenceFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

    @GetMapping("/{room_id}/{month}/{year}")
    public JsonResponse findAllByMonthAndYearAndRoom(@PathVariable(value = "room_id") Integer roomId, @PathVariable(value = "month") Integer month, @PathVariable(value = "year") String year) {
        try {

            List<SubsistenceFee> subsistenceFeeList = subsistenceFeeService.getAllSubsistenceByMonthAndYearAndRoomId(roomId, month, year);

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

    @GetMapping("/view/{month}/{year}")
    public JsonResponse findAllByMonthAndYear(@PathVariable(value = "month") Integer month, @PathVariable(value = "year") String year) {
        try {

            List<ViewSubsistence> subsistenceFeeList = subsistenceFeeService.getAllViewSubsistenceByMonthAndYear(month, year);

            if (subsistenceFeeList.size() > 0) {
                jsonResponse = return_List_View_Object_JsonPresonse(API.CODE_API_YES, "success", subsistenceFeeList);

            } else {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);
            }

            return jsonResponse;
        } catch (Exception e) {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return jsonResponse;
        }
    }

    @GetMapping("/area/{area_id}/{month}/{year}")
    public JsonResponse findAllByMonthAndYearAndAreaId(@PathVariable(value = "area_id") Integer areaId, @PathVariable(value = "month") Integer month, @PathVariable(value = "year") String year) {
        try {

            List<ViewSubsistence> subsistenceFeeList = subsistenceFeeService.findAllViewByMonthAndYearAndAreaId(areaId, month, year);

            if (subsistenceFeeList.size() > 0) {
                jsonResponse = return_List_View_Object_JsonPresonse(API.CODE_API_YES, "success", subsistenceFeeList);

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

    @PutMapping("/pay/{room_id}/{sub_id}")
    public JsonResponse payOne(@PathVariable(value = "room_id") Integer room_id, @PathVariable(value = "sub_id") Integer sub_id){
        try {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            SubsistenceFee sb1 = subsistenceFeeService.changeStatusOne(sub_id, 1);
            if ( sb1 == null ) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "edit fail", null);
            } else {

                Float total_elec = (sb1.getNewNumberElec() - sb1.getOldNumberElec()) * sb1.getCostElec();
                Float total_water = (sb1.getNewNumberWater() - sb1.getOldNumberWater()) * sb1.getCostWater();

                String content = "Phòng của bạn đã thanh toán hóa đơn điện nước thành công: \n"
                                + " tháng :" + sb1.getMonth() + " - " + sb1.getYear() + "\n"
                                + "tiền điện: \n"
                                + " Số cũ: " + sb1.getOldNumberElec() + " số mới: " + sb1.getNewNumberElec() + " = "
                                + total_elec + "\n"
                                + "tiền nước: \n"
                                + " Số cũ: " + sb1.getOldNumberWater() + " số mới: " + sb1.getNewNumberWater() + " = "
                                + total_water + "\n"
                                + "Tổng tiền : " + ( total_elec + total_water) + "VND";

                Notification notification = Notification.builder()
                        .status(0)
                        .content(content)
                        .title("Thanh toán hóa đơn tháng " + sb1.getMonth() + "/" + sb1.getYear() + " thành công!")
                        .roomId(room_id)
                        .time(timestamp).build();

                notificationService.addNotification(notification);
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_EDIT_SUCCESS, "edit fail", null);
            }

            return jsonResponse;
        } catch (Exception e){
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);
            return jsonResponse;
        }
    }


    @GetMapping("/send-notification")
    public JsonResponse sendNotificationSubsistence() {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Integer month = localDate.getMonthValue();
            Integer year  = localDate.getYear();

            List<SubsistenceFee> subsistenceFeeList = subsistenceFeeService.getAllSubsistenceNotPayBYMonthAndYear(month, String.valueOf(year));

            if (subsistenceFeeList.size() <= 0){
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NOTFOUND, "không có hóa đơn nào chưa thanh toán", null);
            } else {
                for(SubsistenceFee sb1 : subsistenceFeeList) {

                    Float total_elec = (sb1.getNewNumberElec() - sb1.getOldNumberElec()) * sb1.getCostElec();
                    Float total_water = (sb1.getNewNumberWater() - sb1.getOldNumberWater()) * sb1.getCostWater();

                    String content = "Phòng của bạn đã thanh toán hóa đơn điện nước thành công: \n"
                            + " tháng :" + sb1.getMonth() + " - " + sb1.getYear() + "\n"
                            + "tiền điện: \n"
                            + " Số cũ: " + sb1.getOldNumberElec() + " số mới: " + sb1.getNewNumberElec() + " = "
                            + total_elec + "\n"
                            + "tiền nước: \n"
                            + " Số cũ: " + sb1.getOldNumberWater() + " số mới: " + sb1.getNewNumberWater() + " = "
                            + total_water + "\n"
                            + "Tổng tiền : " + ( total_elec + total_water) + "VND";

                    Notification notification = Notification.builder()
                            .status(0)
                            .content(content)
                            .title("Thông báo tiền điện nước tháng " + sb1.getMonth() + "/" + sb1.getYear() + "!")
                            .roomId(sb1.getRoomId())
                            .time(timestamp).build();

                    notificationService.addNotification(notification);
                }

                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", null);

            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            return jsonResponse;
        }
    }

    @GetMapping("not-payed")
    public JsonResponse getAllSubsistenceNotPayed() {
        try {
            List<SubsistenceFee> subsistenceFeeList = subsistenceFeeService.getAllSubsistenceNotPay(0);

            if (subsistenceFeeList.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", subsistenceFeeList);
            } else {

                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_NOTFOUND, "not found", null);

            }

            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "error exception", null);

            return jsonResponse;
        }
    }


    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, SubsistenceFee subsistenceFee){
        jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(subsistenceFee));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<SubsistenceFee> subsistenceFeeList){
        jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(subsistenceFeeList));

        return jsonResponse;
    }


    public JsonResponse return_List_View_Object_JsonPresonse(Integer code, String message, List<ViewSubsistence> subsistenceFeeList) {
        jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(subsistenceFeeList));

        return jsonResponse;
    }

}
