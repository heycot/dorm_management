package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {

    @Query(value = "select * from floor where area_id = ?1", nativeQuery = true)
    List<Floor> getFloorsByAreaId(Integer areaId);

    @Query(value = "select * from floor where  id = ?1", nativeQuery = true)
    Floor findOneById(Integer id);
}
