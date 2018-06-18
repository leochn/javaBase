package com.vnext.w22designpattern.d24visitor;

/**
 * 访问者
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:28:29
 */
public interface Visitor {

    public void visit(Park park);
    public void visit(ParkA parkA);
    public void visit(ParkB parkB);

}