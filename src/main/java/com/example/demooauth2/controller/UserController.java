package com.example.demooauth2.controller;

import com.example.demooauth2.entity.User;
import com.example.demooauth2.service.IUserService;
import com.example.demooauth2.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer userId){
        return userService.selectById(userId);
    }

    @GetMapping("name/{name}")
    public UserDetails getByName(@PathVariable("name") String username){
        return new User();
    }
}
