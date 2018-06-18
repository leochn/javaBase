package com.vnext.w15jdk8.exer;

/**
 * @author leo
 * @version 2018/2/28 21:00
 * @since 1.0.0
 */
public class SubClass2 implements MyFun,MyFun2{

    @Override
    public String getName() {
        //return "djl";
        //return MyFun2.super.getName();
        return MyFun.super.getName();
    }
}
