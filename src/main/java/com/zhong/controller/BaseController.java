package com.zhong.controller;

import com.wf.captcha.utils.CaptchaUtil;
import com.zhong.entity.Privilege;
import com.zhong.entity.User;
import com.zhong.service.*;
import com.zhong.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class BaseController {

    public static Logger logger1 = Logger.getLogger(BaseController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private PrivilegeService privilegeService;


    @RequestMapping("/register")
    @ResponseBody
    public Result register(User user,HttpServletRequest request,HttpServletResponse response){
        Result res = new Result();
        boolean userIsExisted = userService.userIsExisted(user);
        System.out.println(userIsExisted);
        if(userIsExisted){
            logger1.error("用户名已经存在");
            res=ResultUtil.unSuccess("用户名已经存在");
            return res;
        }
        user.setPassword(MD5Util.md5(user.getPassword()));
        User result = userService.save(user);
        res=ResultUtil.success();
        return res;
    }

    @RequestMapping("/register.html")
    public String toRegister(HttpServletRequest request,HttpServletResponse response){
        logger1.info("注册： result"+"=========");
        return "register";
    }

    @RequestMapping(value = {"/", "login.html"})
    public String toLogin(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        if(session.getAttribute(ConUtils.CURRENT_USERNAME)==null){//没有当前用户
            return "login";
        }else {
            try {
                response.sendRedirect("/pages/index");
            } catch (IOException e) {
                e.printStackTrace();
                return "login";
            }
            return null;
        }

    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public Result getUserInfo(User user, HttpServletRequest request, HttpServletResponse response) {

        if (!CaptchaUtil.ver(user.getVerity(),request)){
            CaptchaUtil.clear(request);  // 清除session中的验证码
            return ResultUtil.unSuccess("验证码错误");
        }

        boolean userIsExisted = userService.userIsExisted(user);
        System.out.println(userIsExisted + " - " + request.getHeader("token"));
        User temp = getUserInfo(user);
        if("client".equals(request.getHeader("token")) || !userIsExisted){
            //用户不存在
            return ResultUtil.unSuccess("用户不存在");
        }
        if (userIsExisted && !temp.getPassword().equals(MD5Util.md5(user.getPassword()))){
            return ResultUtil.unSuccess("用户名或密码错误！");
        }else {
            //将用户信息存入session
            user = setSessionUserInfo(temp,request.getSession());
            //将当前用户信息存入cookie
            setCookieUser(request,response);
            return ResultUtil.success("登录成功", user);
        }
    }

    private User getUserInfo(User user) {
        return userService.findByUsername(user.getUsername());
    }

    private User setSessionUserInfo(User user, HttpSession session) {
        List<Privilege> privileges = privilegeService.getPrivilegeByRoleid(user.getRoleId());
        user.setPrivileges(privileges);
        session.setAttribute(ConUtils.CURRENT_USERNAME,user);
        return user;
    }

    // 登录时将用户信息存到Cookie中
    private void setCookieUser(HttpServletRequest request, HttpServletResponse response) {
        User user = getSessionUser(request.getSession());
        Cookie cookie = new Cookie(ConUtils.CURRENT_USERNAME,user.getUsername()+"_"+user.getUserId());
        cookie.setMaxAge(60*60*24*7);   // 设置cookie的有效期为7天
        response.addCookie(cookie);
    }

    @RequestMapping("/getSessionUser")
    @ResponseBody
    private User getSessionUser(HttpSession session) {
        User userInfo = (User) session.getAttribute(ConUtils.CURRENT_USERNAME);
        userInfo.setPassword(null);
        return userInfo;
    }
}
