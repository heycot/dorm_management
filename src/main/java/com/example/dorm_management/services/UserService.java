package com.example.dorm_management.services;

import com.example.dorm_management.DTO.RegisterUserDTO;
import com.example.dorm_management.entities.User;
import com.example.dorm_management.entities.Action;
import com.example.dorm_management.entities.Group;
import com.example.dorm_management.json.JsonResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> findUserByRoomId(Integer roomId);
    List<User> findAllUser();
    User findUserById(Integer id);
    boolean isExistedUserByNameAndPassword(String name, String password);
    boolean isExistedUser(String name);
    boolean saveUser(User user);
    boolean deleteUser(Integer id);
    boolean editUser(User user);

    JsonResponse registerUser(RegisterUserDTO registerUserDTO);

    //group
    List<Group> findGroupByUserId(Integer id);
    List<Group> findAllGroup();
    boolean addGroup(Group group);
    boolean deleteGroup(Integer id);
    boolean updateGroup(Integer id, Group group);
    //action

    List<Action> findActionByUserId(Integer id);
    List<Action> findAllAction();
    boolean addAction(Action action);
    boolean deleteAction(Integer id);
    boolean updateAction(Integer id, Action action);


}
