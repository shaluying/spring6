package com.shaluy.proxy.client;

import com.shaluy.proxy.service.OrderService;
import com.shaluy.proxy.service.OrderServiceImpl;
import com.shaluy.proxy.service.OrderServiceImplSub;
import com.shaluy.proxy.service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.modify();
        orderService.detail();
        System.out.println("-----------------");

        OrderService orderService1 = new OrderServiceImplSub();
        orderService1.generate();
        orderService1.modify();
        orderService1.detail();
        System.out.println("---------------------");

        // 创建目标对象
        OrderService orderServiceTemp = new OrderServiceImpl();
        // 创建代理对象
        OrderService orderService2 = new OrderServiceProxy(orderServiceTemp);
        // 调用代理对象的代理方法
        orderService2.generate();
        orderService2.modify();
        orderService2.detail();
    }

}
