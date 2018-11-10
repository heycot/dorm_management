package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.ViewRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRoomRepository extends JpaRepository<ViewRoom, Integer> {

    @Query(value = "select room.*, floor.name as name_floor, room_function.name as name_function, area.id as area_id, area.name as name_area, cost.name as name_cost, cost.value as value_cost, cost.level as level_cost from room \n" +
            " INNER JOIN cost ON room.cost_id = cost.id\n" +
            " INNER JOIN floor ON room.floor_id = floor.id\n" +
            " inner join area ON floor.area_id = area.id\n" +
            " INNER JOIN room_function on room.function_id = room_function.id\n" +
            " where room.floor_id = ?1 order by room.id desc ", nativeQuery = true)
    List<ViewRoom> findRoomsByFloorId(Integer floorId);

    @Query(value = "select room.*, floor.name as name_floor, room_function.name as name_function, area.id as area_id, area.name as name_area, cost.name as name_cost, cost.value as value_cost, cost.level as level_cost from room \n" +
            " INNER JOIN cost ON room.cost_id = cost.id\n" +
            " INNER JOIN floor ON room.floor_id = floor.id\n" +
            " inner join area ON floor.area_id = area.id\n" +
            " INNER JOIN room_function on room.function_id = room_function.id\n" +
            " where floor.area_id = ?1 order by room.id desc", nativeQuery = true)
    List<ViewRoom> findRoomsByAreaId(Integer id);


    @Query(value = "select room.*, floor.name as name_floor, room_function.name as name_function, area.id as area_id, area.name as name_area, cost.name as name_cost, cost.value as value_cost, cost.level as level_cost from room \n" +
            " INNER JOIN cost ON room.cost_id = cost.id\n" +
            " INNER JOIN floor ON room.floor_id = floor.id\n" +
            " inner join area ON floor.area_id = area.id\n" +
            " INNER JOIN room_function on room.function_id = room_function.id\n" +
            " where room.id = ?1 order by room.id desc", nativeQuery = true)
    ViewRoom findViewRoomById(Integer id);

}
