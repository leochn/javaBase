package com.vnext.w15jdk8.lambda;

/**
 * @author leo
 * @version 2018/2/26 22:11
 * @since 1.0.0
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
