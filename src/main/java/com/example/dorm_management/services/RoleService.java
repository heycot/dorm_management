package com.example.dorm_management.services;

import com.example.dorm_management.entities.Role;

import java.util.List;

/**
 * Created by vuong on 10/24/2018.
 */
public interface RoleService {
    List<Role> findAllRoleByGroupId(Integer groupId);
    Role findById(Integer id);
    Role findByActionIdAndGroupId(Integer idAction, Integer idGroup);
    boolean editRole(Integer roleId, Role role);
    boolean editRoleByGroupId(Integer roleId, Integer groupId);
    boolean editRoleByActionId(Integer roleId, Integer actionId);
    boolean addRole(Integer groupId, Integer actionId);
    boolean deleteRole(Integer id);
    List<Role> getAllRoles();


}
