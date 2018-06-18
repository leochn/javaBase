package com.vnext.w22designpattern.d24visitor;

/**
 * 清洁工B，负责公园B部分的卫生
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:33:01
 */
public class VisitorB implements Visitor {

    @Override
    public void visit(Park park) {

    }

    @Override
    public void visit(ParkA parkA) {

    }

    @Override
    public void visit(ParkB parkB) {
        System.out.println("清洁工B:完成公园" + parkB.getName()+"的卫生");
    }
}