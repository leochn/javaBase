package com.vnext.w07keywords;

/**
 * @author leo
 * @version 2018/2/7 19:55
 * @since 1.0.0
 */
public class TestKeywords {

//    public int addOne(final int x){
//        return ++x;
//    }

    /**
     * final关键字
         最终的, 可以修饰类和方法和属性.
         修饰类表明这个类不可以有子类继承(不可被扩展)
         修饰方法表明这个方法不可以在子类中被重写(不可被扩展)
         修饰属性表明这个属性是常量, 只能赋值一次,不可以再修改.
     * @param o
     */
    public void addTwo(final Other o){
        o.i++;
        System.out.println(o.i);
    }

    public static void main(String[] args) {
        Other o = new Other();
        new TestKeywords().addTwo(o);
    }

}

class  Other {
    public int i;
}
