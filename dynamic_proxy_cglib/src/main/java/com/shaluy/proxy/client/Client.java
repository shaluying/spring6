package com.shaluy.proxy.client;

import com.shaluy.proxy.service.TimeMethodInterceptor;
import com.shaluy.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        // 创建字节码增强器对象
        Enhancer enhancer = new Enhancer();// 这个对象是CGLIB库当中的核心对象，就是依靠它来生成代理类。

        // 告诉CGLIB父类是谁。(告诉CGLIB目标类是谁)
        enhancer.setSuperclass(UserService.class);

        //设置回调
        enhancer.setCallback(new TimeMethodInterceptor());

        // 创建代理对象
        // 这一步会做两件事：
        // 第一件事：在内存中生成UserService类的子类，其实就是代理类的字节码。
        // 第二件事：创建代理对象。
        // 父类是UserService，子类这个代理类一定是UserService
        UserService userServiceProxy = (UserService) enhancer.create();

        boolean success = userServiceProxy.login("admin", "123");
        System.out.println(success ? "登录成功":"登录失败");

        userServiceProxy.logout();
    }
}
