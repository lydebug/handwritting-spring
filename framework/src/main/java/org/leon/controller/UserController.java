package org.leon.controller;

import org.leon.annotation.Autowired;
import org.leon.annotation.Controller;
import org.leon.annotation.RequestMapping;
import org.leon.bean.View;
import org.leon.constant.RequestMethod;
import org.leon.entity.User;
import org.leon.service.IUserService;

import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/8/7 20:54
 * @Description:
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 用户列表
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public View getUserList() {
        List<User> userList = userService.getAllUser();
        return new View("index.jsp").addModel("userList", userList);
    }
}

