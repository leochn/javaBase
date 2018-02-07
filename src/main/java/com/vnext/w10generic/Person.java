package com.vnext.w10generic;

/**
 * @author leo
 * @version 2018/2/7 20:12
 * @since 1.0.0
 */
public class Person <A> {
    private A info;
    public Person(){

    }
    public Person(A info) {
        this.info = info;
    }
    public void setInfo(A info) {
        this.info = info;
    }
    public A getInfo() {
        return info;
    }
    @Override
    public String toString() {
        return "信息:" + info.toString();
    }

    //不可以在静态方法中使用类型参数
	/*public static void test(A a) {

	}  */

	// 泛型方法
    public <T> void show(T t){   // 把泛型定义在方法上
        System.out.println("输入t为:" + t);
    }


}
