package com.example.dorm_management.services;

import com.example.dorm_management.DTO.*;
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
    User findUserByUserName(String name);
    boolean isExistedUserByNameAndPassword(String name, String password);
    JsonResponse changePassword(String name, String oldPassword, String newPassword);
    JsonResponse resetPassword(String name, String newPassword);
    boolean isExistedUser(String name);
    boolean saveUser(User user);
    boolean deleteUser(Integer id);
    boolean editUser(User user);
    boolean changeStatusUser(Integer id, Integer status);
    JsonResponse registerUser(RegisterStudentUserDTO registerStudentDTO);
    JsonResponse registerUser(RegisterUserDTO registerUserDTO, Integer idGroup);
    //group
    List<GroupResult> findGroupByUserId(Integer id);

    List<Group> findAllGroup();
    boolean addGroup(Group group);
    boolean deleteGroup(Integer id);
    boolean updateGroup(Integer id, Group group);
    //action

    List<ActionResult> findActionByUserId(Integer id);
    List<ActionResult> findActionByUserName(String name);
    List<ActionResult> findActionByGroupId(Integer idGroup);
    List<Action> findAllAction();
    boolean addAction(Action action);
    boolean deleteAction(Integer id);
    boolean updateAction(Integer id, Action action);

    List<User> findUserByFloorId(Integer id);

    List<User> findUserByAreaId(Integer id);

    User isExistedUserByStudentCodeAndPassword(String studentCode, String password);

    List<User> getUsersByGroupId(Integer idGroup);

    boolean changeGroupByIdUser(Integer idUser, Integer idGroup);

    boolean updateUser(Integer uId, UpdateUserDTO updateUserDTO);

}
