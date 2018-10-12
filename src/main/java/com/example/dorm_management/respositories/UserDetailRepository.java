package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vuong on 10/12/2018.
 */
@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {
    UserDetail findByUserId(Integer id);
}
