package com.vnext.w17jvm;

/**
 * 测试进入老年代的对象
 * @author leo
 * @version 2018/3/2 22:03
 * @since 1.0.0
 */
public class TestJVM02 {

    public static void main(String[] args) {

        //测试进入老年代的对象

        // -XX:MaxTenuringThreshold=15 表示进过15次GC，对象进入老年代

        //参数：-Xmx1024M -Xms1024M -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintGCDetails
        //-XX:+PrintHeapAtGC

		for(int k = 0; k<20; k++) {
			for(int j = 0; j<300; j++){
				byte[] b = new byte[1024*1024]; // 1M
			}
		}


        /**
         [GC (Allocation Failure) [DefNew: 278925K->861K(314560K), 0.0026899 secs] 278925K->861K(1013632K), 0.0027431 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279698K->770K(314560K), 0.0015224 secs] 279698K->770K(1013632K), 0.0015530 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 280129K->770K(314560K), 0.0012823 secs] 280129K->770K(1013632K), 0.0013147 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279656K->770K(314560K), 0.0033914 secs] 279656K->770K(1013632K), 0.0035266 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279695K->770K(314560K), 0.0036455 secs] 279695K->770K(1013632K), 0.0037279 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279720K->770K(314560K), 0.0034265 secs] 279720K->770K(1013632K), 0.0035428 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279736K->770K(314560K), 0.0012052 secs] 279736K->770K(1013632K), 0.0012377 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279746K->770K(314560K), 0.0012419 secs] 279746K->770K(1013632K), 0.0012728 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279753K->770K(314560K), 0.0012917 secs] 279753K->770K(1013632K), 0.0013178 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279757K->770K(314560K), 0.0014737 secs] 279757K->770K(1013632K), 0.0015073 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279760K->770K(314560K), 0.0011739 secs] 279760K->770K(1013632K), 0.0012015 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279762K->770K(314560K), 0.0013310 secs] 279762K->770K(1013632K), 0.0013619 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279763K->770K(314560K), 0.0013234 secs] 279763K->770K(1013632K), 0.0013532 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279763K->770K(314560K), 0.0013831 secs] 279763K->770K(1013632K), 0.0014144 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279764K->770K(314560K), 0.0011909 secs] 279764K->770K(1013632K), 0.0012211 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 279764K->0K(314560K), 0.0039265 secs] 279764K->770K(1013632K), 0.0039922 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 278994K->0K(314560K), 0.0002821 secs] 279764K->770K(1013632K), 0.0003096 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 278994K->0K(314560K), 0.0002651 secs] 279765K->770K(1013632K), 0.0002919 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 278995K->0K(314560K), 0.0002541 secs] 279765K->770K(1013632K), 0.0002783 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 278995K->0K(314560K), 0.0004202 secs] 279765K->770K(1013632K), 0.0004516 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 278995K->0K(314560K), 0.0003040 secs] 279765K->770K(1013632K), 0.0003364 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [DefNew: 278995K->0K(314560K), 0.0002545 secs] 279765K->770K(1013632K), 0.0002790 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         Heap
         def new generation   total 314560K, used 40872K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
         eden space 279616K,  14% used [0x00000000c0000000, 0x00000000c27ea098, 0x00000000d1110000)
         from space 34944K,   0% used [0x00000000d1110000, 0x00000000d1110000, 0x00000000d3330000)
         to   space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
         tenured generation   total 699072K, used 770K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
         the space 699072K,   0% used [0x00000000d5550000, 0x00000000d5610868, 0x00000000d5610a00, 0x0000000100000000)
         Metaspace       used 3504K, capacity 4496K, committed 4864K, reserved 1056768K
         class space    used 385K, capacity 388K, committed 512K, reserved 1048576K
         */
    }

}
