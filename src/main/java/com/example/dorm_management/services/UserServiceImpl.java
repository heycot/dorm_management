package com.example.dorm_management.services;

import com.example.dorm_management.DTO.RegisterStudentUserDTO;
import com.example.dorm_management.DTO.RegisterUserDTO;
import com.example.dorm_management.entities.*;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.*;
import com.example.dorm_management.respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private StudentCodeRepository studentCodeRepository;

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
    public boolean saveUser(User user){
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteUser(Integer id){
        try{
            userRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editUser(User user) {
        try{
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public JsonResponse registerUser(RegisterStudentUserDTO registerStudentDTO) {
        try {
            if(!isExistedUser(registerStudentDTO.getUserName())){
                User user = new User();
                user.setStatus(EnumStatusUser.ACTIVE);
                user.setUserName(registerStudentDTO.getUserName());
                user.setPassword(registerStudentDTO.getPassword());
                user.setGender(registerStudentDTO.getGender());
                //tìm role theo group
                List<Role> roles = roleService.findAllRoleByGroupId(EnumGroup.STUDENT.getCode());
                List<RoleUser> roleUsers = new ArrayList<>();
                for(Role role : roles){
                    RoleUser roleUser = new RoleUser();
                    roleUser.setStatus(EnumStatusUser.ACTIVE.getCode());
                    roleUser.setUser(user);
                    roleUser.setRoleId(role.getId());
                    roleUsers.add(roleUser);
                }
                user.setRoleUsers(roleUsers);
                //
                UserDetail userDetail = new UserDetail(
                        registerStudentDTO.getPhone(),
                        registerStudentDTO.getAddress(),
                        registerStudentDTO.getFullName(),
                        user.getId());

                StudentCode studentCode = new StudentCode(
                        registerStudentDTO.getNameClass(),
                        Utility.getEndSchoolYearByMSSV(registerStudentDTO.getMssv()),
                        registerStudentDTO.getMssv(), user.getId());

                user.setUserDetail(userDetail);
                user.setStudentCode(studentCode);
                userDetail.setUser(user);
                studentCode.setUser(user);

                userRepository.save(user);
                return Utility.convertObjectToJSON(API.CODE_API_YES, "thanh cong", user);
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_EXISTED, "user name da ton tai");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, "error");
        }
    }

    @Override
    public JsonResponse registerUser(RegisterUserDTO registerUserDTO) {
        try {
            if(!isExistedUser(registerUserDTO.getUserName())){
                User user = new User();
                user.setStatus(EnumStatusUser.ACTIVE);
                user.setUserName(registerUserDTO.getUserName());
                user.setPassword(registerUserDTO.getPassword());
                user.setGender(registerUserDTO.getGender());
                //tìm role theo group
                List<Role> roles = roleService.findAllRoleByGroupId(EnumGroup.STAFF.getCode());
                List<RoleUser> roleUsers = new ArrayList<>();
                for(Role role : roles){
                    RoleUser roleUser = new RoleUser();
                    roleUser.setStatus(EnumStatusUser.ACTIVE.getCode());
                    roleUser.setUser(user);
                    roleUser.setRoleId(role.getId());
                    roleUsers.add(roleUser);
                }
                user.setRoleUsers(roleUsers);
                //
                UserDetail userDetail = new UserDetail(registerUserDTO.getPhone(), registerUserDTO.getAddress(), registerUserDTO.getFullName(), user.getId());
                user.setUserDetail(userDetail);
                userDetail.setUser(user);

                userRepository.save(user);
                return Utility.convertObjectToJSON(API.CODE_API_YES, "thanh cong", user);
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_EXISTED, "user name da ton tai");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, "error");
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
    public List<Group> findAllGroup() {
        List<Group> groups = groupRepository.findAll();
        return groups;
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
    public List<Action> findActionByUserId(Integer id) {
        List<Action> actions = userRepository.findActionByUserId(id);
        if(actions.size() > 0){
            return actions;
        }
        return null;
    }

    @Override
    public List<Action> findAllAction() {
        List<Action> actions = actionRepository.findAll();
        return actions;
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