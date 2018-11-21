package com.example.dorm_management.services;

import com.example.dorm_management.entities.RentRoom;
import com.example.dorm_management.respositories.RentRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentRoomServiceImpl implements RentRoomService {

    @Autowired
    private RentRoomRepository rentRoomRepository;

    @Override
    public RentRoom findOneByUserId(Integer userId, Integer status) {
        return rentRoomRepository.findOneByUserId(userId, status);
    }

    @Override
    public RentRoom addOne(RentRoom rentRoom) {
        return rentRoomRepository.save(rentRoom);
    }

    @Override
    public boolean changeStatus(RentRoom rentRoom, Integer status){
        try {
            if (status != RentRoom.RENT_ROOM_STATUS_ENABLE) {
                status = RentRoom.RENT_ROOM_STATUS_DISABLE;
            }
            RentRoom rentRoomEdit = rentRoomRepository.findOne(rentRoom.getId());

            rentRoomEdit.setStatus(status);

            rentRoomRepository.save(rentRoomEdit);

            return true;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }
    }
}
