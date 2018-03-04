/**
 * 
 */
package com.vnext.w17jvm;

/**
 * 初始的对象在eden区
 * @author leo
 * @since 2018-02-06 17:59:40
 */
public class TestJVM01 {


    public static void main(String[] args) {
        //初始的对象在eden区
        //参数：-Xmx64M -Xms64M -XX:+PrintGCDetails
		for(int i=0; i< 5; i++){
			byte[] b = new byte[1024*1024];
		}

        /**
         Heap
         PSYoungGen      total 18944K, used 8418K [0x00000000feb00000, 0x0000000100000000, 0x0000000100000000)
         eden space 16384K, 51% used [0x00000000feb00000,0x00000000ff338858,0x00000000ffb00000)
         from space 2560K, 0% used [0x00000000ffd80000,0x00000000ffd80000,0x0000000100000000)
         to   space 2560K, 0% used [0x00000000ffb00000,0x00000000ffb00000,0x00000000ffd80000)
         ParOldGen       total 44032K, used 0K [0x00000000fc000000, 0x00000000feb00000, 0x00000000feb00000)
         object space 44032K, 0% used [0x00000000fc000000,0x00000000fc000000,0x00000000feb00000)
         Metaspace       used 3503K, capacity 4496K, committed 4864K, reserved 1056768K
         class space    used 385K, capacity 388K, committed 512K, reserved 1048576K
         */
    }



}
