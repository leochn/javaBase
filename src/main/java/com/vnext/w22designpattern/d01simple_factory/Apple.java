package com.vnext.w22designpattern.d01simple_factory;

/**
 * 具体产品（Concrete Product）角色
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 06:32:46
 */
public class Apple implements Fruit {

    @Override
    public void get() {
        System.out.println("采集苹果");
    }
}