package com.vnext.w02operator;

import org.junit.Test;

/**
 * @author leo
 * @since 2018-02-07 10:09:59
 */
public class TestOperator02 {

    /**
     * 位运算符
     */
    @Test
    public void testBit(){
        int i1 = 31;

        System.out.println(i1<<3);//248
        System.out.println(i1<<28);// -268435456

        System.out.println(i1>>2);//7
        System.out.println(i1>>>2);//7

        int i2 = -31;
        System.out.println(i2>>2);//-8
        System.out.println(i2>>>2);//1073741816

        System.out.println(12 & 5);//4
        System.out.println(12 | 5);//13
        System.out.println(12 ^ 5);//9
        System.out.println(~12);//-13
    }

    /**
     * 三元运算符
     */
    @Test
    public void test(){
        int i = 20;
        int j = 20;
        //此时max记录了i与j的较大值
        int max = (i > j)? i : j;

        //String str = (i > j)? "i大" : "j大";
        String str = (i > j)? "i大" : (i == j)? "相等" : "j大";

        //String str1 = (i > j)? i : "j大";
        System.out.println(max);
        System.out.println(str);

        //互换
        if(i >= j){
            System.out.println("较大值为：" + i);
        }else{
            System.out.println("较大值为：" + j);
        }

        //练习：如何使用三元运算符，输出三个数中的较大值。
        int m = 12;
        int n = 23;
        int k = -9;
        int max1 = (m > n)? m : n;
        int max2 = (max1 > k)? max1 : k;
        System.out.println(max2);
    }

}
