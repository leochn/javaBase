package com.vnext.w22designpattern.d10flyweight;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:16:09
 */
public class Test {

    /**
     * 什么是享元模式:
     * Flyweight模式也叫享元模式，是构造型模式之一，它通过与其他类似对象共享数据来减小内存占用。
     *
     * 享元模式的角色和职责:
     * 1.抽象享元角色：
     *       所有具体享元类的父类，规定一些需要实现的公共接口。
     * 2.具体享元角色：
     *     抽象享元角色的具体实现类，并实现了抽象享元角色规定的方法。
     * 3.享元工厂角色：      
     *     负责创建和管理享元角色。
     */


    public static void main(String[] args) {

        TeacherFactory factory = new TeacherFactory();
        Teacher teacher1 = factory.getTeacher("0102034");
        Teacher teacher2 = factory.getTeacher("0102035");
        Teacher teacher3 = factory.getTeacher("0102034");
        Teacher teacher4 = factory.getTeacher("0102037");

        System.out.println(teacher1.getNumber());
        System.out.println(teacher2.getNumber());
        System.out.println(teacher3.getNumber());
        System.out.println(teacher4.getNumber());

        if(teacher1 == teacher3) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}