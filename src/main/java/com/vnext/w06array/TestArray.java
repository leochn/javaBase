package com.vnext.w06array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组
 * @author leo
 * @version 2018/2/7 19:46
 * @since 1.0.0
 */
public class TestArray {

    @Test
    public void test01() {
        int[] s;
        s = new int[10];
        // int[] s=new int[10];
        // 基本数据类型数组如果没有赋初值，Java自动给他们赋默认值。
        for (int i = 0; i < 10; i++) {
            s[i] = 2 * i + 1;
            System.out.println(s[i]);
        }
    }

    /**
     二维数组格式：
     A:数据类型[][] 数组名 = new 数据类型[m][n];
     B:数据类型[][] 数组名 = new 数据类型[m][];
     C:数据类型[][] 数组名 = new 数据类型[][]{{...},{...},{...}};
     D:数据类型[][] 数组名 = {{...},{...},{...}};

     */
    @Test
    public void test02(){
        int[][] arr = {{1,2,3},{4,5},{6}};
        System.out.println(Arrays.deepToString(arr));
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[0][0]);
        System.out.println(arr[2][0]);
    }

}
