package com.example.dorm_management.services;

import com.example.dorm_management.entities.Role;
import com.example.dorm_management.json.API;
import com.example.dorm_management.libararies.Utility;
import com.example.dorm_management.respositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vuong on 10/24/2018.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAllRoleByGroupId(Integer groupId) {
        return roleRepository.findAllRoleByGroupId(groupId);
    }

    @Override
    public Role findById(Integer id) {
        Role role = roleRepository.findOne(id);
        if(role != null) return role;
        return null;
    }

    @Override
    public boolean editRole(Integer roleId, Role role) {
        try{
            Role role1 = findById(roleId);
            if(role1 == null) return false;
            role.setId(role1.getId());
            roleRepository.save(role);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editRoleByGroupId(Integer roleId, Integer groupId) {
        Role role = findById(roleId);
        if(role == null) return false;
        role.setGroupId(groupId);
        roleRepository.save(role);
        return true;
    }

    @Override
    public boolean editRoleByActionId(Integer roleId, Integer actionId) {
        Role role = findById(roleId);
        if(role == null) return false;
        role.setActionId(actionId);
        roleRepository.save(role);
        return true;
    }

    @Override
    public boolean addRole(Integer groupId, Integer actionId) {
        try{
            Role role = new Role(actionId, groupId);
            roleRepository.save(role);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteRole(Integer id) {
        try{
            roleRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
