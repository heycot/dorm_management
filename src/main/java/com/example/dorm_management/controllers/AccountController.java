package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Account;
import com.example.dorm_management.entities.Group;
import com.example.dorm_management.entities.Room;
import com.example.dorm_management.entities.UserDetail;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.libararies.Utility;
import com.example.dorm_management.respositories.AccountRepository;
import com.example.dorm_management.respositories.RoomRepository;
import com.example.dorm_management.services.AccountService;
import com.example.dorm_management.services.UserDetailService;
import com.example.dorm_management.services.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(AccountController.BASE_URL)
public class AccountController {

    public final  static String BASE_URL = "/api/user";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private AccountService accountService;
    private JsonResponse jsonResponse;

    @Autowired
    private RoomRepository roomRepository;

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
    public JsonResponse addUser(@RequestBody Account account){
        try{
            if(accountService.isExistedUserByNameAndPassword(account.getUserName(), account.getPassword())){
                return Utility.convertObjectToJSON(API.CODE_API_EXISTED, "Da ton tai user");
            }
            if(accountService.saveAccount(account)){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "Them thanh cong", account);
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
            Account account = accountService.findUserById(id);
            if(account != null){
                return Utility.convertObjectToJSON(API.CODE_API_YES, "successfully", account);
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
                List<Account> accounts = accountRepository.findUserByRoomId(id);
                if (accounts.size() > 0) {
                    jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "", accounts);

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

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, Account account){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(account));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<Account> accounts){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(accounts));

        return jsonResponse;
    }
}
