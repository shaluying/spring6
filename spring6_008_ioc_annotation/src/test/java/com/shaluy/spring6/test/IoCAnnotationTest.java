package com.shaluy.spring6.test;

import cn.shaluy.Spring6Config;
import cn.shaluy.service.StudentService;
import com.shaluy.spring6.bean.Order;
import com.shaluy.spring6.bean.OrderService;
import com.shaluy.spring6.bean.Student;
import com.shaluy.spring6.bean.User;
import com.shaluy.spring6.beandi.Maker;
import com.shaluy.spring6.beandi.MyDataSource;
import com.shaluy.spring6.dao.OrderDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {

    @Test
    public void testBeanComponent(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        User userBean = applicationContext.getBean("userBean", User.class);
        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        Student student = applicationContext.getBean("student", Student.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        OrderDao orderDao = applicationContext.getBean("orderDao", OrderDao.class);


        System.out.println(userBean);
        System.out.println(orderBean);
        System.out.println(student);
        System.out.println(orderService);
        System.out.println(orderDao);
    }

    @Test
    public void testChoose(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");
    }

    @Test
    public void testDIByAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");

        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);

        Maker maker = applicationContext.getBean("maker", Maker.class);
        System.out.println(maker);
    }

    @Test
    public void testAutowired(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");

        org.shaluy.service.OrderService orderService = applicationContext.getBean("orderService", org.shaluy.service.OrderService.class);
        orderService.generate();
    }

    @Test
    public void testResource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource.xml");

        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.delete();
    }

    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);

        StudentService studentService = annotationConfigApplicationContext.getBean("studentService", StudentService.class);
        studentService.delete();
    }
}
