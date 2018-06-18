package com.vnext.w22designpattern.d18cor.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 11:17:16
 */
public class Test {

    /**
     * 没有职责链的情况
     */

    public static void main(String[] args) {

        // 没有职责链的情况,组装顺序完全有客户端自己决定.
        CarHandler headH = new CarHeadHandler();
        CarHandler bodyH = new CarBodyHandler();
        CarHandler tailH = new CarTailHandler();

        headH.HandlerCar();
        tailH.HandlerCar();
        bodyH.HandlerCar();
    }



}