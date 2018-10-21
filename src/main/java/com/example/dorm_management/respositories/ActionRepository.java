package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vuong on 10/21/2018.
 */
public interface ActionRepository extends JpaRepository<Action, Integer> {
}
