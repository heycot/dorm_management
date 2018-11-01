package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.ViewSubsistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewSubsistenceFeeRepository extends JpaRepository<ViewSubsistence, Integer> {

    @Query(value = "SELECT sb.*, room.name as room_name, floor.id as floor_id, floor.name as floor_name, area.id as area_id, area.name as area_name " +
            " FROM subsistence_fee as sb  \n" +
            " LEFT JOIN room ON sb.room_id = room.id\n" +
            " LEFT JOIN floor ON room.floor_id = floor.id\n" +
            " LEFT JOIN area ON floor.area_id = area.id\n" +
            " WHERE sb.month = ?1 and sb.year like ?2 order by sb.id desc", nativeQuery = true)
    List<ViewSubsistence> getAllViewSubsistence(Integer month, String year);
}
