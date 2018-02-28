package com.vnext.w15jdk8.annotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author leo
 * @version 2018/2/28 21:28
 * @since 1.0.0
 */
public class TestAnnotation {

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(){
        System.out.println("show...");
    }


    @Test
    public void test1() throws Exception {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method show = clazz.getMethod("show");
        // 获取方法上的注解
        MyAnnotation[] mas = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation ma : mas) {
            System.out.println(ma.value());
        }
    }
}
