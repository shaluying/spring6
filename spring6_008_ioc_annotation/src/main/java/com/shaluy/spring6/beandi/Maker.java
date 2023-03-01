package com.shaluy.spring6.beandi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Maker {
    private String name;
    private int age;

    // @Value注解也可以使用在set方法上。
    /*@Value("隔壁老王")
    public void setName(String name) {
        this.name = name;
    }

    @Value("30")
    public void setAge(int age) {
        this.age = age;
    }*/

    // @Value注解也可以使用在构造方法上。
    public Maker(@Value("隔壁老王") String name, @Value("30") int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Maker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
