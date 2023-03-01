package cn.shaluy.dao.impl;

import cn.shaluy.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplForOracle")
public class StudentDaoImplForOracle implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle数据库正在删除学生信息...");
    }
}
