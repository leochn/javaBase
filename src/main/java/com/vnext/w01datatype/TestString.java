package com.vnext.w01datatype;

import org.junit.Test;

/**
 * @author leo
 * @since 2018/2/12 17:25
 */
public class TestString {

    @Test
    public void test01(){
        String s0 = "hello";
        String s1 = "hello";
        String s2 = "he" + "llo";
        System.out.println(s0 == s1);  //true
        System.out.println(s0 == s2);  //true
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s0 == s3);  //false
        System.out.println(s4 == s3);  //false
    }


}
