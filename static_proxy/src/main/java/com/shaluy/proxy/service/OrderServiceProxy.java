package com.shaluy.proxy.service;

public class OrderServiceProxy implements OrderService {//代理对象

    private OrderService orderService;

    public OrderServiceProxy() {
    }

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void generate() {
        long star = System.currentTimeMillis();

        orderService.generate();

        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-star)+"ms");
    }

    @Override
    public void modify() {
        long star = System.currentTimeMillis();

        orderService.modify();

        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-star)+"ms");
    }

    @Override
    public void detail() {
        long star = System.currentTimeMillis();

        orderService.detail();

        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-star)+"ms");
    }
}
