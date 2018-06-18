package com.vnext.w05innerclass.anonymous_inner_class;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 19:50:52
 */
public class Person {

    private String uname;
    private int age;

    public String say (String str){
        return "Person say: " + str;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}