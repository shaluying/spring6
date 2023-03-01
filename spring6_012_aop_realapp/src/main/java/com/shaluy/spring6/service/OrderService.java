package com.shaluy.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {// 目标对象

    // 目标方法
    // 生成订单的业务方法
    public void generate(){
        System.out.println("生成了一个新的订单");
    }

    // 目标方法
    // 取消订单的业务方法
    public void cancle(){
        System.out.println("一个订单被取消");

        int i = 10/0; //模拟异常
    }
}
