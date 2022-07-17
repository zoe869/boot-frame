package com.zhong.controller;

import com.zhong.entity.User;
import com.zhong.exception.SysException;
import com.zhong.service.UserService;
import com.zhong.utils.SysResult;
import com.zhong.utils.SysResultHandler;
import org.apache.log4j.Logger;
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
@RequestMapping("/user")
@RestController
public class UserController {


    @Autowired
    private UserService userService;



    @GetMapping("/{userId}")
    public SysResult findById(@PathVariable("userId") Integer adminId){
        System.out.println("根据ID查找");
        return SysResultHandler.success(userService.findByUid(adminId));
    }

    @DeleteMapping("/{userId}")
    public SysResult deleteById(@PathVariable("userId") Integer id){
        System.out.println("deleteById");
        userService.deleteByUid(id);
        return SysResultHandler.success();
    }

    @PutMapping("/{userId}")
    public SysResult update(@PathVariable("userId") Integer userId,@RequestBody User user){
        User res = userService.findByUid(userId);
        if (res == null) {
            return SysResultHandler.buildSysResult(404,"not user with id :"+userId,null);
        }
        return SysResultHandler.success(userService.update(user));
    }

    @PostMapping
    public SysResult add(@RequestBody User user){
        return SysResultHandler.success(userService.save(user));
    }


}




