package com.vnext.w23sourcecode.A02mybatis.sql;

import com.vnext.w23sourcecode.A02mybatis.orm.mybatis.MyBatisInvocationHandler;
import com.vnext.w23sourcecode.A02mybatis.orm.mybatis.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @Auther: LEO
 * @Date: 2019/1/22 18:16
 * @Description:
 */
public class SqlSession {

    // 加载Mapper接口
    public static <T> T getMapper(Class classz) {
        return (T) Proxy.newProxyInstance(classz.getClassLoader(), new Class[] { classz },
                new MyBatisInvocationHandler(classz));
    }

    // 加载Mapper接口
    public static <T> T getTestMapper(Class classz) {
        return (T) Proxy.newProxyInstance(classz.getClassLoader(), new Class[] { classz },
                new MyInvocationHandler(classz));
    }
}
