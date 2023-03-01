package com.shaluy.client;

import com.shaluy.annotation.Component;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class ComponentScan {
    public static void main(String[] args) throws Exception {
        // 目前只知道一个包的名字，扫描这个包下所有的类，当这个类上有@Component注解的时候，
        // 实例化该对象，然后放到Map集合中。
        Map<String,Object> map = new HashMap<>();

        //包名
        String packageName = "com.shaluy.bean";

        String packagePath = packageName.replace('.','/');
        System.out.println(packagePath);

        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        System.out.println(url);

        //获取绝对路径
        String path = url.getPath();
        System.out.println(path);

        //将绝对路径包装成File类对象
        File file  = new File(path);
        System.out.println(file);

        // 获取一个绝对路径下的所有文件
        File[] files = file.listFiles();
        System.out.println(files);

        for (File file1 : files) {
            String name = file1.getName();
            System.out.println(name);

            String className = packageName+"."+name.substring(0,name.indexOf('.'));
            System.out.println(className);

            // 通过反射机制创建类对象解析注解
            Class<?> aClass = Class.forName(className);

            // 判断类上是否有这个注解
            if (aClass.isAnnotationPresent(Component.class)) {
                // 有这个注解的都要创建对象
                Constructor<?> constructor = aClass.getDeclaredConstructor();
                Object obj = constructor.newInstance();

                // 获取注解的属性值
                String id = aClass.getAnnotation(Component.class).value();

                map.put(id,obj);
            }
        }

        System.out.println(map);

    }
}
