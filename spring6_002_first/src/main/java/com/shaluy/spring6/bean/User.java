package com.shaluy.spring6.bean;

public class User {

    // Spring是怎么实例化对象的？
    // 默认情况下Spring会通过反射机制，调用类的无参数构造方法来实例化对象。
    // 实现原理如下：
    // Class clazz = Class.forName("com.shaluy.spring6.bean.User");
    // Object obj = clazz.newInstance();
    public User(){
        System.out.println("User的无参构造执行");
    }

}
