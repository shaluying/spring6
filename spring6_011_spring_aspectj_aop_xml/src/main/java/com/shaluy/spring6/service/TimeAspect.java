package com.shaluy.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeAspect {

    // 通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前环绕
        long star = System.currentTimeMillis();

        // 目标
        joinPoint.proceed();

        // 后环绕
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - star)+"毫秒");
    }

}
