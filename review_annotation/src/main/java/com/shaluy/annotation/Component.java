package com.shaluy.annotation;

import java.lang.annotation.*;

// 标注注解的注解，叫做元注解。@Target注解用来修饰自定义注解@Component可以出现的位置。
//@Target(value = {ElementType.TYPE, ElementType.FIELD})//表示@Component注解可以出现在类上、属性上。
//@Target(value = {ElementType.TYPE})//表示@Component注解可以出现在类上
// 使用某个注解的时候，如果注解的属性名是value的话，value可以省略。
//@Target({ElementType.TYPE})
// 使用某个注解的时候，如果注解的属性值是数组，并且数组中只有一个元素，大括号可以省略。
@Target(ElementType.TYPE)
//@Retention 也是一个元注解。用来标注@Component注解最终保留在class文件当中，并且可以被反射机制读取。
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    // 定义注解的属性
    String value();//String是属性类型 value是属性名

    // 其他的属性
    //String name();//属性类型String 属性名是name

    // 数组属性
    //String[] names();//属性类型是：String[] 属性名：names

    //int[] ages();

    //int age();
}
