package com.example.dorm_management.services;

import com.example.dorm_management.entities.RegisterRoom;
import com.example.dorm_management.entities.ViewRegisterRoom;
import com.example.dorm_management.respositories.RegisterRoomRepository;
import com.example.dorm_management.respositories.ViewRegisterRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterRoomServiceImpl implements RegisterRoomService {

    @Autowired
    private RegisterRoomRepository registerRoomRepository;

    @Autowired
    private ViewRegisterRoomRepository viewRegisterRoomRepository;

    @Override
    public RegisterRoom findOneById(Integer id) {
        return registerRoomRepository.findOneById(id);
    }

    @Override
    public List<ViewRegisterRoom> findAllByRoomId(Integer roomId) {
        return viewRegisterRoomRepository.findAllByRoomId(roomId);
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


    @Override
    public RegisterRoom acceptOne(RegisterRoom x){
        try {
            RegisterRoom registerRoom = registerRoomRepository.findOneById(x.getId());

            registerRoom.setStatus(x.getStatus());
            registerRoom.setTimeCensor(x.getTimeCensor());

            RegisterRoom result = registerRoomRepository.save(registerRoom);
            return result;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<ViewRegisterRoom> findAllAcceptedByRoomId(Integer id) {
        return viewRegisterRoomRepository.findAllByRoomIdAndStatus(id, 1);
    }

    @Override
    public List<ViewRegisterRoom> findAllNotAcceptedByRoomId(Integer id) {
        return viewRegisterRoomRepository.findAllByRoomIdAndStatus(id, 0);
    }

    @Override
    public boolean deleteOne(Integer registerId) {
        try {

            registerRoomRepository.delete(registerId);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }

    @Override
    public ViewRegisterRoom getOneViewById(Integer id) {
        return viewRegisterRoomRepository.getOneViewById(id);
    }

    @Override
    public List<ViewRegisterRoom> findAllByAreaId(Integer id) {
        return viewRegisterRoomRepository.findAllByAreaId(id);
    }
}
