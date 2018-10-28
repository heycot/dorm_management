package com.example.dorm_management.services;

import com.example.dorm_management.entities.User;
import com.example.dorm_management.entities.Action;
import com.example.dorm_management.entities.Group;
import com.example.dorm_management.respositories.UserRepository;
import com.example.dorm_management.respositories.ActionRepository;
import com.example.dorm_management.respositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ActionRepository actionRepository;

    @Override
    public List<User> findUserByRoomId(Integer roomId) {
        return userRepository.findUserByRoomId(roomId);
    }

    @Override
    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public boolean isExistedUserByNameAndPassword(String name, String password){
        try{
            List<User> users = userRepository.findUserByUserNameAndPassword(name, password);
            if(users.size() > 0){
                return  true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean isExistedUser(String name) {
        try{
            List<User>  users = userRepository.findUserByUserName(name);
            if(users.size() > 0) return true;
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean saveAccount(User user){
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteAccount(Integer id){
        try{
            userRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Group> findGroupByUserId(Integer id) {
        List<Group> groups = userRepository.findGroupByUserId(id);
        if(groups.size() > 0){
            return groups;
        }
        return null;
    }

    @Override
    public boolean addGroup(Group group) {
        if(group != null){
            groupRepository.save(group);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGroup(Integer id) {
        if(id == null) return false;
        try{
            groupRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }


    }

    @Override
    public boolean updateGroup(Integer id, Group group) {
        try{
            Group targetGroup = groupRepository.findOne(id);
            if(targetGroup == null) return false;
            targetGroup.setName(group.getName());
            groupRepository.save(targetGroup);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean addAction(Action action) {
        if(action == null) return false;
        try{
            actionRepository.save(action);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteAction(Integer id) {
        try{
            actionRepository.delete(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateAction(Integer id, Action action) {
        if(action == null) return false;
        try{
            Action targetAction = actionRepository.findOne(id);
            if(targetAction == null) return false;
            targetAction.setName(action.getName());
            actionRepository.save(targetAction);
        }catch (Exception e){
            return false;
        }
        return false;
    }

}