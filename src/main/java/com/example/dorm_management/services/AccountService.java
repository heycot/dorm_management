package com.example.dorm_management.services;

import com.example.dorm_management.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    List<Account> findUserByRoomId(Integer roomId);
    Account findUserById(Integer id);
}
