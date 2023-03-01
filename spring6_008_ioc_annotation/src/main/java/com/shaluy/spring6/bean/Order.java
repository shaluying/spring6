package com.shaluy.spring6.bean;

import org.springframework.stereotype.Controller;

@Controller("orderBean")
public class Order {
}
/*
以上的这个注解@Service就相当于以下的这个配置信息：
<bean id="order" class="com.shaluy.spring6.bean.Order"></bean>
*/
