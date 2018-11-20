package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.TimeRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface TimeRegisterRepository extends JpaRepository<TimeRegister, Integer> {

    @Query(value = "select  * from time_register where date_begin = ?1 and date_end = ?2", nativeQuery = true)
    TimeRegister findOneByDateBeginAndEnd(Timestamp dtBegin, Timestamp dtEnd);

    @Query(value = "select  * from time_register where date_begin <= ?1 and date_end > ?1", nativeQuery = true)
    TimeRegister findOneCurrentTime(Timestamp curTime);
}
