package com.shaluy.spring6.service;

import com.shaluy.spring6.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "orderDao=" + orderDao +
                '}';
    }

    public void generate(){
        orderDao.insert();
    }

}
