package cn.shaluy.service;

import cn.shaluy.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

//    @Resource(name = "studentDaoImplFofMysql")
    private StudentDao studentDao;

    @Resource(name = "studentDaoImplForOracle")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    // 不能出现在构造方法上。
    /*@Resource(name = "studentDaoImplForMySQL")
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/

    public void delete(){
        studentDao.deleteById();
    }
}
