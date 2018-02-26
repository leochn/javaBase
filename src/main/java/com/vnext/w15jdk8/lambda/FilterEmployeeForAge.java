package com.vnext.w15jdk8.lambda;

/**
 * @author leo
 * @version 2018/2/26 22:11
 * @since 1.0.0
 */
public class FilterEmployeeForAge implements MyPredicate<Employee>{

    @Override
    public boolean test(Employee t) {
        return t.getAge() <= 35;
    }

}
