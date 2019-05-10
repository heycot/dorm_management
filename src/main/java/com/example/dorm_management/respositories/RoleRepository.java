package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vuong on 10/24/2018.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "select * from role " +
            "inner join groups on role.group_id = groups.id where groups.id = ?1", nativeQuery = true)
    List<Role> findAllRoleByGroupId(Integer groupId);

    @Query(value = "select * from role " +
            "where role.action_id = ?1 and role.group_id = ?2", nativeQuery = true)
    Role findRoleByActionIdAndGroupId(Integer actionId, Integer groupId);
}