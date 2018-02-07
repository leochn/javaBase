package com.vnext.w10generic;

/**
 * 泛型接口
 * @author leo
 * @version 2018/2/7 20:21
 * @since 1.0.0
 */
public interface JedisClient<T> {
    public abstract void show(T t);
}
