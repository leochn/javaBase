package com.vnext.w20proxy.p02jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 拦截器,作用：
 * 1.目标类导入进来
 * 2.事务导入进来
 * 3.invoke需要完成的：
 *      1).开启事务
 *      2).调用目标对象的方法
 *      3).事务的提交
 *
 * @author leo
 * @version 2018/6/4 7:03
 * @since 1.0.0
 */
public class MyInterceptor implements InvocationHandler {

    private Object target;   // 目标类
    private Transaction transaction;

    public MyInterceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        if ("savePerson".equals(methodName) || "updatePerson".equals(methodName) || "deletePerson".equals(methodName)){
            this.transaction.beginTransaction();  // 开启事务
            method.invoke(target);                // 调用目标方法
            this.transaction.commit();            // 事务的提交
        }else {
            method.invoke(target);
        }
        return null;
    }
}