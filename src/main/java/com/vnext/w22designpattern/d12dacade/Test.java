package com.vnext.w22designpattern.d12dacade;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:45:30
 */
public class Test {
    /**
     * 什么是外观模式:
     * Facade模式为一组具有类似功能的类群，比如类库，子系统等等，提供一个一致的简单的界面。这个一致的简单的界面被称作facade。
     *
     * 外观模式的角色和职责:
     * 1.Facade :为调用方定义简单的调用接口。
     * 2.Clients :调用者。通过Facade接口调用提供某功能的内部类群。
     * 3.Packages :功能提供者。指提供功能的类群（模块或子系统）
     *
     * 外观模式的好处：
     *
     * 之前，Clent需要各自去对接子系统
     * ClientA   --->   systemA
     * ClientA   --->   systemB
     * ClientA   --->   systemB
     *
     * ClientB   --->   systemA
     * ClientB   --->   systemB
     * ClientB   --->   systemB
     *
     *外观模式，Clent只需要对接facade就可以了(股民只要对接经理人，就可以买股票、期货、国债等)
     * ClientA   --->  facade ----->  systemA
     *                          |-->  systemB
     *                          |-->  systemC
     *
     * ClientB   --->  facade ----->  systemA
     *                          |-->  systemB
     *                          |-->  systemC
     */


    public static void main(String[] args) {
        //80年代，基金出现之前
        GuPiao gupiao = new GuPiao();
        gupiao.chao();

        QiHuo qihuo = new QiHuo();
        qihuo.mai();

        GuoZai guozhai = new GuoZai();
        guozhai.mai();
        System.out.println("-------------");

        // 有了基金之后
        JiJin jijin = new JiJin();
        jijin.maiJiJinA();
        jijin.maiJiJinB();
    }

}