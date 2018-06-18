package com.vnext.w05innerclass.anonymous_inner_class;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 19:43:34
 */
public abstract class Bird {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}