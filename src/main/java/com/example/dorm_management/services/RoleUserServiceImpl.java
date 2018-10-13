package com.example.dorm_management.services;

import com.example.dorm_management.entities.RoleUser;
import com.example.dorm_management.respositories.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vuong on 10/12/2018.
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    private RoleUserRepository roleUserRepository;
    @Override
    public RoleUser findRoleUserByUserId(Integer id) {
        return roleUserRepository.findByUserId(id);
    }

    @Override
    public List<RoleUser> findAllRoleUser() {
        return roleUserRepository.findAll();
    }

    @Override
    public RoleUser addRoleUser(RoleUser roleUser) {
        try {
            return roleUserRepository.save(roleUser);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean editRoleUser(RoleUser srcRoleUser, RoleUser targetRoleUser) {
        try{
            targetRoleUser.setStatus(srcRoleUser.getStatus());
            targetRoleUser.setUserId(srcRoleUser.getUserId());
            targetRoleUser.setRoleId(srcRoleUser.getRoleId());
            roleUserRepository.save(targetRoleUser);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteRoleUser(Integer id) {
        try{
            roleUserRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
