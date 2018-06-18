package com.vnext.w22designpattern.d15adapter.eg02;

/**
 * Client类：手机 .需要5V电压
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:28:42
 */
public class Mobile {

    public void charging(Voltage5 voltage5) {
        if (voltage5.output5V() == 5) {
            System.out.println("电压刚刚好5V，开始充电");
        } else if (voltage5.output5V() > 5) {
            System.out.println("电压超过5V，都闪开 我要变成note7了");
        }
    }


}