package com.shaluy.spring6.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {// 目标类

    public void login(){
        System.out.println("系统正在进行身份验证...");
    }

    public void logout(){
        System.out.println("退出系统...");
    }
}
