package com.vnext.w22designpattern.d24visitor;

/**
 * 公园每一部分的抽象
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:28:02
 */
public interface ParkElement {
    //用来接纳访问者
    public void accept(Visitor visitor);
}