package com.example.dorm_management.services;

import com.example.dorm_management.entities.Role;

import java.util.List;

/**
 * Created by vuong on 10/24/2018.
 */
public interface RoleService {
    Role findById(Integer id);
    boolean editRoleByGroupId(Integer roleId, Integer groupId);
    boolean editRoleByActionId(Integer roleId, Integer actionId);
    boolean addRole(Integer groupId, Integer actionId);
    boolean deleteRole(Integer id);
    List<Role> getAllRoles();

}
