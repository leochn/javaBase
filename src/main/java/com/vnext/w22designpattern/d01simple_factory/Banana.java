package com.vnext.w22designpattern.d01simple_factory;

/**
 * 具体产品（Concrete Product）角色: 简单工厂模式所创建的具体实例对象
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 06:33:11
 */
public class Banana implements Fruit {

    @Override
    public void get() {
        System.out.println("采集香蕉");
    }
}