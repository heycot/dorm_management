package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.SubsistenceFee;
import com.example.dorm_management.entities.ViewSubsistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubsistenceFeeRepository extends JpaRepository<SubsistenceFee, Integer> {

    @Query(value = "select sb.*, cost.name as name_cost, cost.value as value_cost from subsistence_fee as sb  " +
                    "INNER JOIN cost ON sb.cost_id = cost.id " +
                    "where room_id = ?1 order by sb.id desc", nativeQuery = true)
    List<ViewSubsistence> findALlByRoomId(Integer roomId);

    @Query(value = "select sb.*, cost.name as name_cost, cost.value as value_cost from subsistence_fee as sb  " +
            "INNER JOIN cost ON sb.cost_id = cost.id " +
            "where sb.id = ?1", nativeQuery = true)
    ViewSubsistence findViewOne(Integer id);
}
