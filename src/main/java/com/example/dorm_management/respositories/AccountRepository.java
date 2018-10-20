package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT * FROM user WHERE id in (SELECT user_id FROM rent_room WHERE room_id = ?)", nativeQuery = true)
    List<Account> findUserByRoomId(Integer roomId);
    Account findUserById(Integer id);
    Account findByUserNameAndPassword(String name, String password);
}
