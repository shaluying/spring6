package com.shaluy.spring6.test;

import com.shaluy.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {
    @Test
    public void testBeanLifecycle(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第四步：使用Bean：" + user);

        // 注意：必须手动关闭Spring容器，这样Spring容器才会销毁Bean.
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testRegisterBean(){
        //自己new的对象
        User user = new User();
        System.out.println(user);

        // 将以上自己new的这个对象纳入Spring容器来管理。半路上交给Spring来管理。
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("userBean", user);

        //从spring容器中获取
        Object userBean = factory.getBean("userBean");
        System.out.println(userBean);

    }
}
