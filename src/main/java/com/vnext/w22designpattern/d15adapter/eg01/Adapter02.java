package com.vnext.w22designpattern.d15adapter.eg01;

/**
 * 通过委让实现Adapter
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:13:57
 */
public class Adapter02 {
    private Current current;

    public Adapter02(Current current) {
        this.current = current;
    }

    public void use18V() {
        this.current.use220V();
        System.out.println("使用Adapter02适配器...输出18V电压...");
    }
}