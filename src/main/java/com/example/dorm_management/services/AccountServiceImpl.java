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

    @Override
    public boolean checkUserByNameAndPassword(String name, String password){
        try{
            Account account = accountRepository.findByUserNameAndPassword(name, password);
            if(account != null){
                return  true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean saveAccount(Account account){
        try {
            accountRepository.save(account);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteAccount(Integer id){
        try{
            accountRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}