package com.vnext.w03variable;

/**
 * 变量：基本数据类型（8个） vs 引用数据类型（类、接口、数组）
 * java中的变量定义的格式：数据类型  变量名 = 初始化值
 * @author leo
 * @since 2018-02-07 17:30:53
 */
public class TestVariable01 {
	/*
	 成员变量和局部变量的主要区别
	(1)在类中的位置不同
		成员变量：定义在类中，在整个类中都可以被访问。
		局部变量：定义在局部范围内，如：方法内，代码块内等。
	(2)在内存中的位置不同
		成员变量：在堆中
		局部变量：在栈中
	(3)生命周期不同
		成员变量：随着对象的创建而存在，随着对象的消失而消失,(从new开始,到GC销毁为止)
		局部变量：随着方法的调用而存在，随着方法的调用完毕而消失,(方法入栈时)
	(4)初始化值不同
		成员变量：不需要,因为JVM在创建对象的时候给它赋了默认值
		局部变量：出形参外都必须要有初始值
	局部变量:
		永远保存在栈区, 而且会随着方法的结束而消亡.
	实例变量:
		保存在GC区,只要对象还在,则实例变量还在.因为实例变量是类的成员,所以它可以被其他的类的成员直接访问.
	*/

    /*
    成员变量和局部变量,相同点：
        1.遵循变量声明的格式： 数据类型 变量名 = 初始化值
        2.都有作用域

    成员变量和局部变量,不同点：
        1.声明的位置的不同
            成员变量：声明在类里，方法外
            局部变量：声明在方法内，方法的形参部分，代码块内
        2.成员变量的修饰符有四个：public, private, protected, 缺省(default)
            局部变量没有修饰符，与所在的方法修饰符相同。
        3.初始化值：
            一定会有初始化值。
                成员变量:如果在声明的时候，不显式的赋值，那么不同数据类型会有不同的默认初始化值。
                    byte,  short,  int,  long  ==>0
                    float,  double  ==>0.0
                    char   ==> 空格
                    Boolean   ==>false
                    引用类型变量 ==>null
                 局部变量：一定要显式的赋值。（局部变量没有默认初始化值）
        4.二者在内存中存放的位置不同:成员变量存在于堆空间中；局部变量：栈空间中
    总结：
        关于变量的分类：
          1）按照数据类型的不同：基本数据类型（8种）  & 引用数据类型
          2）按照声明的位置的不同：成员变量 & 局部变量
    */


    public static void main(String[] args) {
        //2.变量得先定义，后使用
        int myInt1 = 10;
        double d = 12.3;

        System.out.println(myInt1);
        System.out.println(myInt1 + d);
        //i1超出了其作用的范围，不可使用。
        //System.out.println(i1);

        //3.整型：byte(-128~+127)  short  int（默认类型） long
        byte b1 = 12;
        //byte b2 = 128;
        short s1 = 128;
        int i1 = 12;

        //定义long型变量，值的末尾加“L”或“l”
        long l1 = 2134123351345325L;
        System.out.println(l1);

        //4.浮点型（带小数点的数值）：float   double（默认类型）
        double d1 = 12.3;
        //声明float类型的浮点型数据，末尾要加“F”或者“f”
        float f1 = 12.3F;
        System.out.println(f1);

        //5.字符型（=两个字节）：char 只能表示一个字符(英文、中文、标点符号、日文、。。。)
        char c1 = 'a';
        //char c2 = 'ab';
        String str = "ab";
        char c3 = '中';
        String str1 = "中国";
        //可以表示转义字符
        char c4 = '\t';
        char c5 = '\n';
        System.out.println("abc" + c5 + "def");

        //了解
        char c6 = '\u1234';
        System.out.println(c6);

        //6.布尔类型：boolean  只能够取值为true 或 false 。不能取值null
        boolean bool1 = true;
        if(bool1){
            System.out.println("老师是个\"帅\"哥");
        }else{
            System.out.println("你在说谎！");
        }

    }

    public void method1(){
        int i1 = 10;
        System.out.println(i1);
    }


}
