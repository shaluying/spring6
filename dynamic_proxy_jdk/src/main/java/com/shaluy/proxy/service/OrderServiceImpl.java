package com.shaluy.proxy.service;

public class OrderServiceImpl implements OrderService {// 目标对象

    @Override
    public void generate() { // 目标方法
        try {// 模拟生成订单的耗时
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成.");
    }

    @Override
    public void modify() { // 目标方法
        try { // 模拟修改订单的耗时
            Thread.sleep(456);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改.");
    }

    @Override
    public void detail() { // 目标方法
        try {// 模拟查询订单的耗时
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请看订单详情.");
    }

    @Override
    public String getName() {
        System.out.println("getName()方法执行了");
        return "张三";
    }
}
