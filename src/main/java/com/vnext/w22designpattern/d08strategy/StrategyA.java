package com.vnext.w22designpattern.d08strategy;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 11:11:00
 */
public class StrategyA implements Strategy {

    @Override
    public double cost(double num) {
        return num * 0.8;
    }
}