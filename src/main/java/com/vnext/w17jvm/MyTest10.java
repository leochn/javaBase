package com.vnext.w17jvm;

/**
 * @author leo
 * @version 2018/3/1 18:42
 * @since 1.0.0
 */
public class MyTest10 {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.vnext.w17jvm.QWE1"); // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(aClass.getClassLoader());

        Class<?> aClass1 = Class.forName("java.lang.String");
        System.out.println(aClass1.getClassLoader()); // null
    }

}
class QWE{

}
