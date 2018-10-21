package com.example.dorm_management.respositories;

import com.example.dorm_management.entities.Room;
import com.example.dorm_management.entities.ViewRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {



}
