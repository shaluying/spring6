package com.shaluy.spring6.test;

import com.shaluy.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration("classpath:spring.xml")
@ExtendWith(SpringExtension.class)
public class SpringJunit5Test {

    @Autowired
    private User user;

    @Test
    public void testJunit5User1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);

        System.out.println(user);
    }

    @Test
    public void testJunit5User2(){
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);*/

        System.out.println(user);
    }

    @Test
    public void testJunit5User3(){
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);*/

        System.out.println(user);
    }
}
