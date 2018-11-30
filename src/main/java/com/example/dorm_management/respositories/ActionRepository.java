package com.example.dorm_management.respositories;

import com.example.dorm_management.DTO.ActionResult;
import com.example.dorm_management.entities.Action;
import com.example.dorm_management.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vuong on 10/21/2018.
 */
public interface ActionRepository extends JpaRepository<Action, Integer> {
    @Query(value = "SELECT  action.code as code, action.id as id, action.name as name FROM action INNER JOIN role ON action.id = role.action_id INNER JOIN groups ON groups.id = role.group_id WHERE groups.id = ?1", nativeQuery = true)
    List<ActionResult> findActionByGroupId(Integer id);
}
