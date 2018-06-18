package com.vnext.w22designpattern.d24visitor;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:33:36
 */
public class VisitorManager implements Visitor {

    @Override
    public void visit(Park park) {
        System.out.println("管理员：负责" + park.getName() + "卫生检查");
    }

    @Override
    public void visit(ParkA parkA) {
        System.out.println("管理员：负责公园"+ parkA.getName() +"部分卫生检查");
    }

    @Override
    public void visit(ParkB parkB) {
        System.out.println("管理员：负责公园"+ parkB.getName() +"分部卫生检查");
    }
}