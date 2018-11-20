package com.example.dorm_management.controllers;

import com.example.dorm_management.config.Basej4Logger;
import com.example.dorm_management.entities.Area;
import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.LogError;
import com.example.dorm_management.services.AreaService;
import com.example.dorm_management.services.FloorService;
import com.example.dorm_management.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(AreaController.BASE_URL)
public class AreaController {

    public final static String BASE_URL = "/api/areas";

    @Autowired
    private AreaService areaService;


    private JsonResponse jsonResponse;


    @GetMapping
     public JsonResponse getAllAreas(){
        try {
            List<Area> areas = areaService.findAllAreas();

            jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "", areas);

            LogError.log(API.CODE_API_YES, "find all area ", LogError.SUCCESS,"total :" + areas.size());
            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có nhà nào");

            LogError.log(API.CODE_API_NOTFOUND, "find all area", LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @GetMapping(value = "/{id}")
    public JsonResponse getAreaById(@PathVariable(value = "id") Integer id){
        try{
            Area areaEntity = areaService.findAreaById(id);
            if ( areaEntity == null) {

                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có nhà nào");

                LogError.log(API.CODE_API_NOTFOUND,  "find one area by id", LogError.NOT_FOUND, "");
            }else {

                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "", areaEntity);
                LogError.log(API.CODE_API_YES,  "find one area by id ", LogError.SUCCESS, areaEntity.getName());
            }
            return jsonResponse;

        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "error exception");
            LogError.log(API.CODE_API_ERROR,  "find one area by id " ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @GetMapping(value = "/change-status/{id}/{status}")
    public JsonResponse disableOne(@PathVariable(value = "id") Integer id, @PathVariable(value = "status") Integer status){
        try{
            if (status != 0) {
                status = 1;
            }

            Area area = areaService.changeStatus(id, status);
            if ( area == null) {

                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NO, "fail");
                LogError.log(API.CODE_API_ERROR,  "change status one area " ,LogError.NOT_FOUND, "");
            }else {

                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "success", area);
                LogError.log(API.CODE_API_YES,  "change status one area" ,LogError.SUCCESS, area.getName());
            }
            return jsonResponse;

        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "error exception");
            LogError.log(API.CODE_API_ERROR,  "change status one area" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Area> updateArea(@PathVariable(value = "id") Integer id, @Valid @RequestBody Area areaEntity, Error error){
     public JsonResponse updateArea(@PathVariable(value = "id") Integer id, @Valid @RequestBody Area areaEntity, BindingResult br){
        try {
//         if(br.hashCode()) {
////             jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_ERROR, "")
//            return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
//
//        }

            Area areaEntityEdit = areaService.findAreaById(id);

            if (areaEntityEdit == null) {

                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có khu nhà nào");

                LogError.log(API.CODE_API_NO,  "edit one area" ,LogError.FAIL, "");
                return jsonResponse;
            }

            if ( areaService.editArea(areaEntity, areaEntityEdit) == true) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "Sửa khu nhà " + areaEntityEdit.getName() + " thành công!", areaEntityEdit);

                LogError.log(API.CODE_API_YES,  "edit one area" ,LogError.SUCCESS, areaEntity.getName());
                return jsonResponse;
            } else{

                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "Sửa khu nhà " + areaEntityEdit.getName() + " không thành công!", areaEntityEdit);

                LogError.log(API.CODE_API_NO,  "edit one area" ,LogError.FAIL, areaEntity.getName());
                return jsonResponse;
            }
        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Lỗi format id");
            LogError.log(API.CODE_API_ERROR,  "edit one area" ,LogError.ERROR_EXCEPTION, "");
            return jsonResponse;
        }
    }

    @PutMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public JsonResponse addNewArea(@Valid @RequestBody Area areaEntity) {
        if (areaService.addNewArea(areaEntity) == null) {

            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO, "Thêm khu nhà" + areaEntity.getName() + " không thành công", areaEntity);

            LogError.log(API.CODE_API_NO,  "add new area" ,LogError.FAIL, "");
            return jsonResponse;
        } else {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "Thêm khu nhà" + areaEntity.getName() + " thành công", areaEntity);

            LogError.log(API.CODE_API_YES,  "add new area" ,LogError.SUCCESS, areaEntity.getName());
            return jsonResponse;
        }
    }

    public JsonResponse return_No_Object_JsonPresonse(Integer code, String message){
         jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(null);

        return jsonResponse;
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, Area are){
         jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(are));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<Area> areas){
         jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(areas));

        return jsonResponse;
    }

}
