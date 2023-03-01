package com.shaluy.spring6.service.impl;

import com.shaluy.spring6.dao.AccountDao;
import com.shaluy.spring6.pojo.Account;
import com.shaluy.spring6.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;
    @Resource(name = "accountServiceImpl2")
    private AccountService accountService;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, Double money) {

        // 第一步：开启事务

        // 第二步：执行核心业务逻辑
        // 查询转出账户的余额是否充足
        Account fromAccount = accountDao.selectByActno(fromActno);
        if (fromAccount.getBalance() < money){
            throw new RuntimeException("余额不足！");
        }

        // 余额充足
        Account toAccount = accountDao.selectByActno(toActno);

        // 将内存中两个对象的余额先修改。
        fromAccount.setBalance(fromAccount.getBalance()-money);
        toAccount.setBalance(toAccount.getBalance()+money);

        // 数据库更新
        int count = accountDao.update(fromAccount);

        //模拟异常
        /*String s = null;
        s.toString();*/

        count += accountDao.update(toAccount);

        if (count != 2){
            throw new RuntimeException("转账异常！请联系银行！");
        }

        // 第三步：如果执行业务流程过程中，没有异常。提交事务
        // 第四步：如果执行业务流程过程中，有异常，回滚事务。
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account account) {
        // 这里调用dao的insert方法。
        int count = accountDao.insert(account);// 保存act-003账户

        // 创建账户对象
        Account account1 = new Account("act-004",50000.0);
        try {
            accountService.save(account1);// 保存act-004账户
        }catch (Exception e){

        }

        // 继续往后进行我当前1号事务自己的事儿。
    }
}
