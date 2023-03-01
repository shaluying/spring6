package org.shaluy.service;

import org.shaluy.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    // @Autowired注解使用的时候，不需要指定任何属性，直接使用这个注解即可。
    // 这个注解的作用是根据类型byType进行自动装配。
    //注意：仅可使用与OrderDao接口下只有一个实现类
//    @Autowired
//    private OrderDao orderDao;

    // 如果想解决接口下有多个实现类问题，只能根据名字进行装配。
    // @Autowired和@Qualifier联合使用，可以根据名字进行装配。
//    @Autowired
//    @Qualifier("orderDaoFaoOracle")
    private OrderDao orderDao;

    // @Autowired和@Qualifier 还可以使用在set方法上
    @Autowired
    @Qualifier("orderDaoFaoOracle")
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    // @Autowired 可以使用在构造方法上 @Qualifier不行
//    @Autowired
//    public OrderService(OrderDao orderDao) {
//        this.orderDao = orderDao;
//    }

    public void generate(){
        orderDao.insert();
    }
}
