package com.shaluy.spring6.service;

import com.shaluy.spring6.dao.UserDao;
import com.shaluy.spring6.dao.VipDao;

public class UserService {
    private UserDao userDao;
    private VipDao vipDao;

    // set注入的话，必须提供一个set方法。
    // Spring容器会调用这个set方法，来给userDao属性赋值。
    // 我自己写一个set方法，不使用IDEA工具生成的。不符合javabean规范。
    // 至少这个方法是以set单词开始的。前三个字母不能随便写，必须是“set"
    /*public void setMySQLUserDao(UserDao xyz){
        this.userDao = xyz;
    }*/

    // 这个set方法是IDEA工具生成的，符合javabean规范。
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void saveUser(){
        userDao.insert();
    }

    public void saveVip(){
        vipDao.insert();
    }
}
