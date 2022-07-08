package com.zhong.controller;

import com.zhong.service.MenuService;
import com.zhong.service.RecordService;
import com.zhong.service.RoleService;
import com.zhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected RoleService roleService;

    @Autowired
    protected RecordService recordService;

    @Autowired
    protected MenuService menuService;
}
