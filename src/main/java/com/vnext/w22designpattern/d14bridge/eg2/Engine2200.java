package com.vnext.w22designpattern.d14bridge.eg2;

/**
 * Implementor子类
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:00:16
 */
public class Engine2200 implements Engine {

    @Override
    public void installEngine() {
        System.out.println("安装2200cc发动机");
    }
}