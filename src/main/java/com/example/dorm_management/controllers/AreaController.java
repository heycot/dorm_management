package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Area;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/*
* Auth = Tu
* */

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
            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có nhà nào");
            return jsonResponse;
        }
    }

    @GetMapping(value = "/{id}")
    public JsonResponse getAreaById(@PathVariable(value = "id") Integer id){
        try{
            Area areaEntity = areaService.findAreaById(id);
            if ( areaEntity == null) {

                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có nhà nào");
                return jsonResponse;
            }else {

                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES, "", areaEntity);
                return jsonResponse;
            }
        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Lỗi format id");
            return jsonResponse;
        }
    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Area> updateArea(@PathVariable(value = "id") Integer id, @Valid @RequestBody Area areaEntity, Error error){
     public JsonResponse updateArea(@PathVariable(value = "id") Integer id, @Valid @RequestBody Area areaEntity){
        try {
//         if(error.hashCode()) {
//            return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
//
//        }

            Area areaEntityEdit = areaService.findAreaById(id);

            if (areaEntityEdit == null) {

                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có khu nhà nào");

                return jsonResponse;
            }

            if ( areaService.editArea(areaEntity, areaEntityEdit) == true) {
                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES,
                                "Sửa khu nhà " + areaEntityEdit.getName() + " thành công!", areaEntityEdit);
                return jsonResponse;
            } else{

                jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO,
                        "Sửa khu nhà " + areaEntityEdit.getName() + " không thành công!", areaEntityEdit);
                return jsonResponse;
            }
        } catch (Exception e) {
            System.out.println(e.getCause());

            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Lỗi format id");
            return jsonResponse;
        }
    }

    @PutMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public JsonResponse addNewArea(@Valid @RequestBody Area areaEntity) {
        if (areaService.addNewArea(areaEntity) == null) {

            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_NO,
                    "Thêm khu nhà" + areaEntity.getName() + " không thành công", areaEntity);
            return jsonResponse;
        } else {
            jsonResponse = return_One_Object_JsonPresonse(API.CODE_API_YES,
                    "Thêm khu nhà" + areaEntity.getName() + " thành công", areaEntity);
            return jsonResponse;
        }
    }

    public JsonResponse return_No_Object_JsonPresonse(Integer code, String message){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(null);

        return jsonResponse;
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, Area are){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(are));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<Area> areas){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(areas));

        return jsonResponse;
    }
}
