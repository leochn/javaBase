package com.vnext.w20proxy.p03jdkproxysuper;

/**
 * @author leo
 * @version 2018/6/4 6:51
 * @since 1.0.0
 */
public class PersonDaoImpl implements PersonDao {
    public void savePerson() {
        System.out.println("save person");
    }

    @Override
    public void updatePerson() {
        System.out.println("update person");
    }
}