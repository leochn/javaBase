package com.vnext.w03variable;

/**
 * 变量之间的运算：(不考虑boolean。剩下：char byte short int long float double)
 * 1.自动类型转换
 * 2.强制类型转换
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 08:20:46
 */
public class TestVariable02 {

    public static void main(String[] args){
        //1.自动类型转换:当容量小的数据类型与容量大的数据类型做运算时，容量小的会自动转换为
        //容量大的数据类型:char,byte,short ===>int ===>long ===>float===double
        int i1 = 12;
        short s1 = 2;
        int i2 = i1 + s1;
        float f1 = 12.3F;
        float f2 = f1 + i2;
        //float d1 = f2 + 12.3;

        long l = 12L;
        float f3 = l;
        System.out.println(i2);
        System.out.println(f2);

        char c1 = 'a';//97
        c1 = 'A';//65
        int i3 = c1 + 1;
        System.out.println(i3);

        //需要注意的：当char\byte\short之间做运算时，默认的结果为int类型
        short ss1 = 12;
        byte bb1 = 1;
        char cc1 = 'a';
        //short ss2 = ss1 + bb1;
        int ii1 = ss1 + bb1;
        //char cc2 = cc1 + bb1;
        int ii2 = cc1 + bb1;
        short ss2 = 11;
        //short ss3 = ss1 + ss2;

        //2.强制类型转换：容量大转换为容量小的.要使用强制类型转换符：()
        //强制类型转换的问题：导致精度的损失
        long l1 = 12345L;
        int m1 = (int)l1;
        System.out.println(m1);

        byte by1 = (byte)m1;
        System.out.println(by1);

        //平时常用的字符串,也是一种数据类型：String
        String nation = "我是一个中国人";
        System.out.println(nation);
        //字符串与基本数据类型之间的运算:只能是连接运算：+。得到的结果仍为一个字符串
        String str = "abc";
        String str1 = str + m1;//abc12345
        System.out.println(str1);

        //题目：
        String st1 = "hello";
        int myInt1 = 12;
        char ch1 = 'a';//97
        System.out.println(str1 + myInt1 + ch1);//hello12a
        System.out.println(myInt1 + ch1 + str1);//109hello
        System.out.println(ch1 + str1 + myInt1);//ahello12

        String st2 = "12";
        st2 = 12 + "";
        System.out.println(st2);
    }
}