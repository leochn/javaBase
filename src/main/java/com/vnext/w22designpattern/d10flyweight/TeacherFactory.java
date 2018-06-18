package com.vnext.w22designpattern.d10flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂角色：负责创建和管理享元角色。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:20:34
 */
public class TeacherFactory {

    private Map<String,Teacher> pool;

    public TeacherFactory() {
        pool = new HashMap<String,Teacher>();
    }

    public Teacher getTeacher(String number) {
        Teacher teacher = pool.get(number);
        if(teacher == null) {
            teacher = new Teacher();
            teacher.setNumber(number);
            pool.put(number, teacher);
        }
        return teacher;
    }
}