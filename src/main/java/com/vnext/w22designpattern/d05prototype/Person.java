package com.vnext.w22designpattern.d05prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:35:23
 */
public class Person implements Cloneable{

    // 姓名
    private String name;
    // 年龄
    private int age;
    // 性别
    private String sex;
    //朋友
    private List<String> friends;

    public Person clone() {
        try {
            Person person = (Person) super.clone();
            List<String> newfriends = new ArrayList<String>();
            for (String friend : this.getFriends()) {
                newfriends.add(friend);
            }
            person.setFriends(newfriends);
            return person;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}