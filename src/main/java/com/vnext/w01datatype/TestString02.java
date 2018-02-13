package com.vnext.w01datatype;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author leo
 * @since 2018/2/13 11:20
 */
public class TestString02 {

    @Test
    public void test01() {
        String str1 = "abccdefghijkbcc";
        String str2 = "bcc";
        String str3 = "jkbcc";
        System.out.println(str2.length());   // 3
        System.out.println(str1.charAt(10)); // j
        System.out.println(str1.equals(str2));   // false
        System.out.println(str2.equals("abcc")); // false
        System.out.println(str1.compareTo(str2));// -1
        // public int indexOf(String s)：返回s字符串在当前字符串中首次出现的位置。若没有，返回-1
        System.out.println(str1.indexOf("fgh")); // 6
        // public int indexOf(String s ,int startpoint)：返回s字符串从当前字符串startpoint位置开始的，首次出现的位置
        System.out.println(str1.indexOf(str2, 5)); // 12
        // lastIndexOf(String s):返回s字符串最后一次在当前字符串中出现的位置。若无，返回-1
        System.out.println(str1.lastIndexOf(str2)); // 12
        // public boolean startsWith(String prefix):判断当前字符串是否以prefix开始
        System.out.println(str1.startsWith("abcd"));// false
        // regionMatches(int firstStart,String other,int otherStart ,int length): 判断当前字符串从firstStart开始的子串与另一个字符串other从otherStart开始，length长度的字串是否equals
        System.out.println(str1.regionMatches(10, str3, 0, str3.length())); // true
    }

    @Test
    public void test02(){
        String str = "去除当前字符串中首尾出现的空格";
        System.out.println(str.substring(1));
        // substring(int start,int end):返回从start开始到end结束的一个左闭右开的子串。start可以从0开始的。
        String str2 = str.substring(2, 5);
        System.out.println(str2);  // 当前字
        // public String trim()：去除当前字符串中首尾出现的空格，若有多个，就去除多个。
        String str5 = "   abc   d  ";
        String str6 = str5.trim();
        System.out.println("----" + str6 + "----");
        System.out.println("----" + str5 + "----");
        // public String concat(String str):连接当前字符串与str
        String str7 = str.concat("hello");
        System.out.println(str7); // 去除当前字符串中首尾出现的空格hello

        String str8 = "abc*d-e7f-ke";
        // public String[] split(String regex)：按照regex将当前字符串拆分，拆分为多个字符串，整体返回值为String[]
        String[] strs = str8.split("-");
        for(int i = 0;i < strs.length;i++){
            System.out.println(strs[i]);
        }
    }

    @Test
    public void test03(){
        // 1.字符串 与基本数据类型、包装类之间转换
        //      字符串 --->基本数据类型、包装类:调用相应的包装类的parseXxx(String str);
	    //      基本数据类型、包装类--->字符串:调用字符串的重载的valueOf()方法
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);
        String str2 = i + "";
        String str3 = String.valueOf(i);
        System.out.println(str2 +","+ str3);
        System.out.println("===============");

        // 2.字符串与字节数组间的转换
        //      字符串---->字节数组:调用字符串的getBytes()
        //      字节数组---->字符串：调用字符串的构造器
        String str4 = "abcd123";
        byte[] bytes = str4.getBytes();
        for (int j = 0; j < bytes.length; j++) {
            System.out.println((char) bytes[j]);
        }
        String str5 = new String(bytes);
        System.out.println(str5);
        System.out.println("=================");

        // 3.字符串与字符数组间的转换
        //      字符串---->字符数组：调用字符串的toCharArray();
        String str6 = "abcd123字符串";
        char[] chars = str6.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            System.out.println(chars[j]);
        }
        String str7 = new String(chars);
        System.out.println(str7);
    }


    //1.模拟一个trim方法，去除字符串两端的空格。
    private String myTrim(String str){
        int start = 0;
        int end = str.length() - 1;
        while(start < end && str.charAt(start) == ' '){
            start++;
        }
        while(start < end && str.charAt(end) == ' '){
            end--;
        }
        return str.substring(start, end + 1);
    }

    //2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
    private String reverseString(String str,int start,int end){
        char[] c = str.toCharArray();//字符串--->字符数组
        for(int i = start,j = end;i < j;i++,j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        //字符数组--->字符串
        return new String(c);
    }

    // 2.将一个字符串进行反转。将字符串中指定部分进行反转
    private String reverseString1(String str, int start, int end){
        String str1 = str.substring(0,start);
        for (int i = end; i > start ; i--) {
            char c = str.charAt(i);
            str1 += c;  // 效率差，可以考虑StringBuffer
        }
        str1 += str.substring(end + 1);
        return str1;
    }

    // 3.获取一个字符串在另一个字符串中出现的的次数
    public int getCount(String str1, String str2){
        int count = 0;
        int len;
        while ((len = str1.indexOf(str2)) != -1){
            count++;
            str1 = str1.substring(len + str2.length());
        }
        return count;
    }

    // 4.对字符串中字符进行自然排序
    public String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Test
    public void test(){
        String s = myTrim("   abc  de  ");
        System.out.println(s);
        String str1 = "abcdefg";
        String reverseStr = reverseString(str1, 2, 5);
        System.out.println(str1 + "反转为:"+ reverseStr);
    }




}
