package com.vnext.w22designpattern.d15adapter.eg01;

/**
 * 通过继承实现Adapter
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:13:24
 */
public class Adapter01 extends Current {

    public void use18V() {
        this.use220V();
        System.out.println("使用Adapter01适配器...输出18V电压...");
    }
}