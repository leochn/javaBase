package com.vnext.w20proxy.p02jdkproxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * 1. 拦截器的invoke方法在什么时候执行?
 *      当在客户端,代理对象调用方法的时候,进入到了拦截器的invoke方法.
 * 2. 代理对象的方法体的内容是什么?
 *      拦截器的invoke方法的内容就是代理对象的方法的内容.
 * 3. 拦截器中的invoke方法中的参数method是谁在什么时候传递过来的?
 *      代理对象调用方法的时候,进入了拦截器中的invoke方法,所以invoke方法中的参数method就是代理对象调用的方法.
 * @author leo
 * @version 2018/6/4 6:53
 * @since 1.0.0
 */
public class JdkProxyTest {


    @Test
    public void testJdkProxy(){
        /**
         * 1. 创建一个目标对象
         * 2. 创建一个事务
         * 3. 创建一个拦截器
         * 4. 动态产生一个代理对象
         */
        Object target = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        MyInterceptor interceptor = new MyInterceptor(target, transaction);

        /**
         * 1.目标类的类加载器
         * 2.目标类实现的所有的接口
         * 3.拦截器
         */

        //不能用接口的实现类(PersonDaoImpl)来转换Proxy的实现类,它们是同级,应该用共同的接口(PersonDao)来转换
        PersonDao proxy = (PersonDao) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);
        // 生成的代理对象proxy,代理对象的方法(proxy.savePerson),就把目标对象(target)和切面(transaction)结合在一起了.
        // --> 代理方法 = 目标方法 + 通知
        // 目标方法和通知是完全松耦合的
        proxy.savePerson();

    }

}