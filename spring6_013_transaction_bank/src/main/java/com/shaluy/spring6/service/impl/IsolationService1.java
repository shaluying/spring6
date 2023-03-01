package com.shaluy.spring6.service.impl;

import com.shaluy.spring6.dao.AccountDao;
import com.shaluy.spring6.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IsolationService1 {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    // 1号
    // 负责查询
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)//读未提交（当前事务可以读取到别的事务没有提交的数据。）
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)//读已提交(对方事务提交之后的数据我才能读取到。)
    /*将当前事务设置为只读事务，在该事务执行过程中只允许select语句执行，delete insert update均不可执
    行。该特性的作用是：启动spring的优化策略。提高select语句执行效率。*/
    public Account getByActno(String actno){
        Account account = accountDao.selectByActno(actno);

        return account;
    }
}
