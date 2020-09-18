package com.vnext.w09collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LEO
 * @date 2020/9/18 09:51
 */
public class ListOrderUtil {

    public static void main(String[] args) {

        List<String> orderRegulation = Arrays.asList("G102", "G103", "G108", "29", "28", "25", "24", "G109", "G105", "26", "21");
        List<Posts> targetList = new ArrayList<Posts>();

        Posts post3 = new Posts();
        post3.setId("G102");
        post3.setName("xiaoli3");
        post3.setAge("23");

        Posts post2 = new Posts();
        post2.setId("G103");
        post2.setName("xiaoli2");
        post2.setAge("22");

        Posts post4 = new Posts();
        post4.setId("G109");
        post4.setName("xiaoli4");
        post4.setAge("25");

        Posts post7 = new Posts();
        post7.setId("G107");
        post7.setName("xiaoli7");
        post7.setAge("21");

        Posts post8 = new Posts();
        post8.setId("G101");
        post8.setName("xiaoli8");
        post8.setAge("26");

        Posts post5 = new Posts();
        post5.setId("G105");
        post5.setName("xiaoli5");
        post5.setAge("27");

        Posts post1 = new Posts();
        post1.setId("G104");
        post1.setName("xiaoli1");
        post1.setAge("29");

        Posts post6 = new Posts();
        post6.setId("G106");
        post6.setName("xiaoli6");
        post6.setAge("23");

        Posts post9 = new Posts();
        post9.setId("G106");
        post9.setName("xiaoli9");
        post9.setAge("25");

        Posts post10 = new Posts();
        post10.setId("G104");
        post10.setName("xiaoli10");
        post10.setAge("28");

        targetList.add(post1);
        targetList.add(post2);
        targetList.add(post3);
        targetList.add(post4);
        targetList.add(post5);
        targetList.add(post6);
        targetList.add(post7);
        targetList.add(post8);
        targetList.add(post9);
        targetList.add(post10);
        System.out.println("排列前的数据：");
        targetList.forEach(t -> System.out.print(t.getId() + t.getName() + "~" + t.getAge() + "  "));
        System.out.println();

        setListOrder(orderRegulation, targetList);

        System.out.println("排序的规则：");
        orderRegulation.forEach(t -> System.out.print(t + " "));
        System.out.println();
        System.out.println("排列后的数据：");
        targetList.forEach(t -> System.out.print(t.getId() + t.getName() + "~" + t.getAge() + " "));

    }

    //平时排序可使用其中一种，下面是综合两个条件排序
    public static void setListOrder(List<String> orderRegulation, List<Posts> targetList) {
        //按照Posts的Id来排序
        Collections.sort(targetList, ((o1, o2) -> {
            int io1 = orderRegulation.indexOf(o1.getId());
            int io2 = orderRegulation.indexOf(o2.getId());

            if (io1 != -1) {
                io1 = targetList.size() - io1;
            }
            if (io2 != -1) {
                io2 = targetList.size() - io2;
            }

            return io2 - io1;
        }));

//        //按照Posts的age来排序
//        Collections.sort(targetList, ((o1, o2) -> {
//            int io1 = orderRegulation.indexOf(o1.getAge());
//            int io2 = orderRegulation.indexOf(o2.getAge());
//
//            if (io1 != -1) {
//                io1 = targetList.size() - io1;
//            }
//            if (io2 != -1) {
//                io2 = targetList.size() - io2;
//            }
//
//            return io2 - io1;
//        }));
    }
}
