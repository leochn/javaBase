package com.vnext.w22designpattern.d06builder;

/**
 * 平房工程队
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:55:32
 */
public class PingFangBuilder implements HouseBuilder {

    House house = new House();

    @Override
    public void makeFloor() {
        house.setFloor("平房-->地板");
    }

    @Override
    public void makeWall() {
        house.setHousetop("平房-->房顶");
    }

    @Override
    public void makeHousetop() {
        house.setWall("平房-->墙");
    }

    @Override
    public House getHouse() {
        return house;
    }
}