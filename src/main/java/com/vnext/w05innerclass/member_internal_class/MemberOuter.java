package com.vnext.w05innerclass.member_internal_class;

/**
 * 成员内部类......相当于非静态方法
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 17:58:20
 */
public class MemberOuter {
    /**
     * 成员内部类:
     * 1.定义在另一个类(外部类)的内部，而且与成员方法和属性平级叫成员内部类
     * 2.创建成员内部类的实例使用：外部类名.内部类名 实例名 = 外部类实例名.new 内部类构造方法(参数),
     *     可以理解为隐式地保存了一个引用，指向创建它的外部类对象。
     * 3.在成员内部类中访问外部类的成员方法和属性时使用：外部类名.this.成员方法/属性
     * 4.内部类在编译之后生成一个单独的class文件，里面包含该类的定义，所以内部类中定义的方法和变量可以跟父类的方法和变量相同。
     *     例如下面定义的类的class文件分别是：MemberOuter.class和MemberOuter$MemberInner.class两个文件。
     * 5.外部类无法直接访问成员内部类的方法和属性，需要通过内部类的一个实例来访问
     * 6.与外部类平级的类继承内部类时，其构造方法中需要传入父类的实例对象。
     *     且在构造方法的第一句调用“外部类实例名.super(内部类参数)”。
     */

    private int a = 3;
    private MemberInner memberInner;

    public MemberOuter(){
        memberInner = new MemberInner();
    }

    public int getInnerA(){
        return memberInner.a;  // 引用内部类的变量，需通过实例
    }

    public class MemberInner {
        public int a = 2;

        public void doSomething() {
            // 在成员内部类中访问外部类的成员方法和属性时使用：外部类名.this.成员方法/属性
            System.out.println(MemberOuter.this.a);  // 这块要注意......很重要！！！
            System.out.println(this.a);
        }
    }
}

//class Extender1 extends MemberOuter.MemberInner{
//    public Extender1(MemberOuter outer){
//        //外部类实例名.super(内部类参数列表)
//        outer.super();
//    }
//}