/**
 * 
 */
package com.vnext.w09collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
/**
 * @author leo
 * @since 2018-02-06 17:59:20
 */
public class TestList {

	public static void main(String[] args) {

        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        // 1. id为key，apple对象为value
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));

        Set<Integer> keySet = appleMap.keySet();
        for (Integer key : keySet){
            Apple apple = appleMap.get(key);
            System.out.println(apple);
        }

        // 2.分组, List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println("groupBy:"+groupBy);
        

        // 3.过滤出符合条件的数据
        List<Apple> filterList = appleList.stream().filter(a -> a.getName().equals("苹果2")).collect(Collectors.toList());

        System.out.println("filterList:"+filterList);

        // 4.将集合中的数据按照某个属性求和
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("totalMoney:"+totalMoney);  //totalMoney:17.48

        // 5.根据id去重
		List<Apple> unique = appleList.stream().collect(
				collectingAndThen(toCollection(() -> new TreeSet<>(comparingLong(Apple::getId))), ArrayList::new));

        for (Apple apple : unique) {
            System.out.println(apple);
        }

    }
	
}
