package com.vnext.w22designpattern.d06builder;

/**
 * 工程队 接口
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:53:16
 */
public interface HouseBuilder {

    // 修地板
    public void makeFloor();
    // 修墙
    public void makeWall();
    // 修屋顶
    public void makeHousetop();

    public House getHouse();
}