package com.example.dorm_management.DTO;

/**
 * Created by vuong on 11/30/2018.
 */
public class ResCountSumUserActionByGroup {
    Integer sumUser;
    Integer sumAction;

    public Integer getSumUser() {
        return sumUser;
    }

    public void setSumUser(Integer sumUser) {
        this.sumUser = sumUser;
    }

    public Integer getSumAction() {
        return sumAction;
    }

    public void setSumAction(Integer sumAction) {
        this.sumAction = sumAction;
    }

    public ResCountSumUserActionByGroup(Integer sumUser, Integer sumAction) {

        this.sumUser = sumUser;
        this.sumAction = sumAction;
    }
    public ResCountSumUserActionByGroup() {
    }
}
