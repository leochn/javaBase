package com.vnext.w20proxy.p01staticproxy;

import org.junit.Test;

/**
 * @author leo
 * @version 2018/6/4 6:53
 * @since 1.0.0
 */
public class StaticProxyTest {
    /**
     * 静态代理模式:
     * 1.静态代理模式并没有做到事务的重用.
     * 2.假设dao层有100个类，100个proxy，接口中有多少个方法，在proxy层就得实现多少个方法，有多少个方法就要开启可提交多少个事务.
     * 3.如果一个proxy实现了多个接口，如果其中的一个接口发生了变化(添加了一个方法)，那么proxy也要做相应的改变.
     *
     * 解决上面问题的方法,代理类动态产生就可以了.
     *
     */

    @Test
    public void testStaticProxy(){
        PersonDao personDao = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        PersonDaoProxy proxy = new PersonDaoProxy(personDao, transaction);
        proxy.savePerson();
    }

}