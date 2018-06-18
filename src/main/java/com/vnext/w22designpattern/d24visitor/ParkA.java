package com.vnext.w22designpattern.d24visitor;

/**
 * 公园的A部分
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:29:07
 */
public class ParkA implements ParkElement{
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