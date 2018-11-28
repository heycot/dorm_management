package com.example.dorm_management.respositories;

import com.example.dorm_management.DTO.ActionResult;
import com.example.dorm_management.DTO.GroupResult;
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
    User findUserByUserNameAndPassword(String name, String password);
    User findUserByUserName(String name);
    @Query(value = "SELECT DISTINCT groups.id as id , groups.name as name FROM groups INNER JOIN role ON groups.id = role.group_id INNER JOIN role_user ON role.id = role_user.role_id INNER JOIN user ON user.id = role_user.user_id WHERE user.id = ?1", nativeQuery = true)
    List<GroupResult> findGroupByUserId(Integer id);

    @Query(value = "SELECT DISTINCT action.code as code, action.id as id, action.name as name FROM action INNER JOIN role ON action.id = role.action_id INNER JOIN role_user ON role.id = role_user.role_id INNER JOIN user ON user.id = role_user.user_id WHERE user.id = ?1", nativeQuery = true)
    List<ActionResult> findActionByUserId(Integer id);

    @Query(value = "SELECT DISTINCT action.code as code, action.id as id, action.name as name FROM action INNER JOIN role ON action.id = role.action_id INNER JOIN role_user ON role.id = role_user.role_id INNER JOIN user ON user.id = role_user.user_id WHERE user.user_name = ?1", nativeQuery = true)
    List<ActionResult> findActionByUserName(String name);

    @Query(value = "SELECT * FROM user WHERE id in (SELECT user_id FROM rent_room LEFT JOIN room ON rent_room.room_id = room.id" +
            " WHERE room.floor_id = ?1)", nativeQuery = true)
    List<User> findUserByFloorId(Integer id);

    @Query(value = "SELECT * FROM user WHERE id in (SELECT user_id FROM rent_room LEFT JOIN room ON rent_room.room_id = room.id" +
            " INNER JOIN floor ON room.floor_id = floor.id WHERE floor.area_id = ?1)", nativeQuery = true)
    List<User> findUserByAreaId(Integer id);

    @Query(value = "SELECT user.* FROM user INNER JOIN student_code ON user.student_code = student_code.id "
            + "WHERE user.password = ?2 AND student_code.value = ?1", nativeQuery = true)
    User getUserByStudentCodeAndPassword(String studentCode, String password);

    @Query(value = "SELECT user.* FROM user INNER JOIN student_code ON user.student_code = student_code.id "
            + "WHERE student_code.value = ?1", nativeQuery = true)
    User getUserByStudentCode(String studentCode);

    @Query(value = "SELECT DISTINCT user.* FROM user INNER JOIN role_user ON user.id = role_user.user_id " +
            " INNER JOIN role ON role_user.role_id = role.id" +
            " INNER JOIN groups ON role.group_id = groups.id"
            + " WHERE groups.id = ?1", nativeQuery = true)
    List<User> getUsersByGroupId(Integer idGroup);


}
