package com.shaluy.spring6.test;

import com.shaluy.spring6.Spring6Config;
import com.shaluy.spring6.pojo.Account;
import com.shaluy.spring6.service.AccountService;
import com.shaluy.spring6.service.impl.AccountServiceImpl;
import com.shaluy.spring6.service.impl.IsolationService1;
import com.shaluy.spring6.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringTransactionTest {

    @Test
    public void testTransfer(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);

        try {
            accountService.transfer("act-001","act-002",10000.0);
            System.out.println("转账成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPropagation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        AccountService AccountService = applicationContext.getBean("accountServiceImpl", AccountService.class);

        Account account = new Account("act-003",40000.0);
        AccountService.save(account);
    }

    @Test
    public void testIsolation1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        IsolationService1 isolationService1 = applicationContext.getBean("isolationService1", IsolationService1.class);

        Account account = isolationService1.getByActno("act-006");
        System.out.println(account);
    }

    @Test
    public void testIsolation2() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        IsolationService2 isolationService2 = applicationContext.getBean("isolationService2", IsolationService2.class);

        int count = isolationService2.save(new Account("act-006", 10000.0));
    }

    @Test
    public void testNoXml(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);

        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);

        try {
            accountService.transfer("act-001","act-002",10000.0);
            System.out.println("转账成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
