package com.shaluy.spring6.service.impl;

import com.shaluy.spring6.dao.AccountDao;
import com.shaluy.spring6.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class IsolationService2 {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    // 2号
    // 负责insert
//    @Transactional(timeout = 10)//设置事务超时时间为10s
    //表示超过10秒如果该事务中所有的DML语句还没有执行完毕的话，最终结果会选择回滚
//    @Transactional(rollbackFor = RuntimeException.class)//表示只有发生RuntimeException异常或该异常的子类异常才回滚。
    @Transactional(noRollbackFor = NullPointerException.class)//表示发生NullPointerException或该异常的子类异常不回滚，其他异常则回滚。
    public int save(Account account) throws IOException {
        /*//睡眠一会
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        int count = accountDao.insert(account);

        //模拟异常
        if (1== 1){
//            throw new IOException();
//            throw new NullPointerException();
            throw new RuntimeException();
        }

        /*//睡眠一会
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return count;
    }
}
