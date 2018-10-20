package com.example.dorm_management.libararies;

import com.example.dorm_management.json.JsonResponse;

import java.util.Collections;
import java.util.List;

/**
 * Created by vuong on 10/12/2018.
 */
public class Utility {
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
