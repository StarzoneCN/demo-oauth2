package com.example.oauth2.serverclient.controller;

import com.example.oauth2.serverclient.entity.Users;
import com.example.oauth2.serverclient.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 *
 * @author: LiHongxing
 * @email: lihongxing@bluemoon.com.cn
 * @date: Create in 2019/1/7 13:21
 * @modefied:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/{id}")
    public Users getUserInfoById(@PathVariable("id") Integer id){
        return usersService.getById(id);
    }
}
