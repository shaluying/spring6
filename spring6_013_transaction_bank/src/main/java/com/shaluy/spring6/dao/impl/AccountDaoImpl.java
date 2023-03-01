package com.shaluy.spring6.dao.impl;

import com.shaluy.spring6.dao.AccountDao;
import com.shaluy.spring6.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select * from t_act where actno = ?";

        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);

        return account;
    }

    @Override
    public int update(Account account) {
        String sql = "update t_act set balance = ? where actno = ?";

        int count = jdbcTemplate.update(sql, account.getBalance(), account.getActno());

        return count;
    }

    @Override
    public int insert(Account account) {
        String sql = "insert into t_act values(?,?)";

        int count = jdbcTemplate.update(sql, account.getActno(), account.getBalance());

        return count;
    }
}
