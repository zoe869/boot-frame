package com.zhong.controller;

import com.zhong.entity.User;
import com.zhong.service.UserService;
import com.zhong.utils.SysResult;
import com.zhong.utils.SysResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {


    @Autowired
    private UserService userService;

    @GetMapping("/admins")
    public SysResult findAll(){
        System.out.println("查询全部");
        return SysResultHandler.success(userService.findAll());
    }

    @GetMapping("/admin/{userId}")
    public SysResult findById(@PathVariable("userId") Integer adminId){
        System.out.println("根据ID查找");
        return SysResultHandler.success(userService.findByUid(adminId));
    }

    @DeleteMapping("/admin/{userId}")
    public SysResult deleteById(@PathVariable("userId") Integer id){
        System.out.println("deleteById");
        userService.deleteByUid(id);
        return SysResultHandler.success();
    }

    @PutMapping("/admin/{userId}")
    public SysResult update(@PathVariable("userId") Integer userId,@RequestBody User user){
        User res = userService.findByUid(userId);
        if (res == null) {
            return SysResultHandler.buildSysResult(404,"not user with id :"+userId,null);
        }
        return SysResultHandler.success(userService.update(user));
    }

    @PostMapping("/admin")
    public SysResult add(@RequestBody User user){
        userService.save(user);
        return SysResultHandler.success();
    }

}
