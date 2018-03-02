package com.vnext.w17jvm.classloader;

/**
 * 类的初始化时机：
        调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
 * @author leo
 * @since 2018/3/1 12:53
 */
public class MyTest05 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.vnext.w17jvm.classloader.CLA");
        System.out.println("------------------");
        Class<?> aClass = Class.forName("com.vnext.w17jvm.classloader.CLA");
    }
}

class CLA{

    static {
        System.out.println("CLA static block");
    }
}