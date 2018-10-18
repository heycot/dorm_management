package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.SubsistenceFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubsistenceFeeRepository extends JpaRepository<SubsistenceFee, Integer> {

    @Query(value = "select * from subsistence_fee where room_id = ?1 order by id desc ", nativeQuery = true)
    List<SubsistenceFee> findALlByRoomId(Integer roomId);
}
