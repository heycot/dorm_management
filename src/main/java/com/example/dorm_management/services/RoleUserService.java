package com.example.dorm_management.services;

import com.example.dorm_management.entities.Role;
import com.example.dorm_management.entities.RoleUser;

import java.util.List;

/**
 * Created by vuong on 10/12/2018.
 */
public interface RoleUserService {
    RoleUser findRoleUserByUserId(Integer id);
    List<RoleUser> findAllRoleUser();
    RoleUser addRoleUser(RoleUser roleUser);
    boolean editRoleUser(RoleUser srcRoleUser, RoleUser targetRoleUser);
    boolean deleteRoleUser(Integer id);
}
