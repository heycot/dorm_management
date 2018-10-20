package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Area;
import com.example.dorm_management.entities.RoleUser;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.Utility;
import com.example.dorm_management.services.RoleUserService;
import com.example.dorm_management.services.RoleUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vuong on 10/12/2018.
 */
@RestController
@RequestMapping(RoleUserController.BASE_URL)
public class RoleUserController {
    public final  static String BASE_URL = "/api/role_user";

    @Autowired
    private RoleUserService roleUserService;

    @GetMapping
    public JsonResponse getAllRoleUser(){
        try {
            List<RoleUser> roleUsers = roleUserService.findAllRoleUser();
            return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", roleUsers);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "fail");
        }
    }

    @GetMapping(value = "/{id}")
    public JsonResponse getRoleUserById(@PathVariable(value = "id") Integer id){
        try{
            RoleUser roleUser = roleUserService.findRoleUserByUserId(id);
            return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", roleUser);
        }catch (Exception e){
            System.out.println(e.getCause());
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "fail");
        }
    }
}
