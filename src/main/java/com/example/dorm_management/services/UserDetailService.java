package com.example.dorm_management.services;

import com.example.dorm_management.entities.UserDetail;

/**
 * Created by vuong on 10/12/2018.
 */
public interface UserDetailService {
    UserDetail findUserDetailByUserId(Integer id);
}
