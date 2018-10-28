package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vuong on 10/24/2018.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}