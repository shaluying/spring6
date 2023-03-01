package com.shaluy.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect // 切面类是需要使用@Aspect注解进行标注的。
@Order(0)//数字越小优先级越高
public class LogAspect {//日志切面

    // 切面 = 通知 + 切点
    // 通知就是增强，就是具体的要编写的增强代码
    // 这里通知Advice以方法的形式出现。（因为方法中可以写代码）
    // @Before注解标注的方法就是一个前置通知。
    /*@Before("execution(* com.shaluy.spring6.service..*(..))")
    public void 增强() {
        System.out.println("我是一个通知，我是一段增强代码...");
    }*/

    // 定义通用的切点表达式
    @Pointcut("execution(* com.shaluy.spring6.service.UserService.*(..))")
    public void 通用切点(){
        // 这个方法只是一个标记，方法名随意，方法体中也不需要写任何代码。
    }

    // 前置通知
    @Before("通用切点()")
    public void beforeAdvice(JoinPoint joinPoint){// 这个JoinPoint joinPoint，在Spring容器调用这个方法的时候自动传过来.
        System.out.println("前置通知");
        // 我们可以直接用。用这个JoinPoint joinPoint干啥？
        // Signature signature = joinPoint.getSignature(); 获取目标方法的签名。
        // 通过方法的签名可以获取到一个方法的具体信息。
        // 获取目标方法的方法名。
        Signature signature = joinPoint.getSignature();
        System.out.println("目标方法的签名："+signature);
        String name = signature.getName();
        System.out.println("目标方法的方法名："+name);
    }

    // 后置通知
    @AfterReturning("通用切点()")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("后置通知");
    }

    // 环绕通知(环绕是最大的通知，在前置通知之前，在后置通知之后。)
    @Around("通用切点()")
    public void arountAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前面的代码
        System.out.println("前环绕通知");

        // 执行目标
        joinPoint.proceed(); // 执行目标方法

        // 后面的代码
        System.out.println("后环绕通知");
    }

    //异常通知
    @AfterThrowing("通用切点()")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }

    // 最终通知(finally语句块中的通知)
    @After("通用切点()")
    public void afterAdvice(){
        System.out.println("最终通知");
    }

}
