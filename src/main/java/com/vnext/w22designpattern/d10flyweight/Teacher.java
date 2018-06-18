package com.vnext.w22designpattern.d10flyweight;

/**
 * 具体享元角色：抽象享元角色的具体实现类，并实现了抽象享元角色规定的方法
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:19:54
 */
public class Teacher extends Person {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Teacher(String name, int age, String sex,String number) {
        super(name, age, sex);
        this.number = number;
    }

    public Teacher() {
        super();
    }
}