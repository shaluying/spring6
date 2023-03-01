package com.shaluy.spring6.dao;

import com.shaluy.spring6.pojo.Account;

/**
 * 专门负责账户信息的CRUD操作。
 * DAO中只执行SQL语句，没有任何业务逻辑。
 * 也就是说DAO不和业务挂钩。
 *
 * @author 动力节点
 * @version 1.0
 * @className AccountDao
 * @since 1.0
 **/
public interface AccountDao {

    /**
     * 根据账号查询账户信息
     *
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息。
     *
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 保存账户信息
     * @param account 要保存的账户
     * @return
     */
    int insert(Account account);
}
