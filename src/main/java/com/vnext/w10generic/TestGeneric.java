package com.vnext.w10generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo
 * @version 2018/2/7 20:11
 * @since 1.0.0
 */
public class TestGeneric {

    //自定义泛型类测试
    @Test
    public void test01() {
        Person p = new Person();
        p.setInfo(20);
        System.out.println(p);   //信息:20
        Person<String> p2 = new Person<String>();
        p2.setInfo("张三");
        System.out.println(p2);  //信息: 张三
    }

    //自定义泛型类测试
    @Test
    public void test02() {
        Person p = new Person();
        p.show("hello");
        p.show(1000);
        p.show(true);
    }

    // 泛型和继承的关系
    @Test
    public void testJedisClientSingle() {
        //第一种情况：实现接口的时候知道类型
        JedisClient<String> single = new JedisClientSingle();
        single.show("helloWorld");  //输入t为:helloWorld

        //第二种情况：实现接口的时候不知道什么类型
        JedisClient<String> single2 = new JedisClientSingle2<String>();
        single2.show("helloJava");  //输入t为:helloJava
        JedisClient<Integer> single3 = new JedisClientSingle2<Integer>();
        single3.show(10000);         //输入t为:10000
    }

    // 泛型和继承的关系
    @Test
    public void testDao(){
        UserInfoDao userInfoDao = new UserInfoDao();
        String str = userInfoDao.Add("HelloWorld");
        System.out.println(str);  // HelloWorld
    }

    /**
     1.类型通配符：?
        比如：List<?> , Map<?,?>
        List<?>是List<String>、List<Object>等各种泛型List的父类。
     2.读取List<?>的对象list中的元素时，永远是安全的，因为不管list的真实类型是什么，它包含的都是Object。
     3.写入list<?>中的元素时,不行。因为我们不知道c的元素类型,我们不能向其中添加对象。唯一的例外是null，它是所有类型的成员。
     */
    @Test
    public void test1() {
        List<String> list0 = new ArrayList<String>();
        list0.add("aaa");
        list0.add("bbb");
        List<?> list = list0;
        //list.add("ccc"); // 不可以添加字符
        list.add(null);
        list.add(null);
        list.add(null);
        for (Object obj : list) {
            System.out.println(obj);
        }  //aaa		bbb		null		null		null
    }


}
