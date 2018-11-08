package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostRepository extends JpaRepository<Cost, Integer> {

    @Query(value = "select * from cost where id = ?1 and level = ?2", nativeQuery = true)
    Cost findOneByIdAndLevel(Integer id, Integer level);

    @Query(value = "select * from cost where type = ?1 and level = ?2 and status = ?3", nativeQuery = true)
    Cost findOneByTypeAndLevel(Integer type, Integer level, Integer status);

    @Query(value = "select * from cost where type = ?1 and status = ?2", nativeQuery = true)
    Cost findOneByTypeAndStatus(Integer type, Integer status);

    @Query(value = "select * from cost where type = ?1 order by id desc ", nativeQuery = true)
    List<Cost> findAllByType(Integer type);
}
