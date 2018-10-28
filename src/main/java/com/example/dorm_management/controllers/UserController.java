package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.*;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.Utility;
import com.example.dorm_management.respositories.StudentCodeRepository;
import com.example.dorm_management.respositories.UserRepository;
import com.example.dorm_management.respositories.RoomRepository;
import com.example.dorm_management.services.UserService;
import com.example.dorm_management.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public final  static String BASE_URL = "/api/user";

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
        User user = userService.findUserById(10);
        user.setUserDetail(new UserDetail("123", "asd", "sadfdf", user.getId()));
        userService.saveUser(user);

        return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "", user);
    }

    @GetMapping
    public JsonResponse getAllUsers(){
        List<User> users = userService.findAllUser();
        return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "", users);
    }

    @PostMapping("/login}")
    public JsonResponse checkLogin(@RequestBody Account account){
        try{
            boolean b = userService.isExistedUserByNameAndPassword(account.getUserName(), account.getPassword());
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "Login sucess", b);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NO, "User not exist!", b);
        }catch (Exception e){
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

    @PostMapping("/add_user_detail")
    public JsonResponse addUserDetailById(@RequestBody UserDetail userDetail){
        try{
            if(userDetail != null){
                userDetailService.save(1, userDetail);
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", userDetail);
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @PostMapping("/register")
    public JsonResponse addUser(@RequestBody User user){
        try{
            if(userService.isExistedUser(user.getUserName())){
                return Utility.convertObjectToJSON(API.CODE_API_EXISTED, "Da ton tai user");
            }
            if(userService.saveUser(user)){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "Them thanh cong", user);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NO, "Them khong thanh cong");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @GetMapping("/delete_user/{id}")
    public JsonResponse deleteUser(@PathVariable(value = "id") Integer id){
        try{
            if(userService.deleteUser(id)){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "Xoa thanh cong");
            }
            return Utility.convertObjectToJSON(API.CODE_API_NO, "Xoa khong thanh cong");
        }catch (Exception e){
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

    @PostMapping("/edit_user")
    public JsonResponse editUser(@RequestBody User user){
        try{
            User user1 = userService.findUserById(user.getId());
            if(user1 != null){
                userService.editUser(user);
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", user);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay user");
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
            List<Group> groups = userService.findGroupByUserId(id);
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
                return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
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
                return Utility.convertObjectToJSON(API.CODE_API_DEL_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
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
            List<Action> actions = userService.findActionByUserId(id);
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
            boolean b = userService.addAction(action);
            if(b){
                return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
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
                return Utility.convertObjectToJSON(API.CODE_API_DEL_SUCCESS, "");
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_NO, "");
            }
        }catch (Exception e){
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
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NO, "Lỗi format id room");

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
