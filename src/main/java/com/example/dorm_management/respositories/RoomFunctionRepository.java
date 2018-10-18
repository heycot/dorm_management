package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.RoomFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomFunctionRepository extends JpaRepository<RoomFunction, Integer> {
}
