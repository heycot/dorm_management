package com.example.dorm_management.DTO;

import java.util.HashMap;

/**
 * Created by vuong on 12/9/2018.
 */
public class InfoIndex {
    Integer sumRoom;
    Integer sumArea;
    Integer sumUser;
    HashMap<Integer, Integer> sumGroup;

    public Integer getSumRoom() {
        return sumRoom;
    }

    public void setSumRoom(Integer sumRoom) {
        this.sumRoom = sumRoom;
    }

    public Integer getSumArea() {
        return sumArea;
    }

    public void setSumArea(Integer sumArea) {
        this.sumArea = sumArea;
    }

    public Integer getSumUser() {
        return sumUser;
    }

    public void setSumUser(Integer sumUser) {
        this.sumUser = sumUser;
    }

    public HashMap<Integer, Integer> getSumGroup() {
        return sumGroup;
    }

    public void setSumGroup(HashMap<Integer, Integer> sumGroup) {
        this.sumGroup = sumGroup;
    }
}
