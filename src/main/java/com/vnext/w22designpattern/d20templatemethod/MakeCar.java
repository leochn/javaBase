package com.vnext.w22designpattern.d20templatemethod;

/**
 * 抽象类的父类
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 12:47:54
 */
public abstract class MakeCar {

    //组装车头
    public abstract void makeHead();

    //组装车身
    public abstract void makeBody();

    //组装车尾
    public abstract void makeTail();

    public void make() {
        this.makeHead();
        this.makeBody();
        this.makeTail();
    }
}