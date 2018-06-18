package com.vnext.w22designpattern.d06builder;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:46:45
 */
public class Test {
    /**
     * 什么是建造者模式:
     * Builder模式是一种对象创建型模式之一，用来隐藏复合对象的创建过程，它把复合对象的创建过程加以抽象，
     * 通过子类继承和重载的方式，动态地创建具有复合属性的对象。
     *
     * 建造者模式应用场景:
     * 1.对象的创建：Builder模式是为对象的创建而设计的模式
     * 2.创建的是一个复合对象：被创建的对象为一个具有复合属性的复合对象
     * 3.关注对象创建的各部分的创建过程：不同的工厂（这里指builder生成器）对产品属性有不同的创建方法
     */

    public static void main(String[] args) {

//        //客户直接造房子
//        House house = new House();
//        house.setFloor("地板");
//        house.setWall("墙");
//        house.setHousetop("屋顶");


//        //由工程队来修
//        HouseBuilder builder = new GongyuBuilder();
//        builder.makeFloor();
//        builder.makeWall();
//        builder.makeHousetop();
//
//        House house = builder.getHouse();
//        System.out.println(house.getFloor());
//        System.out.println(house.getWall());
//        System.out.println(house.getHousetop());


        //由工程队来修
        //HouseBuilder builder = new PingFangBuilder();
        HouseBuilder builder = new GongyuBuilder();
        //设计者来做
        HouseDirector director = new HouseDirector();
        director.makeHouse(builder);

        House house = builder.getHouse();
        System.out.println(house.getFloor());
        System.out.println(house.getWall());
        System.out.println(house.getHousetop());
    }

}