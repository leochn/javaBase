package com.vnext.w22designpattern.d04singleton;

/**
 * 单例模式-饿汉式单例
 * 饿汉式单例是指在方法调用前，实例就已经创建好了
 *
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:16:34
 */
public class Person02 {

    // 私有的(private)唯一(static final)实例成员,在类加载的时候就创建好了单例对象
    private static final Person02 instance = new Person02();

    private Person02() { }

    // 静态工厂方法,返回此类的唯一实例
    public static Person02 getInstance() {
        return instance;
    }

}