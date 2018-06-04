package com.vnext.w20proxy.P05cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author leo
 * @version 2018/6/5 6:32
 * @since 1.0.0
 */
public class MyInterceptor implements MethodInterceptor {
    /**
     * 导入cglib包
     *      <dependency>
     * 			<groupId>cglib</groupId>
     * 			<artifactId>cglib</artifactId>
     * 			<version>3.2.6</version>
     * 		</dependency>
     *
     */

    private Object target;//目标类
    private Transaction transaction;


    public MyInterceptor(Object target, Transaction transaction) {
        super();
        this.target = target;
        this.transaction = transaction;
    }

    public Object createProxy(){
        //代码增强类 Enhancer
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);  //参数为拦截器
        enhancer.setSuperclass(target.getClass()); //生成的代理类的父类是目标类
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.transaction.beginTransaction();
        method.invoke(target);
        this.transaction.commit();
        return null;
    }
}