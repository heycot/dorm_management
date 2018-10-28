package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<Cost, Integer> {

    @Query(value = "select * from cost where id = ?1 and level = ?2", nativeQuery = true)
    Cost findOneByIdAndLevel(Integer id, Integer level);

    @Query(value = "select * from cost where type = ?1 and level = ?2 and status = ?3", nativeQuery = true)
    Cost findOneByTypeAndLevel(Integer type, Integer level, Integer status);
}
