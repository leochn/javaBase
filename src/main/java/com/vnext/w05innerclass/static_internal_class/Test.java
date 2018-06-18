package com.vnext.w05innerclass.static_internal_class;

/**
 * 静态内部类测试
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 18:29:15
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 1.静态内部类并不是一开始就创建的！它与静态成员不一样，并不能直接通过外部类名.内部类名的方式就可以直接访问并得到它的对象.
         *     通俗一点来说就是：静态内部类跟正常的一个外部类一样，它需要创建才能有！
         * 2.静态内部类对象的生命跟普通的对象一样，生命开始于开发者创建它，结束于系统回收它。
         * 3.静态内部类,不能使用任何外围类的非static成员变量和方法
         */

        //ImageLoader imageLoader = new ImageLoader();

        ImageLoader.Builder.staticMethodInBuilder();

        ImageLoader.Builder builder = new ImageLoader.Builder();
        builder.show();

        ImageLoader imageLoader = builder.build();
        System.out.println(imageLoader);
    }

}