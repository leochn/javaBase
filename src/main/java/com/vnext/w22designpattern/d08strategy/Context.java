package com.vnext.w22designpattern.d08strategy;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 11:10:11
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double cost(double num){
        return this.strategy.cost(num);
    }
}