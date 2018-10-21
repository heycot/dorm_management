package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.*;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.Utility;
import com.example.dorm_management.respositories.UserRepository;
import com.example.dorm_management.respositories.RoomRepository;
import com.example.dorm_management.services.AccountService;
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
    private AccountService accountService;
    private JsonResponse jsonResponse;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/generate")
    public JsonResponse generateUser(){
        User user = new User("vuong", "vuong", 1, new StudentCode("asdf", "asf", "asdf"), 1);
        userRepository.save(user);
        return Utility.convertObjectToJSON(API.CODE_API_ADD_SUCCESS, "", user);
    }

    @GetMapping("/user_detail/{id}")
    public JsonResponse findUserDetailById(@PathVariable(value = "id") Integer id){
        try{
            UserDetail userDetail = userDetailService.findUserDetailByUserId(id);
            if(userDetail != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", userDetail);
            }else{
                return Utility.convertObjectToJSON(API.CODE_API_ID_NOTFOUND, "Khong duoc tim thay");
            }
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @PostMapping("/user/add_user")
    public JsonResponse addUser(@RequestBody User user){
        try{
            if(accountService.isExistedUserByNameAndPassword(user.getUserName(), user.getPassword())){
                return Utility.convertObjectToJSON(API.CODE_API_EXISTED, "Da ton tai user");
            }
            if(accountService.saveAccount(user)){
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
            if(accountService.deleteAccount(id)){
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
            User user = accountService.findUserById(id);
            if(user != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", user);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay user");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
        }
    }

    @GetMapping("/get_group/{id}")
    public JsonResponse findGroupById(@PathVariable(value = "id") Integer id){
        try{
            List<Group> groups = accountService.findGroupByUserId(id);
            if(groups != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", groups);
            }
            return Utility.convertObjectToJSON(API.CODE_API_NOTFOUND, "Khong tim thay group");
        }catch (Exception e){
            return Utility.convertObjectToJSON(API.CODE_API_NO, e.getMessage());
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
