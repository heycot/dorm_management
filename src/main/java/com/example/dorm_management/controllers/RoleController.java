package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Area;
import com.example.dorm_management.entities.Role;
import com.example.dorm_management.entities.User;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.Utility;
import com.example.dorm_management.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vuong on 10/24/2018.
 */
@RestController
@RequestMapping(AreaController.BASE_URL)
public class RoleController {
    public final static String BASE_URL = "/api/role";

    @Autowired
    private RoleService roleService;

    @GetMapping
    public JsonResponse getAllAreas(){
        try {
            List<Role> roles = roleService.getAllRoles();
            return Utility.convertObjectToJSON(API.CODE_API_YES, "sucess", roles);
        } catch (Exception e) {
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/edit_group/{role_id}/{group_id}")
    public JsonResponse editRoleByGroupId(@PathVariable(value = "role_id") Integer roleId, @PathVariable(value = "group_id") Integer groupId){
        try{
            boolean b = roleService.editRoleByGroupId(roleId, groupId);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_EDIT_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_ERROR, "");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/edit_action/{role_id}/{action_id}")
    public JsonResponse editRoleByAction(@PathVariable(value = "role_id") Integer roleId, @PathVariable(value = "action_id") Integer actionId){
        try{
            boolean b = roleService.editRoleByActionId(roleId, actionId);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_EDIT_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_ERROR, "");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/add/{role_id}/{action_id}")
    public JsonResponse editRoleByAction(@RequestBody Role role){
        try{
            boolean b = roleService.addRole(role.getGroupId(), role.getActionId());
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_EDIT_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_ERROR, "");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, e.getMessage());
        }
    }
}
