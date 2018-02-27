package com.vnext.w15jdk8.lambda;/**
 * @author leo
 * @data 2018/2/27
 */

/**
 *
 * @author leo
 * @since 2018/2/27 9:07
 */
@FunctionalInterface
public interface MyFunction2<T, R> {

    public R getValue(T t1, T t2);

}
