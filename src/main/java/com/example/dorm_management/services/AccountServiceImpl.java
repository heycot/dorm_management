package com.example.dorm_management.services;

import com.example.dorm_management.entities.Account;
import com.example.dorm_management.respositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findUserByRoomId(Integer roomId) {
        return accountRepository.findUserByRoomId(roomId);
    }

    @Override
    public Account findUserById(Integer id) {
        return accountRepository.findUserById(id);
    }
}
