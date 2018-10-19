package com.example.dorm_management.services;

import com.example.dorm_management.entities.RegisterRoom;
import com.example.dorm_management.respositories.RegisterRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterRoomServiceImpl implements RegisterRoomService {

    @Autowired
    private RegisterRoomRepository registerRoomRepository;

    @Override
    public RegisterRoom findOneById(Integer id) {
        return registerRoomRepository.findOneById(id);
    }

    @Override
    public List<RegisterRoom> findAllByRoomId(Integer roomId) {
        return registerRoomRepository.findAllByRoomId(roomId);
    }

    @Override
    public RegisterRoom addOne(RegisterRoom registerRoom) {
        return registerRoomRepository.save(registerRoom);
    }

    @Override
    public RegisterRoom edditOne(RegisterRoom registerRoom, Integer id) {
        try {

            RegisterRoom registerRoomEdit = registerRoomRepository.findOneById(id);

            registerRoomEdit.setNumber(registerRoom.getNumber());
            registerRoomEdit.setStatus(registerRoom.getStatus());
            registerRoomEdit.setRoomId(registerRoom.getRoomId());
            registerRoomEdit.setSemesterId(registerRoom.getSemesterId());
            registerRoomEdit.setUserId(registerRoom.getUserId());
            registerRoomEdit.setYear(registerRoom.getYear());

            registerRoomRepository.save(registerRoomEdit);
            return  registerRoomEdit;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
