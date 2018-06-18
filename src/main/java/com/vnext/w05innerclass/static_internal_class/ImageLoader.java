package com.vnext.w05innerclass.static_internal_class;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 18:24:45
 */
public class ImageLoader {

    private Context context;
    private int num = 10;
    private static int i = 1;


    static {
        System.out.println("ImageLoader静态代码块");
    }

    public static void staticMethodInImageLoader() {
        System.out.println("staticMethodInImageLoader........, ImageLoader.i = " + i);
    }

    public ImageLoader(){
        System.out.println("ImageLoader构造方法");
    }

    public ImageLoader(Builder builder) {
        this.context = builder.context;
    }

    public Context getContext() {
        return context;
    }


    public static class Builder {

        private Context context;

        static {
            System.out.println("Builder静态代码块");
        }

        public Builder(){
            System.out.println("Builder构造方法");
        }


        public Builder with(Context context) {
            this.context = context;
            return this;
        }

        public ImageLoader build() {
            return new ImageLoader(this);
        }

        public void show (){
            System.out.println("Builder...show....");
        }

        /**
         * 静态内部类只能访问外围类的静态成员变量和方法
         * 不能访问外围类的非静态成员变量和方法
         */
        static void staticMethodInBuilder() {
            System.out.println("staticMethodInBuilder --> ImageLoader.i = " + i);// 静态内部类只能访问外部类的静态成员
            staticMethodInImageLoader();// 包括静态变量和静态方法
        }

    }
}