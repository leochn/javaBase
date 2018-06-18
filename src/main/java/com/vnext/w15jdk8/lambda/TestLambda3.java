package com.vnext.w15jdk8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 * @author leo
 * @since 2018/2/27 9:31
 */
public class TestLambda3 {

    /*
     * 函数式接口: 接口中只有一个抽象方法的接口，称之为函数式接口
     *
     * Java8 内置的四大核心函数式接口
     *
     * Consumer<T> : 消费型接口
     * 		void accept(T t);
     *
     * Supplier<T> : 供给型接口
     * 		T get();
     *
     * Function<T, R> : 函数型接口
     * 		R apply(T t);
     *
     * Predicate<T> : 断言型接口
     * 		boolean test(T t);
     *
     */


    // Consumer<T> 消费型接口 :
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test1(){
        happy(1000f,x -> System.out.println("花费了" + x + "元！"));
    }

    // Supplier<T> 供给型接口 :
    public List<Integer> getNumList (Integer num , Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void test2(){
        List<Integer> numList1 = getNumList(5, new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        });

        List<Integer> numList = getNumList(5,() -> (int) (Math.random() * 100));

        for (Integer integer : numList1) {
            System.out.println(integer);
        }

        System.out.println("-------------------");

        for (Integer integer : numList) {
            System.out.println(integer);
        }

    }

    // Function<T, R> 函数型接口：

    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }

    @Test
    public void test3(){
        String newStr = strHandler("adcdefg", (x) -> x.toUpperCase());
        System.out.println(newStr);
    }

    //Predicate<T> 断言型接口：
    //需求：将满足条件的字符串，放入集合中
    List<String> filterStr (List<String> list, Predicate<String> predicate){
        List<String> strList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)){
                strList.add(s);
            }
        }
        return strList;
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello","world","Lambda", "www", "ok");
        List<String> strings = filterStr(list, (s) -> s.length() > 3);
        for (String string : strings) {
            System.out.println(string);
        }
    }



}
