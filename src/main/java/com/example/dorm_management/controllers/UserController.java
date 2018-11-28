package com.example.dorm_management.controllers;

import com.example.dorm_management.DTO.*;
import com.example.dorm_management.config.Basej4Logger;
import com.example.dorm_management.entities.*;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.Utility;
import com.example.dorm_management.respositories.StudentCodeRepository;
import com.example.dorm_management.respositories.UserRepository;
import com.example.dorm_management.respositories.RoomRepository;
import com.example.dorm_management.services.RoleService;
import com.example.dorm_management.services.RoleUserService;
import com.example.dorm_management.services.UserService;
import com.example.dorm_management.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public final  static String BASE_URL = "/api/user";
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserService userService;

    private JsonResponse jsonResponse;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentCodeRepository studentCodeRepository;
    @GetMapping("/generate")
    public JsonResponse generateUser(){
//        User user = new User("vuong", "vuong", 1, 1);
//        userRepository.save(user);
//        StudentCode studentCode = new StudentCode("sadf", "safs", "saf",9);
//        studentCodeRepository.save(studentCode);
        /*StudentCode studentCode = studentCodeRepository.findById(5);
        System.out.println(studentCode.getUser().getUserName());*/
//        User user = new User("vuongpq2", "vuongpq2", 1,2);
//        user.setUserDetail(new UserDetail("sadfsdf", "hue", "phan quang vuong", user.getId()));
//        UserDetail userDetail = new UserDetail("123123", "hue", "phan quang vuong", 9);
//        userDetailService.save(userDetail);
//        User user = userService.findUserById(10);
//        user.setUserDetail(new UserDetail("123", "asd", "sadfdf", user.getId()));
//        userService.saveUser(user);

        List<Role> roles = roleService.findAllRoleByGroupId(1);
        return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "dsfsdf", roles);
    }

    @GetMapping
    public JsonResponse getAllUsers(){
        List<User> users = userService.findAllUser();
        return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "", users);
    }

    @PostMapping("/login")
    public JsonResponse checkLogin(@RequestBody AccountDTO accountDTO){
        try{
            boolean b = userService.isExistedUserByNameAndPassword(accountDTO.getUserName(), accountDTO.getPassword());
            if(b){
                Basej4Logger.getInstance().info("API: " + API.CODE_API_YES, "Login sucess", accountDTO.getUserName());
                return Utility.convertObjectToJSON(API.CODE_API_YES, "Login sucess", b);
            }
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "User not exist!", accountDTO.getUserName());
            return Utility.convertObjectToJSON(API.CODE_API_NO, "User not exist!", b);
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_ERROR, "server error", accountDTO.getUserName());
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, "server error");
        }
    }

    @PostMapping("/student/login")
    public JsonResponse checkLoginWithStudent(@RequestBody AccountDTO accountDTO){
        try{
            User user = userService.isExistedUserByStudentCodeAndPassword(accountDTO.getStudentCode(), accountDTO.getPassword());
            User userRes = userService.findUserById(user.getId());
            if(user != null){
                Basej4Logger.getInstance().info("API: " + API.CODE_API_YES, "Login sucess", accountDTO.getUserName());
                return Utility.convertObjectToJSON(API.CODE_API_YES, "Login sucess", userRes);
            }
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "User not exist!", accountDTO.getUserName());
            return Utility.convertObjectToJSON(API.CODE_API_NO, "User not exist!", false);
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_ERROR, "server error", accountDTO.getUserName());
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, "server error");
        }
    }

    @GetMapping("/get_user_detail/{id}")
    public JsonResponse findUserDetailById(@PathVariable(value = "id") Integer id){

        try{
            UserDetail userDetail = userDetailService.findUserDetailByUserId(id);
            if(userDetail != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", userDetail);
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong duoc tim thay");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }
    @RequestMapping(value = "/{userId}/add_user_detail", method = RequestMethod.POST)
    public JsonResponse addUserDetailById(@RequestBody UserDetail userDetail, @PathVariable(value = "userId") String userId){
        try{
            if(userDetail != null){
                userDetail.setUser(new User(Integer.parseInt(userId)));
                userDetailService.save(userDetail);
                Basej4Logger.getInstance().info("API: " + API.CODE_API_YES, "add user detail successfully", userId);
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", userDetail);
            }else{
                Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "add user detail null", userId);
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "add user detail fail", userId);
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @PostMapping("/register")
    public JsonResponse addUser(@RequestBody RegisterStudentUserDTO registerStudentDTO){
        return userService.registerUser(registerStudentDTO);
    }

    @PostMapping("/change-password")
    public JsonResponse changePassword(@RequestBody ChangePassDTO changePassDTO){
        return userService.changePassword(changePassDTO.getName(), changePassDTO.getOldPassword(), changePassDTO.getNewPassword());
    }
    @PostMapping("/reset-password")
    public JsonResponse resetPassword(@RequestBody ChangePassDTO changePassDTO){
        // neu khong dien mat khau moi vao thi mat khau default la name luon
        if(changePassDTO.getNewPassword() == null)
            changePassDTO.setNewPassword(changePassDTO.getName());
        return userService.resetPassword(changePassDTO.getName(), changePassDTO.getNewPassword());
    }

    @PostMapping("/register-staff/{idGroup}")
    public JsonResponse addStaff(@RequestBody RegisterUserDTO resgisterStaffDTO, @PathVariable(value = "idGroup") Integer idGroup){
        return userService.registerUser(resgisterStaffDTO, idGroup);
    }

    @GetMapping("/get-users-by-groups/{id}")
    public JsonResponse getUsersByGroupId(@PathVariable(value = "id") Integer id){
        try{
            List<User> users = userService.getUsersByGroupId(id);
            return Utility.convertObjectToJSON(API.CODE_API_YES, "users by group", users);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, "users by group error ", id);
        }
    }
    @GetMapping("/change-group-b-user/{idUser}/{idGroup}")
    public JsonResponse changeGroupByUser(@PathVariable(value = "idUser") Integer userId, @PathVariable(value = "idGroup") Integer groupId){
        try{
            boolean b = userService.changeGroupByIdUser(userId, groupId);
            if(!b){
                return Utility.convertObjectToJSON(API.CODE_API_ERROR, "change group by user error", userId);
            }
            return Utility.convertObjectToJSON(API.CODE_API_YES, "change group by user successfully", userId);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, "change group by user error", userId);
        }
    }

    @GetMapping("/is-exist-user/{username}")
    public JsonResponse isExistUser(@PathVariable(value = "username") String userName){
        try{
            boolean b = userService.isExistedUser(userName);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "user name existed", userName);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NO, "user name not existed", userName);
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, "check error", userName);
        }
    }

    @GetMapping("/delete_user/{id}")
    public JsonResponse deleteUser(@PathVariable(value = "id") Integer id){
        try{
            if(userService.deleteUser(id)){
                Basej4Logger.getInstance().info("API: " + API.CODE_API_YES, "delete user success", id);
                return Utility.convertObjectToJSON(API.CODE_API_YES, "Xoa thanh cong");
            }
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "delete user fail", id);
            return Utility.convertObjectToJSON(API.CODE_API_NO, "Xoa khong thanh cong");
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "delete user error", id);
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @GetMapping("/get_user/{id}")
    public JsonResponse findUserById(@PathVariable(value = "id") Integer id){
        try{
            User user = userService.findUserById(id);
            if(user != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", user);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay user");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }
    @GetMapping("/get_user/{username}")
    public JsonResponse findUserByUserName(@PathVariable(value = "username") String name){
        try{
            User user = userService.findUserUserName(name);
            if(user != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", user);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay user");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @PostMapping("/edit_user")
    public JsonResponse editUser(@RequestBody User user){
        try{
            User user1 = userService.findUserById(user.getId());
            if(user1 != null){
                userService.editUser(user);
                Basej4Logger.getInstance().info("API: " + API.CODE_API_YES, "edit user success", user.getId());
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", user);
            }
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NOTFOUND, "edit user fail", user.getId());
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay user");
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "edit user error", user.getId());
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @GetMapping("/change-status/{id}/{status}")
    public JsonResponse changeStatusUser(@PathVariable(value = "id") Integer id, @PathVariable(value = "status") Integer status){
        try{
            if(userService.changeStatusUser(id,status)){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", status);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NO, "error");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @PostMapping("/update-user/{uId}")
    public JsonResponse updateUserDTO(@RequestBody UpdateUserDTO updateUserDTO, @PathVariable(value = "uId") Integer id){
        try{
           boolean b = userService.updateUser(id, updateUserDTO);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "update user sucessfully", updateUserDTO);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NO, "update user error");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    //TODO GROUP

    @GetMapping("/get_group")
    public JsonResponse findAllGroup(){
        try{
            List<Group> groups = userService.findAllGroup();
            if(groups != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", groups);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NO, "");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @GetMapping("/get_group/{id}")
     public JsonResponse findGroupByUserId(@PathVariable(value = "id") Integer id){
        try{
            List<GroupResult> groups = userService.findGroupByUserId(id);
            if(groups != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", groups);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay group");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @PostMapping("/add_group")
    public JsonResponse addGroup(@RequestBody Group group){
        try{
            boolean b = userService.addGroup(group);
            if(b){
                Basej4Logger.getInstance().info("API: " + API.CODE_API_ADD_SUCCESS, "add group success", group.getName());
                return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "");
            }else{
                Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "add group fail", group.getName());
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "add group error", group.getName());
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @PostMapping("/edit_group")
    public JsonResponse editGroup(@RequestBody Group group){
        try{
            boolean b = userService.updateGroup(group.getId(), group);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_EDIT_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, e.getMessage());
        }
    }

    @GetMapping("/delete_group/{id}")
    public JsonResponse deleteGroup(@PathVariable(value = "id") Integer id){
        try{
            boolean b = userService.deleteGroup(id);
            if(b){
                Basej4Logger.getInstance().info("API: " + API.CODE_API_DEL_SUCCESS, "delete group error", id);
                return Utility.convertObjectToJSON(API.CODE_API_DEL_SUCCESS, "");
            }else{
                Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "delete group fail", id);
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "delete group error", id);
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    //TODO action
    @GetMapping("/get_action")
    public JsonResponse findAllActions(){
        try{
            List<Action> actions = userService.findAllAction();
            if(actions != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", actions);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NO, "");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }
    @GetMapping("/get_action/{id}")
    public JsonResponse findActionByUserId(@PathVariable(value = "id") Integer id){
        try{
            List<ActionResult> actions = userService.findActionByUserId(id);
            if(actions != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", actions);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay action");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }
    @GetMapping("/get_action/{username}")
    public JsonResponse findActionByUserId(@PathVariable(value = "id") String username){
        try{
            List<ActionResult> actions = userService.findActionByUserName(username);
            if(actions != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", actions);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay action");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }



    @PostMapping("/add_action")
    public JsonResponse addAction(@RequestBody Action action){
        try{
            boolean b = userService.addAction(new Action(action.getName(), action.getCode()));
            if(b){
                Basej4Logger.getInstance().info("API: " + API.CODE_API_ADD_SUCCESS, "add action success", action.getName());
                return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "");
            }else{
                Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "add action fail", action.getName());
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "add action error", action.getName());
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, e.getMessage());
        }
    }

    @PostMapping("/edit_action")
    public JsonResponse editAction(@RequestBody Action action){
        try{
            boolean b = userService.updateAction(action.getId(), action);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_EDIT_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, e.getMessage());
        }
    }

    @GetMapping("/delete_action/{id}")
    public JsonResponse deleteAction(@PathVariable(value = "id") Integer id){
        try{
            boolean b = userService.deleteAction(id);
            if(b){
                Basej4Logger.getInstance().info("API: " + API.CODE_API_DEL_SUCCESS, "add action error", id);
                return Utility.convertObjectToJSON(API.CODE_API_DEL_SUCCESS, "");
            }else{
                Basej4Logger.getInstance().info("API: " + API.CODE_API_NO, "delete action error", id);
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
            Basej4Logger.getInstance().info("API: " + API.CODE_API_ERROR, "delete action error", id);
            return Utility.convertObjectToJSON(API.CODE_API_ERROR, e.getMessage());
        }
    }
    
    @GetMapping("/room/{id}")
    public JsonResponse findStudentsbyRoomId(@PathVariable(value = "id") Integer id) {
        try{
            Room room = roomRepository.findOne(id);

            if (room == null) {
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_ID_NOTFOUND,
                        "Không có phòng nào có id = " + id);

                return jsonResponse;
            } else {
                List<User> users = userRepository.findUserByRoomId(id);
                if (users.size() > 0) {
                    jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "", users);

                    return jsonResponse;
                } else {
                    jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không tìm thấy dữ liệu");

                    return jsonResponse;
                }
            }
        } catch (Exception e) {
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NO, "error exception");

            return jsonResponse;
        }
    }

    @GetMapping("/floor/{id}")
    public JsonResponse findStudentsbyFloorId(@PathVariable(value = "id") Integer id) {
        try{
            List<User> users = userService.findUserByFloorId(id);
            if (users.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", users);

            } else {
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không tìm thấy dữ liệu");

            }
            return jsonResponse;

        } catch (Exception e) {
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NO, "error exception");

            return jsonResponse;
        }
    }

    @GetMapping("/area/{id}")
    public JsonResponse findStudentsbyAreaId(@PathVariable(value = "id") Integer id) {
        try{
            List<User> users = userService.findUserByAreaId(id);
            if (users.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "success", users);

            } else {
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không tìm thấy dữ liệu");

            }
            return jsonResponse;

        } catch (Exception e) {
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NO, "error exception");

            return jsonResponse;
        }
    }

    public JsonResponse return_No_Object_JsonPresonse(Integer code, String message){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(null);

        return jsonResponse;
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, User user){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(user));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<User> users){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(users));

        return jsonResponse;
    }
}
