package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vuong on 10/12/2018.
 */
@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Integer> {
    List<RoleUser> findByUserId(Integer id);
    List<RoleUser> findByRoleId(Integer id);
}
