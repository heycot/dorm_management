package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.SubsistenceFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubsistenceFeeRepository extends JpaRepository<SubsistenceFee, Integer> {

//    @Query(value = "select sb.*, cost.name as name_cost, cost.value as value_cost from subsistence_fee as sb  " +
//            "INNER JOIN cost ON sb.cost_id = cost.id " +
//            "where room_id = ?1 order by sb.id desc", nativeQuery = true)
//    List<ViewSubsistence> findALlByRoomId(Integer roomId);

    @Query(value = "select * from subsistence_fee as sb where room_id = ?1 order by sb.id desc", nativeQuery = true)
    List<SubsistenceFee> findALlByRoomId(Integer roomId);

//    @Query(value = "select sb.*, cost.name as name_cost, cost.value as value_cost from subsistence_fee as sb  " +
//            "INNER JOIN cost ON sb.cost_id = cost.id " +
//            "where room_id = ?1 and type = ?2 order by sb.id desc", nativeQuery = true)
//    List<SubsistenceFee> findALlWaterByRoomId(Integer roomId, Integer type);
//
//    @Query(value = "select sb.*, cost.name as name_cost, cost.value as value_cost from subsistence_fee as sb  " +
//            "INNER JOIN cost ON sb.cost_id = cost.id " +
//            "where room_id = ?1 and type = ?2 order by sb.id desc", nativeQuery = true)
//    List<SubsistenceFee> findALlElecByRoomId(Integer roomId, Integer type);
//
//

    @Query(value = "select * from subsistence_fee where sb.id = ?1", nativeQuery = true)
    SubsistenceFee findViewOne(Integer id);

    @Query(value = "select * from subsistence_fee as sb  " +
            "where sb.month = ?1 and sb.year like ?2", nativeQuery = true)
    List<SubsistenceFee> getAllSubsistenceNotPayBYMonthAndYear(Integer month, Integer year);

    @Query(value = "select * from subsistence_fee as sb  " +
            "where sb.status = ?1", nativeQuery = true)
    List<SubsistenceFee> getAllSubsistenceNotPay(Integer status);
}
