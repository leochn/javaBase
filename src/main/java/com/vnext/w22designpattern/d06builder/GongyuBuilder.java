package com.vnext.w22designpattern.d06builder;

/**
 * 公寓工程队
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:56:52
 */
public class GongyuBuilder implements HouseBuilder {

    House house = new House();

    @Override
    public void makeFloor() {
        house.setFloor("公寓-->地板");
    }

    @Override
    public void makeWall() {
        house.setHousetop("公寓-->房顶");
    }

    @Override
    public void makeHousetop() {
        house.setWall("公寓-->墙");
    }

    @Override
    public House getHouse() {
        return house;
    }
}