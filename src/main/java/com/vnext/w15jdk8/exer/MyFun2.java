package com.vnext.w15jdk8.exer;

/**
 * @author leo
 * @version 2018/2/28 21:01
 * @since 1.0.0
 */
public interface MyFun2 {

    default String getName(){
        return "hello-MyFun2";
    }

    public static void show(){
        System.out.println("接口中的静态方法...");
    }

}
