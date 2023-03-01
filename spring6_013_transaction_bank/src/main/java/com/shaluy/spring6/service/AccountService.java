package com.shaluy.spring6.service;

import com.shaluy.spring6.pojo.Account;

/**
 * 业务接口
 * 事务就是在这个接口下控制的。
 * @author 动力节点
 * @version 1.0
 * @className AccountService
 * @since 1.0
 **/
public interface AccountService {

    /**
     * 转账业务方法
     * @param fromAccount 从这个账户转出
     * @param toAccount 转入这个账户
     * @param money 转账金额
     */
    void transfer(String fromAccount, String toAccount, Double money);

    /**
     * 保存账户的业务方法
     * @param account 保存这个账户
     */
    void save(Account account);


}
