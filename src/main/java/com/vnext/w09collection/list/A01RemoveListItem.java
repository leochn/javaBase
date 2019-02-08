package com.vnext.w09collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JAVA中循环删除list中元素的方法总结
 * 删除 List 中的元素会产生两个问题：1.删除元素后 List 的元素数量会发生变化；2.对 List 进行删除操作可能会产生并发问题；
 *
 * @Auther: LEO
 * @Date: 2019/2/3 12:39
 * @Description:
 */
public class A01RemoveListItem {


    public static void main(String[] args) {
        List<Integer> list = test();
        //test1(list);   // 输出: [1, 3, 5, 7, 9, 12]

        //test2(list);   // 报错: java.util.ConcurrentModificationException

        //test3(list);     // 这种方式可以正常的循环及删除.但要注意的是，使用iterator的remove方法
        test4(list);
    }

    //正确
    private static void test4(List<Integer> list) {
        int size = list.size();
        for(int i = size - 1; i >= 0; i--){
            Integer item = list.get(i);
            if(item % 2 == 0){
                list.remove(item);
            }
        }
        System.out.println(list);
    }

    private static void test3(List<Integer> list) {

        Iterator<Integer> it = list.iterator();

        while(it.hasNext()){
            Integer x = it.next();
            if(x % 2 == 0){
                it.remove();
            }
        }
        System.out.println(list);
    }

    // 错误
    private static void test2(List<Integer> list) {

        for(Integer x:list){
            if(x % 2 == 0)
                list.remove(x);
        }
        System.out.println(list);
        // 这种方式的问题在于，删除元素后继续循环会报错误信息ConcurrentModificationException，
        // 因为元素在使用的时候发生了并发的修改，导致异常抛出。
    }

    // 错误
    private static void test1(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                list.remove(i);
        }
        System.out.println(list);
        // 这种方式的问题在于，删除某个元素后，list的大小发生了变化，而你的索引也在变化，所以会导致你在遍历的时候漏掉某些元素。
    }

    private static List<Integer> test(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(12);
        list.add(16);
        return list;
    }
}
