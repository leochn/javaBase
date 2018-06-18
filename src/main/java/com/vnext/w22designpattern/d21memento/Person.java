package com.vnext.w22designpattern.d21memento;

/**
 * Originator（原生者）:需要被保存状态以便恢复的那个对象。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 13:48:49
 */
public class Person {

    //姓名
    private String name;
    //性别
    private String sex;
    //年龄
    private int age;

    public Person() {

    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("name:" + name + ",sex:" + sex + ",age:" + age);
    }

    //创建一个备份
    public Memento createMemento() {
        return new Memento(name,sex,age);
    }

    //恢复备份，还原
    public void setMemento(Memento memento) {
        this.name = memento.getName();
        this.sex = memento.getSex();
        this.age =  memento.getAge();
    }
}