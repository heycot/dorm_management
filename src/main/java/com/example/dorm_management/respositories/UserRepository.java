package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Action;
import com.example.dorm_management.entities.User;
import com.example.dorm_management.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE id in (SELECT user_id FROM rent_room WHERE room_id = ?)", nativeQuery = true)
    List<User> findUserByRoomId(Integer roomId);
    User findUserById(Integer id);
    List<User> findUserByUserNameAndPassword(String name, String password);
    List<User> findUserByUserName(String name);
    @Query(value = "SELECT * FROM groups INNER JOIN role ON groups.id = role.groups_id INNER JOIN user ON role.id = user.role_id WHERE user.id = ?)", nativeQuery = true)
    List<Group> findGroupByUserId(Integer id);

    @Query(value = "SELECT * FROM action INNER JOIN role ON groups.id = role.groups_id INNER JOIN user ON role.id = user.role_id WHERE user.id = ?)", nativeQuery = true)
    List<Action> findActionByUserId(Integer id);

    @Query(value = "SELECT * FROM user WHERE id in (SELECT user_id FROM rent_room LEFT JOIN room ON rent_room.room_id = room.id" +
            " WHERE room.floor_id = ?1)", nativeQuery = true)
    List<User> findUserByFloorId(Integer id);

    @Query(value = "SELECT * FROM user WHERE id in (SELECT user_id FROM rent_room LEFT JOIN room ON rent_room.room_id = room.id" +
            " INNER JOIN floor ON room.floor_id = floor.id WHERE floor.area_id = ?1)", nativeQuery = true)
    List<User> findUserByAreaId(Integer id);

    @Query(value = "SELECT user.* FROM user INNER JOIN student_code ON user.student_code = student_code.id "
            + "WHERE user.password = ?2 AND student_code.value = ?1", nativeQuery = true)
    User getUserByStudentCodeAndPassword(String studentCode, String password);
}
