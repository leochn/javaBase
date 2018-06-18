package com.vnext.w22designpattern.d10flyweight;

import lombok.Data;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:19:16
 */
@Data
public class Person {
    private String name;
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person() {

    }
}