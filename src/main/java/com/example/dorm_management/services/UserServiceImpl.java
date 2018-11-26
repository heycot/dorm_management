package com.example.dorm_management.services;

import com.example.dorm_management.DTO.ActionResult;
import com.example.dorm_management.DTO.GroupResult;
import com.example.dorm_management.DTO.RegisterStudentUserDTO;
import com.example.dorm_management.DTO.RegisterUserDTO;
import com.example.dorm_management.config.Basej4Logger;
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
    private RoleUserRepository roleUserRepository;

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
            User users = userRepository.findUserByUserNameAndPassword(name, MD5Utility.encode(password));
            if(users != null){
                return  true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public JsonResponse changePassword(String name, String oldPassword, String newPassword) {
        try{
            User user = userRepository.findUserByUserNameAndPassword(name, MD5Utility.encode(oldPassword));
            if(user == null){
                user = userRepository.getUserByStudentCodeAndPassword(name, MD5Utility.encode(oldPassword));
            }
            if(user == null){
                return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "user not exists", name);
            }
            user.setPassword(MD5Utility.encode(newPassword));
            userRepository.save(user);
            return Utility.convertObjectToJSON(API.CODE_API_YES, "change successfully", name);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, "change user error", e.getStackTrace());
        }
    }

    @Override
    public JsonResponse resetPassword(String name, String newPassword) {
        try{
            User user = userRepository.findUserByUserName(name);
            if(user == null){
                user = userRepository.getUserByStudentCode(name);
            }
            if(user == null){
                return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "user not exists", name);
            }
            user.setPassword(MD5Utility.encode(newPassword));
            userRepository.save(user);
            return Utility.convertObjectToJSON(API.CODE_API_YES, "reset pass successfully", name);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, "reset pass user error", e.getStackTrace());
        }
    }

    @Override
    public boolean isExistedUser(String name) {
        try{
            User  user = userRepository.findUserByUserName(name);
            if(user != null){
                return true;
            }
            user = userRepository.getUserByStudentCode(name);
            if(user != null){
                return true;
            }
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
    public boolean changeStatusUser(Integer id, Integer status) {
        try{
            User user = userRepository.findUserById(id);
            if(user == null){
                return false;
            }
            user.setStatus(EnumStatusUser.byCode(status));
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public JsonResponse registerUser(RegisterStudentUserDTO registerStudentDTO) {
        try {
            synchronized (this){
                if(!isExistedUser(registerStudentDTO.getUserName())){
                    User user = new User();
                    user.setStatus(EnumStatusUser.ACTIVE);
                    user.setUserName(registerStudentDTO.getUserName());
                    user.setPassword(MD5Utility.encode(registerStudentDTO.getPassword()));
                    user.setGender(registerStudentDTO.getGender());
                    Group group1 = groupRepository.getOne(EnumGroup.STUDENT.getCode());
                    user.setGroup(group1);
                    group1.addUser(user);
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
                    groupRepository.save(group1);
                    Basej4Logger.getInstance().info("API: " + API.CODE_API_YES, "register user successfully", registerStudentDTO.getUserName());
                    return Utility.convertObjectToJSON(API.CODE_API_YES, "thanh cong", user);
                }else{
                    Basej4Logger.getInstance().info("API: " + API.CODE_API_EXISTED, "register user fail user da ton tai", registerStudentDTO.getUserName());
                    return Utility.convertObjectToJSON(API.CODE_API_EXISTED, "user name da ton tai");
                }
            }

        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "register user fail fail", registerStudentDTO.getUserName());
            return Utility.convertObjectToJSON(API.CODE_API_NO, "error");
        }
    }

    @Override
    public JsonResponse registerUser(RegisterUserDTO registerUserDTO, Integer idGroup) {
        try {
            synchronized (this){
                if(!isExistedUser(registerUserDTO.getUserName())){
                    User user = new User();
                    user.setStatus(EnumStatusUser.ACTIVE);
                    user.setUserName(registerUserDTO.getUserName());
                    user.setPassword(MD5Utility.encode(registerUserDTO.getPassword()));
                    user.setGender(registerUserDTO.getGender());
                    if(idGroup == EnumGroup.STUDENT.getCode()){
                        return Utility.convertObjectToJSON(API.CODE_API_NO, "id group sai");
                    }
                    Group group1 = groupRepository.getOne(idGroup);
                    if(group1 == null){
                        return Utility.convertObjectToJSON(API.CODE_API_NO, "khong ton tai group");
                    }
                    user.setGroup(group1);
                    group1.addUser(user);
                    //tìm role theo group
                    List<Role> roles = roleService.findAllRoleByGroupId(idGroup);
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
                    groupRepository.save(group1);
                    return Utility.convertObjectToJSON(API.CODE_API_YES, "thanh cong", user);
                }else{
                    return Utility.convertObjectToJSON(API.CODE_API_EXISTED, "user name da ton tai");
                }
            }

        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, "error", e.getStackTrace());
        }
    }

    @Override
    public List<GroupResult> findGroupByUserId(Integer id) {
        List<GroupResult> groups = userRepository.findGroupByUserId(id);
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
    public List<ActionResult> findActionByUserId(Integer id) {
        List<ActionResult> actions = userRepository.findActionByUserId(id);
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

    @Override
    public List<User> findUserByFloorId(Integer id) {
        return userRepository.findUserByFloorId(id);
    }

    @Override
    public List<User> findUserByAreaId(Integer id) {
        return userRepository.findUserByAreaId(id);
    }

    @Override
    public User isExistedUserByStudentCodeAndPassword(String studentCode, String password) {
        return userRepository.getUserByStudentCodeAndPassword(studentCode, password);
    }

    @Override
    public List<User> getUsersByGroupId(Integer idGroup) {
        try{
//            List<User> users = userRepository.getUsersByGroupId(idGroup);
            List<User> users = groupRepository.findOne(idGroup).getUsers();
            if(users.size() <= 0)
                return null;
            return users;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean changeGroupByIdUser(Integer idUser, Integer idGroup) {
        try{
            User user = userRepository.findOne(idUser);
            if(user == null) return false;
            Group group = groupRepository.findOne(idGroup);
            Group oldGroup = groupRepository.findOne(user.getGroup().getId());
            if(idGroup == null) return false;
            user.setGroup(group);
            // xoa role user cu
            List<RoleUser> roleUsers1 = user.getRoleUsers();
            for(RoleUser roleUser : roleUsers1){
                roleUserRepository.delete(roleUser);
            }
            //tìm role theo group
            List<Role> roles = roleService.findAllRoleByGroupId(idGroup);
            List<RoleUser> roleUsers = new ArrayList<>();
            for(Role role : roles){
                RoleUser roleUser = new RoleUser();
                roleUser.setStatus(EnumStatusUser.ACTIVE.getCode());
                roleUser.setUser(user);
                roleUser.setRoleId(role.getId());
                roleUsers.add(roleUser);
            }
            user.setRoleUsers(roleUsers);
            oldGroup.getUsers().remove(user);

            group.addUser(user);
            userRepository.save(user);
            groupRepository.save(group);
            groupRepository.save(oldGroup);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}