package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.RoomFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomFunctionRepository extends JpaRepository<RoomFunction, Integer> {

    @Query(value = "select  * from room_function where type = ?1 and status = ?2", nativeQuery = true)
    RoomFunction findOneByTypeAndStatus(Integer type, Integer status);
}
