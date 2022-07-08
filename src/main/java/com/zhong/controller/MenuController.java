package com.zhong.controller;


import com.zhong.entity.Menu;
import com.zhong.entity.User;
import com.zhong.service.MenuService;
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
@RequestMapping("/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/admins")
    public SysResult findAll(){
        System.out.println("查询全部");
        return SysResultHandler.success(menuService.findAll());
    }

    @GetMapping("/admin/{menuId}")
    public SysResult findById(@PathVariable("menuId") Integer menuId){
        System.out.println("根据ID查找");
        return SysResultHandler.success(menuService.findById(menuId));
    }

    @DeleteMapping("/admin/{menuId}")
    public SysResult deleteById(@PathVariable("menuId") Integer id){
        System.out.println("deleteById");
        menuService.deleteById(id);
        return SysResultHandler.success();
    }

    @PutMapping("/admin/{userId}")
    public SysResult update(@PathVariable("userId") Integer userId,@RequestBody Menu menu){
        Menu res = menuService.findById(userId);
        if (res == null) {
            return SysResultHandler.buildSysResult(404,"not user with id :"+userId,null);
        }
        return SysResultHandler.success(menuService.update(menu));
    }

    @PostMapping("/admin")
    public SysResult add(@RequestBody Menu menu){
        return SysResultHandler.success(menuService.save(menu));
    }

}
