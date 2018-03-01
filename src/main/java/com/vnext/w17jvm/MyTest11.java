package com.vnext.w17jvm;

/**
 * @author leo
 * @version 2018/3/1 21:23
 * @since 1.0.0
 */
public class MyTest11 {

    public static void main(String[] args) throws ClassNotFoundException {
        Object obj = new Object();
        System.out.println(obj.getClass().getClassLoader());

        Class<?> aClass = Class.forName("com.vnext.w17jvm.HelloWorld");
        System.out.println(aClass.getClass().getClassLoader());

        MyTest11 myTest11 = new MyTest11();
        System.out.println(myTest11.getClass().getClassLoader());
    }

}
