package com.vnext.w09collection.map;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Auther: LEO
 * @Date: 2019/2/1 12:36
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppleDO {

    private int id;
    private int weight;
    private String color;

    public static void main(String[] args) {

        List<AppleDO> list = Arrays.asList(
                new AppleDO(1, 11, "red"),
                new AppleDO(2, 12, "yellow"),
                new AppleDO(3, 13, "green"),
                new AppleDO(4, 14, "green"),
                new AppleDO(5, 11, "red"),
                new AppleDO(7, 17, null)
        );

        // 1.List转Map ==> key:value （属性:对象）
        Map<Integer, AppleDO> collect = Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream().collect(Collectors.toMap(AppleDO::getId, appleDO -> appleDO));
        System.out.println(JSON.toJSON(collect));

        // 2.List转Map ==> key:value （属性:属性）
        Map<Integer, Integer> collect1 = Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream().collect(Collectors.toMap(AppleDO::getId, AppleDO::getWeight));
        System.out.println(JSON.toJSON(collect1));

        // 3.List转Map ==> key:value （属性:属性）
        // key重复时会异常: Exception in thread "main" java.lang.IllegalStateException: Duplicate key red
//        Map<Integer, String> collect3 = Optional.ofNullable(list)
//                .orElse(Collections.emptyList())
//                .stream().collect(Collectors.toMap(AppleDO::getWeight, AppleDO::getColor));
//        System.out.println(JSON.toJSON(collect3));

        // 解决办法: 重复key不异常的办法
        Map<Integer, AppleDO> collect4 = Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream().collect(Collectors.toMap(AppleDO::getWeight, Function.identity(),(key1, key2) -> key2));
        System.out.println(JSON.toJSON(collect4));



        // 4.List转Map ==> 然后分组
        Map<Integer, List<AppleDO>> collect5 = Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream().collect(Collectors.groupingBy(appleDO -> appleDO.getId()));

        System.out.println(JSON.toJSON(collect5));

    }
}
