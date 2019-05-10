package com.example.dorm_management.libararies;

/**
 * Created by vuong on 11/23/2018.
 */
public class MD5Utility {
    public static String encode(String text){
        return org.springframework.util.DigestUtils.md5DigestAsHex(text.getBytes());
    }
}
