package com.vnext.w20proxy.p01staticproxy;

/**
 * @author leo
 * @version 2018/6/4 6:52
 * @since 1.0.0
 */
public class PersonDaoProxy implements PersonDao{
    private PersonDao personDao;
    private Transaction transaction;

    public PersonDaoProxy(PersonDao personDao,Transaction transaction) {
        super();
        this.personDao = personDao;
        this.transaction = transaction;
    }

    public void savePerson() {
        /**
         * 1、开启事务
         * 2、执行目标方法
         * 3、事务提交
         * 静态代理模式，并没有做到代码的重用(开启事务和事务提交)
         */
        this.transaction.beginTransaction();
        this.personDao.savePerson();
        this.transaction.commit();
    }
}