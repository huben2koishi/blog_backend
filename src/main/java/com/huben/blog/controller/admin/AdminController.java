package com.huben.blog.controller.admin;

import com.huben.blog.pojo.Result;
import com.huben.blog.pojo.User;
import com.huben.blog.service.UserService;
import com.huben.blog.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author koishi
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "admin/index";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "admin/login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Result checkUser(User user, HttpSession session)  {
        System.out.println("-----------------------------\n"+user);
        if (StringUtil.isEmpty(user.getUsername())
            || StringUtil.isEmpty(user.getPassword())) {
            return Result.error("请输入用户名或密码");
        }

        User checkUser = userService.checkUser(user);
        if (checkUser == null) {
            return Result.error("用户名或密码错误");
        }

        session.setAttribute("user", checkUser);
        return Result.success("登录成功");
    }
}
