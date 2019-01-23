package com.vnext.w23sourcecode.A02mybatis.orm.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: LEO
 * @Date: 2019/1/22 18:27
 * @Description:
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("测试使用动态代理......");
        return 1;
    }
}
