package com.vnext.w10generic;

/**
 * //第二种情况：实现接口的时候不知道什么类型
 * @author leo
 * @version 2018/2/7 20:23
 * @since 1.0.0
 */
public class JedisClientSingle2<T> implements JedisClient<T> {

    @Override
    public void show(T t) {
        System.out.println("输入t为:" + t);
    }
}
