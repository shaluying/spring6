package com.shaluy.spring6.test;

import com.shaluy.spring6.service.OrderService;
import com.shaluy.spring6.service.SecurityAspect;
import com.shaluy.spring6.service.Spring6Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopTest {

    @Test
    public void testAspect(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        /*UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
        userService.logout();*/

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testNoXml(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);

        OrderService orderService = annotationConfigApplicationContext.getBean("orderService", OrderService.class);
        orderService.generate();

        SecurityAspect securityAspect = annotationConfigApplicationContext.getBean("securityAspect", SecurityAspect.class);
        securityAspect.beforeAdvice();
    }
}
