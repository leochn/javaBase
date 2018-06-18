package com.vnext.w22designpattern.d18cor.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 11:21:15
 */
public class Test {

    /**
     * 什么是职责链模式:
     * 该模式构造一系列分别担当不同的职责的类的对象,来共同完成一个任务，这些类的对象之间像链条一样紧密相连，所以被称作职责链模式。
     *
     * 职责链模式的应用场景:
     * 1.比如客户Client要完成一个任务，这个任务包括a,b,c,d四个部分。
     *     首先客户Client把任务交给A，A完成a部分之后，把任务交给B，B完成b部分，...，直到D完成d部分。
     * 2：软件窗口的消息传播。
     * 3：SERVLET容器的过滤器（Filter）框架实现。
     */

    public static void main(String[] args) {

        CarHandler headH = new CarHeadHandler();
        CarHandler bodyH = new CarBodyHandler();
        CarHandler tailH = new CarTailHandler();

        //组装顺序预先设定好,顺序是车头-->车身-->车尾
        headH.setNextHandler(bodyH);
        bodyH.setNextHandler(tailH);

        //调用职责链的链头来完成操作
        headH.handlerCar();

        System.out.println("---------------");

        //顺序改变，希望是车身-->车头--车尾
        bodyH.setNextHandler(headH);
        headH.setNextHandler(tailH);
        bodyH.handlerCar();

        //简便操作
        bodyH.setNextHandler(headH).setNextHandler(tailH);
        bodyH.handlerCar();


    }

}