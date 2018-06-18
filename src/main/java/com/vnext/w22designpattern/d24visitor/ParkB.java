package com.vnext.w22designpattern.d24visitor;

/**
 * 公园的B部分
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:29:30
 */
public class ParkB implements ParkElement{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}