package com.vnext.w15jdk8.lambda;

import org.junit.Test;

import java.util.*;

/**
 * @author leo
 * @version 2018/2/26 21:58
 * @since 1.0.0
 */
public class TestLambda1 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };
        TreeSet<String> ts = new TreeSet<>(com);
        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
    }

    //现在的 Lambda 表达式
    @Test
    public void test2(){
        Comparator<String> com = (x, y) -> Integer.compare(x.length(), y.length());
        TreeSet<String> ts = new TreeSet<>(com);
    }


    //需求：获取公司中年龄小于 35 的员工信息
    public List<Employee> filterEmployeeAge(List<Employee> emps){
        List<Employee> list = new ArrayList<>();
        for (Employee emp : emps) {
            if(emp.getAge() <= 35){
                list.add(emp);
            }
        }
        return list;
    }

    //需求：获取公司中工资大于 5000 的员工信息
    public List<Employee> filterEmployeeSalary(List<Employee> emps){
        List<Employee> list = new ArrayList<>();
        for (Employee emp : emps) {
            if(emp.getSalary() >= 5000){
                list.add(emp);
            }
        }
        return list;
    }

    @Test
    public void test3(){
        List<Employee> list = filterEmployeeAge(emps);
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("-----------------");
        List<Employee> list2 = filterEmployeeSalary(emps);
        for (Employee e: list2 ) {
            System.out.println(e);
        }
    }

    //优化方式一：策略设计模式
    public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp){
        List<Employee> list = new ArrayList<>();

        for (Employee employee : emps) {
            if(mp.test(employee)){
                list.add(employee);
            }
        }

        return list;
    }

    @Test
    public void test4(){
        List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("------------------------------------------");
        List<Employee> list2 = filterEmployee(emps, new FilterEmployeeForSalary());
        for (Employee employee : list2) {
            System.out.println(employee);
        }
    }
    //优化方式二：匿名内部类
    @Test
    public void test5(){
        List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getId() > 103;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式三：Lambda 表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployee(emps,(x) -> x.getAge() > 30);
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("=========================");
        List<Employee> list2 = filterEmployee(emps, (e) -> e.getSalary() >= 5000);
        list2.forEach(System.out::println);
    }

    //优化方式四：Stream API
    @Test
    public void test7(){
        emps.stream()
                .filter((e) -> e.getAge() <= 35)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");

        emps.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.out::println);
    }

    // 需求：用于处理字符串
    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }

    @Test
    public void test8(){
        String s = strHandler("helloworld", (str) -> str);
        System.out.println(s);
        String s1 = strHandler("\t\t\t 我大华威武   ", (str) -> str.trim());
        System.out.println(s1);
    }


    //需求：对于两个 Long 型数据进行处理
    public void strLong(Long l1,Long l2,MyFunction2<Long ,Long > mf){
        System.out.println(mf.getValue(l1,l2));
    }

    @Test
    public void test9(){
        strLong(120L,50L, (x,y) -> x + y);
        strLong(120L,50L, (x,y) -> x * y);
    }

}
