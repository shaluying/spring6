package com.shaluy.spring6;

import com.shaluy.spring6.bean.*;
import com.shaluy.spring6.bean.Math;
import com.shaluy.spring6.dao.OrderDao;
import com.shaluy.spring6.dao.UserDao;
import com.shaluy.spring6.jdbc.MyDataSource;
import com.shaluy.spring6.jdbc.MyDataSource1;
import com.shaluy.spring6.jdbc.MyDataSource2;
import com.shaluy.spring6.service.CustomerService;
import com.shaluy.spring6.service.OrderService;
import com.shaluy.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDiTest {

    @Test
    public void testDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        UserDao userDaoBean = applicationContext.getBean("userDaoBean", UserDao.class);
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);

        userService.saveUser();
        userService.saveVip();
    }

    @Test
    public void testCustomerDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("constructor-di.xml");

        CustomerService csBean = applicationContext.getBean("csBean", CustomerService.class);
        csBean.save();

        CustomerService csBean2 = applicationContext.getBean("csBean2", CustomerService.class);
        csBean2.save();

        CustomerService csBean3 = applicationContext.getBean("csBean3", CustomerService.class);
        csBean.save();

    }

    @Test
    public void testDI2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        OrderService orderServiceBean2 = applicationContext.getBean("orderServiceBean2", OrderService.class);

        orderServiceBean.generate();
        orderServiceBean2.generate();
    }

    @Test
    public void testSimpleTypeSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        System.out.println("-------------------");

        SimpleValueType svt = applicationContext.getBean("svt", SimpleValueType.class);
        System.out.println(svt);
    }

    @Test
    public void testMyDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testCascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        Clazz clazzBean = applicationContext.getBean("clazzBean", Clazz.class);

        System.out.println(studentBean);
        System.out.println(clazzBean);
    }

    @Test
    public void testArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        QianDaYe qianDaYeBean = applicationContext.getBean("qianDaYeBean", QianDaYe.class);

        System.out.println(qianDaYeBean);
    }

    @Test
    public void testCollection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        Person personBean = applicationContext.getBean("personBean", Person.class);

        System.out.println(personBean);
    }

    @Test
    public void testNull(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        Cat catBean = applicationContext.getBean("catBean", Cat.class);

        System.out.println(catBean);
    }

    @Test
    public void testSpecial(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        Math mathBean = applicationContext.getBean("mathBean", Math.class);
        System.out.println(mathBean);
    }

    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p-di.xml");

        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);

        System.out.println(dogBean);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("c-di.xml");

        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);

        System.out.println(dogBean);
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("util-di.xml");

        MyDataSource1 dataSourceBean1 = applicationContext.getBean("dataSourceBean1", MyDataSource1.class);
        MyDataSource2 dataSourceBean2 = applicationContext.getBean("dataSourceBean2", MyDataSource2.class);

        System.out.println(dataSourceBean1);
        System.out.println(dataSourceBean2);

    }

    @Test
    public void testAutowire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowire-di.xml");

        OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        CustomerService customerService = applicationContext.getBean("csBean", CustomerService.class);

        System.out.println(orderServiceBean);
        System.out.println(customerService);


        orderServiceBean.generate();
        customerService.save();
    }

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("properties-di.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }

}
