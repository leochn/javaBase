package com.vnext.w22designpattern.d17mediator.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:52:21
 */
public class Test {

    /**
     * 未采用中介模式，自己找对象...
     */

    public static void main(String[] args) {
        Person zhangsan = new Man("张三",5);
        Person lisi = new Man("李四",6);

        Person xiaofang = new Woman("小芳", 6);

        zhangsan.getPartner(xiaofang);
        lisi.getPartner(xiaofang);
        zhangsan.getPartner(lisi);

    }

}