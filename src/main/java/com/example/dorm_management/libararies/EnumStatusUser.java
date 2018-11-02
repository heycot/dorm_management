package com.example.dorm_management.libararies;

/**
 * Created by vuong on 11/2/2018.
 */
public enum EnumStatusUser {
    NONE(0),
    ACTIVE(1),
    UNACTIVE(2),
    BLOCKED(3);
    private int code;
    EnumStatusUser(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static EnumStatusUser byCode(int code){
        return EnumStatusUser.values()[code];
    }
}
