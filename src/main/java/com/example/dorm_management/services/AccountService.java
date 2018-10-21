package com.example.dorm_management.services;

import com.example.dorm_management.entities.Account;
import com.example.dorm_management.entities.Group;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    List<Account> findUserByRoomId(Integer roomId);
    Account findUserById(Integer id);
    boolean isExistedUserByNameAndPassword(String name, String password);
    boolean saveAccount(Account account);
    boolean deleteAccount(Integer id);

    List<Group> findGroupByUserId(Integer id);

}
