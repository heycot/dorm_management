package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.RegisterRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRoomRepository extends JpaRepository<RegisterRoom, Integer> {

    @Query(value = "select * from register_room where room_id = ?1 order by id desc", nativeQuery = true)
    RegisterRoom findOneByRoomId(Integer roomId);

}
