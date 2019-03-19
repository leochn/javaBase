package com.vnext.w23sourcecode.A03Arrylist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: LEO
 * @Date: 2019/3/9 06:43
 * @Description:
 */
public class ArrayListTest01 {

    public static void main(String[] args) {

        // 1.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(list);

        // 2.
        Object[] objects = new Object[]{0, 1, 2, 3, 4, 5, 6};
        System.out.println(objects.length);
        Object[] newObjects = Arrays.copyOf(objects, 10);
        System.out.println(newObjects.length);

        // 参数1起始位置赋值 参数2赋值数据源 参数3 目的地数据源 参数4 目的的起始位置 参数五 赋值长度
        System.arraycopy(objects, 0, objects, 3, 3);
        for (Object object : objects) {
            System.out.print(object + ",");
        }


        // 1.jdk 1.7之后 数组默认数据大小代码存放在add方法 (JDK1.6的时候 默认构造函数初始化elementData大小)
        // 2.arraylist底层采用数组实现 数组名称elementData
        // 2.arraylist底层采用数组实现默认初始化最小容量为10
        JDKArrayList<Object> jdkArrayList = new JDKArrayList<>(2);
        jdkArrayList.add("张三");
        jdkArrayList.remove("tone");
        jdkArrayList.add(1, "李四");
        System.out.println(jdkArrayList);



    }
}
