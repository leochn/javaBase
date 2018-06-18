package com.vnext.w22designpattern.d24visitor;

/**
 * 清洁工A,负责parkA的卫生情况
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:32:24
 */
public class VisitorA implements Visitor {

    @Override
    public void visit(Park park) {

    }

    @Override
    public void visit(ParkA parkA) {
        System.out.println("清洁工A:完成公园" + parkA.getName()+ "的卫生");
    }

    @Override
    public void visit(ParkB parkB) {

    }
}