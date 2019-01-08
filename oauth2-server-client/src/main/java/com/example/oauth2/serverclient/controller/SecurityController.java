package com.example.oauth2.serverclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LiHongxing
 * @email: lihongxing@bluemoon.com.cn
 * @date: Create in 2019/1/8 13:11
 * @modefied:
 */
@RestController
@RequestMapping("security")
public class SecurityController {

    @GetMapping("code")
    public String showCode(String code){
        return code;
    }
}
