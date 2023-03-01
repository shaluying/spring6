package com.shaluy.spring6.test;

import com.shaluy.spring6.bean.User;
import com.shaluy.spring6.dao.UserDaoImplForMysql;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {

    @Test
    public void testBeginInitBean(){
        // 注意：不是在调用getBean()方法的时候创建对象，执行以下代码的时候，就会实例化对象。
        new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void testBeanFactory(){
        //ApplicationContext接口的超级父接口是：BeanFactory（翻译为Bean工厂，就是能够生产Bean对象的一个工厂对象。）
        //BeanFactory是IoC容器的顶级接口。
        //Spring的IoC容器底层实际上使用了：工厂模式。
        //Spring底层的IoC是怎么实现的？XML解析 + 工厂模式 + 反射机制
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }


    @Test
    public void testFistSpringCode() {
        // 第一步：获取Spring容器对象。
        // ApplicationContext 翻译为：应用上下文。其实就是Spring容器。
        // ApplicationContext 是一个接口。
        // ApplicationContext 接口下有很多实现类。其中有一个实现类叫做：ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext 专门从类路径当中加载spring配置文件的一个Spring上下文对象。
        // 这行代码只要执行：就相当于启动了Spring容器，解析spring.xml文件，并且实例化所有的bean对象，放到spring容器当中。
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "beans.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "beans.xml", "xml/beans.xml");


        // 第二步：根据bean的id从Spring容器中获取这个对象。
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

//        Object userDaoImplForMysql = applicationContext.getBean("userDaoImplForMysqlBean");
        UserDaoImplForMysql userDaoImplForMysqlBean = applicationContext.getBean("userDaoImplForMysqlBean", UserDaoImplForMysql.class);
        System.out.println(userDaoImplForMysqlBean);
        userDaoImplForMysqlBean.insert();

        Object vipBean = applicationContext.getBean("vipBean");
        System.out.println(vipBean);

        Object userBean2 = applicationContext.getBean("userBean2");
        System.out.println(userBean2);

        Object nowTime = applicationContext.getBean("nowTime");
        System.out.println(nowTime);

//        Date nowTime1 = (Date)applicationContext.getBean("nowTime");
        // 不想强制类型转换，可以使用以下代码（通过第二个参数来指定返回的bean的类型。）
        Date nowTime1 = applicationContext.getBean("nowTime", Date.class);// 如果bean的id不存在，不会返回null，而是出现异常。
        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strNowTime1 = sdf.format(nowTime1);
        System.out.println(strNowTime1);

    }
}
