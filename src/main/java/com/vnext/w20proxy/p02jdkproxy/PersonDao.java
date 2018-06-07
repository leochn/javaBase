package com.vnext.w20proxy.p02jdkproxy;

/**
 * 目标对象实现的接口，用JDK来生成代理对象一定要实现一个接口
 * @author leo
 * @version 2018/6/4 6:51
 * @since 1.0.0
 */
public interface PersonDao {

    /**
     * 目标方法
     */
    public void savePerson();
}