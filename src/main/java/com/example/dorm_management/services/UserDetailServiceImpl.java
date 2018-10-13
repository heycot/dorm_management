package com.example.dorm_management.services;

import com.example.dorm_management.entities.UserDetail;
import com.example.dorm_management.respositories.UserDetailRepository;
import org.springframework.stereotype.Service;

/**
 * Created by vuong on 10/12/2018.
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {
    private UserDetailRepository userDetailRepository;
    @Override
    public UserDetail findUserDetailByUserId(Integer id) {
        return userDetailRepository.findByUserId(id);
    }

    public boolean deleteUserDetailByUserId(Integer id){
        UserDetail userDetail = findUserDetailByUserId(id);
        if(userDetail != null){
            userDetailRepository.delete(userDetail.getId());
            return true;
        }
        return false;
    }

    public boolean addUserDetail(UserDetail userDetail){
        try{
            userDetailRepository.save(userDetail);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
