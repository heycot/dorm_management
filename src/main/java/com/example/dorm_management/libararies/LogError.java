package com.example.dorm_management.libararies;

import com.example.dorm_management.config.Basej4Logger;

public class LogError {

    public static String SUCCESS            = "SUCCESS";
    public static String FAIL               = "FAIL";
    public static String NOT_FOUND          = "NOT FOUND";
    public static String ERROR_EXCEPTION    = "ERROR EXCEPTION";

    public static void log(int api, String service, String status, String value){

        Basej4Logger.getInstance().info("API code: " + api, "service: " + service, "status: " + status, value);
    }
}
