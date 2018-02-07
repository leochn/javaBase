package com.vnext.w13reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author leo
 * @version 2018/1/29 22:05
 * @since 1.0.0
 */
public class TestOthers {
    //1.获取运行时类的父类
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        Class<?> superClass = clazz.getSuperclass();
        System.out.println(superClass);
    }

    //2.获取带泛型的父类
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Type type1 = clazz.getGenericSuperclass();
        System.out.println(type1);
    }

    //3*.获取父类的泛型
    @Test
    public void test3(){
        Class<Person> clazz = Person.class;
        Type type1 = clazz.getGenericSuperclass();

        ParameterizedType param = (ParameterizedType)type1;
        Type[] ars = param.getActualTypeArguments();

        System.out.println(((Class<?>)ars[0]).getName());
    }

    //4.获取实现的接口
    @Test
    public void test4(){
        Class<Person> clazz = Person.class;
        @SuppressWarnings("rawtypes")
		Class[] interfaces = clazz.getInterfaces();
        for(Class<?> i : interfaces){
            System.out.println(i);
        }
    }

    //5.获取所在的包
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    //6.获取注解
    @Test
    public void test6(){
        Class<Person> clazz = Person.class;
        Annotation[] anns = clazz.getAnnotations();
        for(Annotation a : anns){
            System.out.println(a);
        }
    }
}
