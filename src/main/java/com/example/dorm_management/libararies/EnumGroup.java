package com.example.dorm_management.libararies;

/**
 * Created by vuong on 11/2/2018.
 */
public enum EnumGroup {
    NONE(0),
    STUDENT(1),
    STAFF(2);

    private int code;
    EnumGroup(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public EnumGroup byCode(int code){
        return EnumGroup.values()[code];
    }
}
