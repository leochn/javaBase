/**
 * 
 */
package com.vnext.datatype;

import java.lang.reflect.Field;

/**
 * 一个简单代码的不简单实现:
 * 涉及到的知识点:
 * 1.java 的参数传递都是值传递
 * 2.Integer的内部实现(value,缓存,等等)
 * 3.反射操作(可访问性)
 * 4.自动装箱和拆箱
 * @author leo
 * @since 2018-02-06 17:59:33
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer a = 1, b = 2;
        System.out.println("before swap a = " + a + ", b = " + b);
        swap(a, b);
        System.out.println("after swap a = " + a + ", b = " + b);

        Integer c = 1;
        System.out.println("(警告:Integer缓存被改了,代码里:Integer c = 1;) 实际c=" + c);
        
        /*before swap a = 1, b = 2
        after swap a = 2, b = 1
        (警告:Integer缓存被改了,代码里:Integer c = 1;) 实际c=2*/

    }

    public static void swap(Integer i1, Integer i2) {
        try {
            Field f = Integer.class.getDeclaredField("value");
            f.setAccessible(true);
            int tmp = i1;
            f.setInt(i1, i2);
            f.setInt(i2, tmp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
