package com.example.dorm_management.libararies;

import com.example.dorm_management.DTO.ActionResult;
import com.example.dorm_management.config.Basej4Logger;
import com.example.dorm_management.entities.Action;
import com.example.dorm_management.json.JsonResponse;

import java.util.Collections;
import java.util.List;

/**
 * Created by vuong on 10/12/2018.
 */
public class Utility {
    public static String getEndSchoolYearByMSSV(String MSSV){
        //10214054
        if(MSSV.length() == 9){
            return "20" + String.valueOf(Integer.parseInt(MSSV.substring(3, 5)) + 5);
        }
        return "";
    }

    public static boolean isOwnedRole(Integer code, List<ActionResult> actions){
        for (ActionResult action: actions){
            if(action.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    public static JsonResponse convertObjectToJSON(Integer code, String mes, Object data){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(mes);
        jsonResponse.setData(data);
        return jsonResponse;
    }

    public static JsonResponse convertObjectToJSON(Integer code, String mes){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(mes);
        jsonResponse.setData(null);
        return jsonResponse;
    }

    public static JsonResponse convertObjectToJSON(Integer code, String mes, List<Object> data){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(mes);
        jsonResponse.setData(Collections.unmodifiableCollection(data));
        return jsonResponse;
    }
}
