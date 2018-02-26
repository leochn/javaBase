package com.vnext.w15jdk8.lambda;

/**
 * @author leo
 * @version 2018/2/26 22:12
 * @since 1.0.0
 */
public class FilterEmployeeForSalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getSalary() >= 5000;
    }

}
