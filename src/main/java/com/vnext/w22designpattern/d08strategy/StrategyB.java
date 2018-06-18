package com.vnext.w22designpattern.d08strategy;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 11:11:35
 */
public class StrategyB implements Strategy{

    @Override
    public double cost(double num) {
        if(num >= 200) {
            return num - 50;
        }
        return num;
    }
}