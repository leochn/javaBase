package com.vnext.w22designpattern.d06builder;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 10:05:47
 */
public class HouseDirector {

    public void makeHouse(HouseBuilder builder) {
        builder.makeFloor();
        builder.makeWall();
        builder.makeHousetop();
    }
}