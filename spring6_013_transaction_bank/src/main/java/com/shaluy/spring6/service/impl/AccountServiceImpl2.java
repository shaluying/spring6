package com.shaluy.spring6.service.impl;

import com.shaluy.spring6.dao.AccountDao;
import com.shaluy.spring6.pojo.Account;
import com.shaluy.spring6.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl2 implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromAccount, String toAccount, Double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account account) {
        int count = accountDao.insert(account);
        //模拟异常
        String s = null;
        s.toString();

        // 事儿没有处理完，这个大括号当中的后续也许还有其他的DML语句。
    }
}
