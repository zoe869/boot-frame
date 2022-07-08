package com.zhong.controller;

import com.zhong.entity.Role;
import com.zhong.entity.User;
import com.zhong.service.RoleService;
import com.zhong.service.UserService;
import com.zhong.utils.SysResult;
import com.zhong.utils.SysResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2022-07-05
 */
@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;



    @GetMapping("/{roleId}")
    public SysResult findById(@PathVariable("roleId") Integer roleId){
        System.out.println("根据ID查找");
        return SysResultHandler.success(roleService.findById(roleId));
    }

    @DeleteMapping("/{userId}")
    public SysResult deleteById(@PathVariable("roleId") Integer roleId){
        System.out.println("deleteById");
        roleService.deleteById(roleId);
        return SysResultHandler.success();
    }

    @PutMapping("/{userId}")
    public SysResult update(@PathVariable("userId") Integer userId,@RequestBody Role role){
        Role res = roleService.findById(userId);
        if (res == null) {
            return SysResultHandler.buildSysResult(404,"not user with id :"+userId,null);
        }
        return SysResultHandler.success(roleService.update(role));
    }

    @PostMapping
    public SysResult add(@RequestBody Role role){
        return SysResultHandler.success(roleService.save(role));
    }
}
