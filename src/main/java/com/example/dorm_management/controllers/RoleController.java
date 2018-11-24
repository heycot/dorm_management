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
@RequestMapping(RoleController.BASE_URL)
public class RoleController {
    public final static String BASE_URL = "/api/role";

    @Autowired
    private RoleService roleService;

    @GetMapping
    public JsonResponse getAllRole(){
        try {
            List<Role> roles = roleService.getAllRoles();
            return Utility.convertObjectToJSON(API.CODE_API_YES, "sucess", roles);
        } catch (Exception e) {
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, e.getMessage());
        }
    }
    @GetMapping("/delete/{id}")
    public JsonResponse deleteRole(@PathVariable(value = "id") Integer id){
        try {
            boolean b = roleService.deleteRole(id);
            return Utility.convertObjectToJSON(API.CODE_API_YES, "sucess");
        } catch (Exception e) {
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, e.getMessage());
        }
    }

/*    @PostMapping(value = "/edit_group/{role_id}/{group_id}")
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
    }*/

    @PostMapping(value = "/edit_role")
    public JsonResponse editRoleByAction(@RequestBody Role role){
        try{
            boolean b = roleService.editRole(role.getId(), role);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_EDIT_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_ERROR, "");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, e.getMessage());
        }
    }

    @PostMapping(value = "/add")
    public JsonResponse addRole(@RequestBody Role role){
        try{
            boolean b = roleService.addRole(role.getGroupId(), role.getActionId());
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_EDIT_SUCCESS, "add role sucess", b);
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_ERROR, "add role error", b);
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, e.getMessage());
        }
    }
}
