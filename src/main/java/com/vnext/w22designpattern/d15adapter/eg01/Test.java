package com.vnext.w22designpattern.d15adapter.eg01;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:06:05
 */
public class Test {
    /**
     * 什么是适配器模式:
     *     Adapter模式也叫适配器模式，是构造型模式之一，通过Adapter模式可以改变已有类（或外部类）的接口形式。
     *
     */

    public static void main(String[] args) {

        // 直接使用外部电源
        Current current = new Current();
        current.use220V();

        // 使用适配器(继承方式实现的适配器)
        Adapter01 adapter01 = new Adapter01();
        adapter01.use18V();

        Adapter02 adapter02 = new Adapter02(new Current());
        adapter02.use18V();
    }


}