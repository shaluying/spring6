package org.shaluy.dao.impl;

import org.shaluy.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository("orderDaoForMysql")
public class OrderDaoForMysql implements OrderDao  {
    @Override
    public void insert() {
        System.out.println("MySQL数据库正在保存信息...");
    }
}
