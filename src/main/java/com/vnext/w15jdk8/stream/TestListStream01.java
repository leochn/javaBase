package com.vnext.w15jdk8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author leo
 * @version 2018/5/24 19:39
 * @since 1.0.0
 */
public class TestListStream01 {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User(1, "a"),
                new User(1, "b"),
                new User(2, "b"),
                new User(1, "a"));

        users.parallelStream().filter(distinctByKey(User::getId))
                .forEach(System.out::println);
        /**
         * 当然，如果是并行stream，则取出来的不一定是第一个，而是随机的。
         * 上述方法是至今发现最好的，无侵入性的。但如果非要用distinct。只能像HashSet那个方法一样重写hashcode和equals。
         */
        System.out.println("=====================");
        users.parallelStream().filter(distinctByKey(User::getName))
                .forEach(System.out::println);
        System.out.println("----------------------");


        List<DeviceInfo> deviceList = Arrays.asList(
                new DeviceInfo(9527946,959394,15120162,"低区罐式无负压供水设备"),
                new DeviceInfo(9527947,959394,15120163,"中区罐式无负压供水设备"),
                new DeviceInfo(9527950,959394,15120165,"高区罐式无负压供水设备"),
                new DeviceInfo(9527950,959394,15120166,"超高区罐式无负压供水设备"),
                new DeviceInfo(9592456,952134,17020171,"低区供水设备"),
                new DeviceInfo(9592749,952134,17020172,"中区供水设备"),
                new DeviceInfo(9592950,952134,17020173,"中区供水设备")
        );
        deviceList.parallelStream().filter(distinctByKey(DeviceInfo::getProductName)).forEach(System.out::println);
        System.out.println("------------------------");
        List<DeviceInfo> list = new ArrayList<>();
        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            int deviceId = (int) Math.random()*1000;
            int projectId = (int) Math.random()*100;
            int phId = (int) Math.random()*10;
            String name = String.valueOf(i);
            DeviceInfo deviceInfo = new DeviceInfo(deviceId,projectId,phId,name);
            list.add(deviceInfo);
        }
        long l = System.currentTimeMillis();
        System.out.println("生成list耗时= " + (l-l2));
        List<DeviceInfo> collect = list.stream().filter(distinctByKey(DeviceInfo::getProductName)).collect(Collectors.toList());
        long l1 = System.currentTimeMillis();
        System.out.println("stream耗时=" + (l1-l) + ",size="+ collect.size());

        List<DeviceInfo> result = new LinkedList<>();
        for (DeviceInfo deviceInfo : list) {
            // 这种方法速度太慢了...
           /* boolean b = result.stream().anyMatch(u -> u.getProductName().equals(deviceInfo.getProductName()));
            if (!b){
                result.add(deviceInfo);
            }*/
        }
        long l3 = System.currentTimeMillis();
        System.out.println("for循环耗时="+ (l3-l1) + " ,size=" + result.size());
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}

@Data
@AllArgsConstructor
class DeviceInfo{
    private Integer deviceId;
    private long projectId;
    private long phId;
    private String productName;

}