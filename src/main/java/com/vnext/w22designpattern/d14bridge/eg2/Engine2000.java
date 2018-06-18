package com.vnext.w22designpattern.d14bridge.eg2;

/**
 * Implementor子类
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 09:59:47
 */
public class Engine2000 implements Engine {

    @Override
    public void installEngine() {
        System.out.println("安装2000cc发动机");
    }
}