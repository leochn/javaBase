package com.vnext.w22designpattern.d15adapter.eg02;

/**
 * src类: 我们有的220V电压
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:26:27
 */
public class Voltage220 {
    public int output220V() {
        int src = 220;
        System.out.println("我是" + src + "V");
        return src;
    }
}