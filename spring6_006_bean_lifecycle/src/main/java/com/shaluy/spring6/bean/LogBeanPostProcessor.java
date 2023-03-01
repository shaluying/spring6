package com.shaluy.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 日志Bean后处理器。
 * @author 动力节点
 * @version 1.0
 * @className LogBeanPostProcessor
 * @since 1.0
 **/
public class LogBeanPostProcessor implements BeanPostProcessor {
    // 方法有两个参数：
    // 第一个参数：刚创建的bean对象。
    // 第二个参数：bean的名字。
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行Bean后处理器的before方法。");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行Bean后处理器的after方法。");
        return null;
    }
}
