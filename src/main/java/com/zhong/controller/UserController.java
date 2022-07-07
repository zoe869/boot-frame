package com.zhong.controller;

import com.zhong.entity.User;
import com.zhong.exception.SysException;
import com.zhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2022-07-05
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }
    @GetMapping("/users/user/{uid}")
    public User getUserByUid(@PathVariable("uid") Integer id){
        return userService.findByUid(id);
    }

    @PostMapping("/users/user")
    public ResponseEntity login(String username,String password){
        User res=userService.findByUsernameAndPassword(username,password);
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @PostMapping("/users/user/account/{uid}")
    public ResponseEntity update(@PathVariable("uid") Integer id, @RequestBody User user){
        User res=userService.findByUid(id);
        if (res == null) {
            throw new SysException("no user with id :"+id);
        }
        userService.save(res);
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @DeleteMapping("/users/user/account/{uid}")
    public ResponseEntity delete(@PathVariable("uid") Integer id, @RequestBody User user){
        User res=userService.findByUid(id);
        if (res == null) {
            throw new SysException("no user with id :"+id);
        }
        userService.save(res);
        return new ResponseEntity(res, HttpStatus.OK);
    }


}




