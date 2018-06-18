package com.vnext.w22designpattern.d15adapter.eg02;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:29:14
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("===============类适配器==============");
        Mobile mobile = new Mobile();
        mobile.charging(new VoltageAdapter());
    }

}