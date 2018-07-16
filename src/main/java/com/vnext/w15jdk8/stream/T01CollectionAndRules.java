package com.vnext.w15jdk8.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * java8多规则过滤集合
 * @author leo
 * @version 1.0.0
 * @date 2018-07-17 06:40:57
 */
public class T01CollectionAndRules {
    /**
     * 场景:
     * 对于相同一个集合数据，不同场景会有不同过滤条件，如果每个都动态的实现的话，那么，如果多个地方有相同的过滤规则的话，那么就会出现代码过高的问题。
     * 写个接口，接口参数为被过滤的数据集合+ 过滤规则，返回被过滤的结果
     */

    public static void main(String[] args) {

        List<Person> persons = IntStream.range(1, 100).mapToObj(i -> {
            System.out.println(i);
            Person person = new Person();
            person.setName("Name" + i);
            person.setAge(i);
            person.setSex(i % 2);
            person.setSharp("" + i);
            person.setStudent(i % 2 == 1);
            return person;
        }).collect(Collectors.toList());

        Predicate<Person> rule1 = Person::getStudent;
        //Predicate<Person> rule11 = Person::getName;
        Predicate<Person> rule2 = person -> person.getSex() == 1;
//        Predicate<Person> negate = rule2.negate();
//        System.out.println(negate.test(persons.get(1)));

        Predicate<Person> rule3 = person -> Objects.equals(person.getName(), "Name2");
        List<Predicate<Person>> rules = new ArrayList<>();
        //rules.add(rule1);
        //rules.add(rule2);
        rules.add(rule3);
        long start = System.currentTimeMillis();
        System.out.println(start);
        List<Person> newPersons2 = filterUsingPredicate(persons, rules);
        List<Person> newPersons = customFilter(persons, rules);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("newPersons.size: " + newPersons.size());
        System.out.println("newPersons2.size: " + newPersons2.size());
        System.out.println(newPersons.get(0));
        System.out.println(newPersons2.get(0));
    }

    /**
     * 根据过滤规则过滤集合
     *
     * @param persons 数据集合
     * @param mappers 规律规则
     * @param <I>     数据类型
     * @return 过滤后的数据集合
     */
    private static <I> List<I> customFilter(Collection<I> persons, List<Predicate<I>> mappers) {
        Stream<I> iStream = persons.stream();
        return iStream.filter(ele -> {
            int compareSum = mappers.stream()
                    .mapToInt(mapper -> mapper.test(ele) ? 1 : 0).sum();
            return compareSum == mappers.size();
        }).collect(Collectors.toList());
    }

    /**
     * 根据过滤规则过滤集合
     *
     * @param persons 数据集合
     * @param mappers 规律规则
     * @param <I>     数据类型
     * @return 过滤后的数据集合
     */
    private static <I> List<I> filterUsingPredicate(Collection<I> persons, List<Predicate<I>> mappers) {
        return persons.stream()
                .filter(ele -> mappers.stream()
                        .reduce(t -> true, Predicate::and)
                        .test(ele)).collect(Collectors.toList());
    }

}

@Data
class Person {
//    setName("Name" + i)
////                    .setAge(i)
////                    .setSex(i % 2)
////                    .setSharp("" + i)
////                    .setStudent(i % 2 == 1);

    private String name;
    private int age;
    private int sex;
    private String sharp;
    private Boolean student;
}