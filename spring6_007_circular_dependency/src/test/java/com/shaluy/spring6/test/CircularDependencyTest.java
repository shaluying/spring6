package com.shaluy.spring6.test;

import com.shaluy.spring6.bean.Husband;
import com.shaluy.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {

    @Test
    public void testCircularDependency(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println(husband);

        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(wife);
    }
}
