package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.RentRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRoomRepository extends JpaRepository<RentRoom, Integer> {

    @Query(value = "select * from rent_room where user_id = ?1  and status = ?2 ", nativeQuery = true)
    RentRoom findOneByUserId(Integer userId, Integer status);
}
