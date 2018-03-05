package com.vnext.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @author leo
 * @since 2018/3/5 14:36
 */
public class MyTest01 {

    public static void main(String[] args) {
        List<Coordinate> list = Arrays.asList(
                new Coordinate(121.190433,31.453382), // 太仓 ，上
                new Coordinate(120.980319,31.397719), // 昆山 ，左
                new Coordinate(121.160907,31.151234), // 青浦 ，下
                new Coordinate(121.577014,31.223486), // 浦东 ，右
                new Coordinate(121.012592,31.266928), // 千灯古镇 ，左1
                new Coordinate(121.17464,31.19236), // 左2
                new Coordinate(121.188373,31.323841),// nei 1
                new Coordinate(121.37308,31.256949) // nei 2
        );











        
    }

}

class Coordinate{

    private double longitude;

    private double latitude;  //纬度

    public Coordinate(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

























