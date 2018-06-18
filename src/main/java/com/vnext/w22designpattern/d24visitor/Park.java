package com.vnext.w22designpattern.d24visitor;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:29:21
 */
public class Park implements ParkElement{

    private String name;
    private ParkA parkA;
    private ParkB parkB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Park() {
        this.parkA = new ParkA();
        this.parkB = new ParkB();
        parkA.setName("A");
        parkB.setName("B");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        parkA.accept(visitor);
        parkB.accept(visitor);
    }
}