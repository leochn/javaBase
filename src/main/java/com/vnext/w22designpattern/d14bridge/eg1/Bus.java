package com.vnext.w22designpattern.d14bridge.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 09:55:45
 */
public class Bus implements Car {

    @Override
    public void install2000Engine() {
        System.out.println("给Bus安装2000cc发动机");
    }

    @Override
    public void install2200Engine() {
        System.out.println("给Bus安装2200cc发动机");
    }

    @Override
    public void install2300Engine() {
        System.out.println("给Bus安装2400cc发动机");
    }
}