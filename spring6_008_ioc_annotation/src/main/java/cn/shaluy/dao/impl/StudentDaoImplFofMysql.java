package cn.shaluy.dao.impl;

import cn.shaluy.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplFofMysql")
public class StudentDaoImplFofMysql implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除学生信息...");
    }
}
