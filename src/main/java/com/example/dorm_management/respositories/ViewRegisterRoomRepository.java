package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.ViewRegisterRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRegisterRoomRepository extends JpaRepository<ViewRegisterRoom, Integer> {

    @Query(value = "SELECT rr.*, user.gender AS gender, user_detail.full_name AS user_full_name, student_code.name as class_name, " +
            "student_code.value AS studentcode_code_value, room.name as room_name, floor.id AS floor_id, " +
            "floor.name AS floor_name, area.id as area_id, area.name as area_name, semester.name as semester_name " +
            "FROM register_room AS rr  " +
            "LEFT JOIN user ON rr.user_id = user.id " +
            "LEFT JOIN student_code ON user.id = student_code.user_id " +
            "LEFT JOIN user_detail ON user.id = user_detail.user_id " +
            "LEFT JOIN room ON rr.room_id = room.id " +
            "LEFT JOIN floor ON room.floor_id = floor.id " +
            "LEFT JOIN area ON floor.area_id = area.id " +
            "LEFT JOIN semester ON rr.semester_id =  semester.id " +
            "WHERE rr.id = ?1", nativeQuery = true)
    ViewRegisterRoom getOneViewById(Integer id);

    @Query(value = "SELECT rr.*, user.gender AS gender, user_detail.full_name AS user_full_name, student_code.name as class_name, " +
            "student_code.value AS studentcode_code_value, room.name as room_name, floor.id AS floor_id, " +
            "floor.name AS floor_name, area.id as area_id, area.name as area_name, semester.name as semester_name " +
            "FROM register_room AS rr  " +
            "LEFT JOIN user ON rr.user_id = user.id " +
            "LEFT JOIN student_code ON user.id = student_code.user_id " +
            "LEFT JOIN user_detail ON user.id = user_detail.user_id " +
            "LEFT JOIN room ON rr.room_id = room.id " +
            "LEFT JOIN floor ON room.floor_id = floor.id " +
            "LEFT JOIN area ON floor.area_id = area.id " +
            "LEFT JOIN semester ON rr.semester_id =  semester.id " +
            "WHERE rr.room_id = ?1", nativeQuery = true)
    List<ViewRegisterRoom> findAllByRoomId(Integer roomId);

        @Query(value = "SELECT rr.*, user.gender AS gender, user_detail.full_name AS user_full_name, student_code.name as class_name, " +
                "student_code.value AS studentcode_code_value, room.name as room_name, floor.id AS floor_id, " +
                "floor.name AS floor_name, area.id as area_id, area.name as area_name, semester.name as semester_name " +
                "FROM register_room AS rr  " +
                "LEFT JOIN user ON rr.user_id = user.id " +
                "LEFT JOIN student_code ON user.id = student_code.user_id " +
                "LEFT JOIN user_detail ON user.id = user_detail.user_id " +
                "LEFT JOIN room ON rr.room_id = room.id " +
                "LEFT JOIN floor ON room.floor_id = floor.id " +
                "LEFT JOIN area ON floor.area_id = area.id " +
                "LEFT JOIN semester ON rr.semester_id =  semester.id " +
                "WHERE rr.user_id = ?1", nativeQuery = true)
        List<ViewRegisterRoom> findAllByUserId(Integer userId);

    @Query(value = "SELECT rr.*, user.gender AS gender, user_detail.full_name AS user_full_name, student_code.name as class_name, " +
            "student_code.value AS studentcode_code_value, room.name as room_name, floor.id AS floor_id, " +
            "floor.name AS floor_name, area.id as area_id, area.name as area_name, semester.name as semester_name " +
            "FROM register_room AS rr  " +
            "LEFT JOIN user ON rr.user_id = user.id " +
            "LEFT JOIN student_code ON user.id = student_code.user_id " +
            "LEFT JOIN user_detail ON user.id = user_detail.user_id " +
            "LEFT JOIN room ON rr.room_id = room.id " +
            "LEFT JOIN floor ON room.floor_id = floor.id " +
            "LEFT JOIN area ON floor.area_id = area.id " +
            "LEFT JOIN semester ON rr.semester_id =  semester.id " +
            "WHERE rr.room_id = ?1  and rr.status = ?2 order by rr.id desc ", nativeQuery = true)
    List<ViewRegisterRoom> findAllByRoomIdAndStatus(Integer id, Integer status);

    @Query(value = "SELECT rr.*, user.gender AS gender, user_detail.full_name AS user_full_name, student_code.name as class_name, " +
            "student_code.value AS studentcode_code_value, room.name as room_name, floor.id AS floor_id, " +
            "floor.name AS floor_name, area.id as area_id, area.name as area_name, semester.name as semester_name " +
            "FROM register_room AS rr  " +
            "LEFT JOIN user ON rr.user_id = user.id " +
            "LEFT JOIN student_code ON user.id = student_code.user_id " +
            "LEFT JOIN user_detail ON user.id = user_detail.user_id " +
            "LEFT JOIN room ON rr.room_id = room.id " +
            "LEFT JOIN floor ON room.floor_id = floor.id " +
            "LEFT JOIN area ON floor.area_id = area.id " +
            "LEFT JOIN semester ON rr.semester_id =  semester.id " +
            "WHERE floor.area_id = ?1", nativeQuery = true)
    List<ViewRegisterRoom> findAllByAreaId(Integer id);

    @Query(value = "SELECT rr.*, user.gender AS gender, user_detail.full_name AS user_full_name, student_code.name as class_name, " +
            "student_code.value AS studentcode_code_value, room.name as room_name, floor.id AS floor_id, " +
            "floor.name AS floor_name, area.id as area_id, area.name as area_name, semester.name as semester_name " +
            "FROM register_room AS rr  " +
            "LEFT JOIN user ON rr.user_id = user.id " +
            "LEFT JOIN student_code ON user.id = student_code.user_id " +
            "LEFT JOIN user_detail ON user.id = user_detail.user_id " +
            "LEFT JOIN room ON rr.room_id = room.id " +
            "LEFT JOIN floor ON room.floor_id = floor.id " +
            "LEFT JOIN area ON floor.area_id = area.id " +
            "LEFT JOIN semester ON rr.semester_id =  semester.id " +
            "WHERE floor.id = ?1", nativeQuery = true)
    List<ViewRegisterRoom> findAllByFloorId(Integer id);
}
