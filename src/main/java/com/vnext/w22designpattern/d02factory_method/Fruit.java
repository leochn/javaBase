package com.vnext.w22designpattern.d02factory_method;

/**
 * 抽象（Product）角色:工厂方法模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 06:31:10
 */
public interface Fruit {

    /*
     * 采集
     */
    public void get();
}
