package com.example.dorm_management.services;

import com.example.dorm_management.entities.User;
import com.example.dorm_management.entities.Action;
import com.example.dorm_management.entities.Group;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> findUserByRoomId(Integer roomId);
    List<User> findAllUser();
    User findUserById(Integer id);
    boolean isExistedUserByNameAndPassword(String name, String password);
    boolean isExistedUser(String name);
    boolean saveAccount(User user);
    boolean deleteAccount(Integer id);
    List<Group> findGroupByUserId(Integer id);
    //group
    boolean addGroup(Group group);
    boolean deleteGroup(Integer id);
    boolean updateGroup(Integer id, Group group);
    //action
    boolean addAction(Action action);
    boolean deleteAction(Integer id);
    boolean updateAction(Integer id, Action action);


}
