package com.example.dorm_management.services;

import com.example.dorm_management.entities.Role;
import com.example.dorm_management.entities.RoleUser;
import com.example.dorm_management.entities.User;
import com.example.dorm_management.respositories.ActionRepository;
import com.example.dorm_management.respositories.RoleRepository;
import com.example.dorm_management.respositories.RoleUserRepository;
import com.example.dorm_management.respositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleUser> findRoleUserByUserId(Integer id) {
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
            targetRoleUser.setUser(srcRoleUser.getUser());
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

    @Override
    public boolean changeStatusByUserNameAndIdAction(String username, Integer idAction) {
        try{
            User user = userRepository.findUserByUserName(username);
            if(user == null) return false;
            Role role = roleRepository.findRoleByActionIdAndGroupId(idAction, user.getGroup().getId());
            List<RoleUser> roleUsers = user.getRoleUsers();
            for(RoleUser roleUser : roleUsers){
                if(roleUser.getRoleId().equals(role.getId())){
                    roleUser.setStatus(roleUser.getStatus() == 1 ? 0 : 1);
                    userRepository.save(user);
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
