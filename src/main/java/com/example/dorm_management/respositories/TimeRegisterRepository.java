package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.TimeRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vuong on 12/4/2018.
 */
public interface TimeRegisterRepository extends JpaRepository<TimeRegister, Integer> {
    List<TimeRegister> findBySemesterId(Integer id);

}
