package org.shaluy.dao.impl;

import org.shaluy.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoFaoOracle implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Oracle数据库正在保存用户信息...");
    }
}
