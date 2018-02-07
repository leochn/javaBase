package com.vnext.w10generic;

/**
 * //第一种情况：实现接口的时候知道类型
 * @author leo
 * @version 2018/2/7 20:23
 * @since 1.0.0
 */
public class JedisClientSingle implements JedisClient<String> {

    @Override
    public void show(String s) {
        System.out.println("输入t为:" + s);
    }
}
