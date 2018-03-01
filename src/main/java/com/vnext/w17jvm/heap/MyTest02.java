package com.vnext.w17jvm.heap;

import java.util.Random;

/**
 * OOMy异常
 * @author leo
 * @version 2018/3/1 22:52
 * @since 1.0.0
 */
public class MyTest02 {

    /**修改JVM的配置，测试堆内存异常
     * -Xms8m -Xmx8m -XX:+PrintGCDetails
     */

    public static void main(String[] args) {
        String str = "com.vnext.example";
        while (true){
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
        }

        /**
         输出如下：
         [GC (Allocation Failure) [PSYoungGen: 1529K->504K(2048K)] 1529K->817K(7680K), 0.0355715 secs] [Times: user=0.00 sys=0.00, real=0.05 secs]
         [GC (Allocation Failure) [PSYoungGen: 1914K->493K(2048K)] 2227K->1011K(7680K), 0.0032072 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [PSYoungGen: 1743K->424K(2048K)] 2260K->1348K(7680K), 0.0008412 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [PSYoungGen: 1538K->440K(2048K)] 2463K->1907K(7680K), 0.0009243 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [PSYoungGen: 1555K->424K(2048K)] 4108K->3520K(7680K), 0.0008511 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [PSYoungGen: 996K->408K(2048K)] 5178K->4589K(7680K), 0.0019483 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [PSYoungGen: 408K->32K(2048K)] 4589K->4615K(7680K), 0.0006574 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [Full GC (Allocation Failure) [PSYoungGen: 32K->0K(2048K)] [ParOldGen: 4583K->2429K(5632K)] 4615K->2429K(7680K), [Metaspace: 3506K->3506K(1056768K)], 0.0084359 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
         [GC (Allocation Failure) --[PSYoungGen: 1115K->1115K(2048K)] 5717K->5717K(7680K), 0.0209950 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
         [Full GC (Ergonomics) [PSYoungGen: 1115K->0K(2048K)] [ParOldGen: 4601K->1978K(5632K)] 5717K->1978K(7680K), [Metaspace: 3506K->3506K(1056768K)], 0.0036897 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [PSYoungGen: 1146K->0K(2048K)] 5296K->4150K(7680K), 0.0003119 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4150K->4150K(7680K), 0.0002503 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4150K->4032K(5632K)] 4150K->4032K(7680K), [Metaspace: 3506K->3506K(1056768K)], 0.0072616 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
         [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4032K->4032K(7680K), 0.0005630 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [Full GC (Allocation Failure) Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         at java.util.Arrays.copyOf(Arrays.java:3332)
         at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
         at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
         at java.lang.StringBuilder.append(StringBuilder.java:208)
         at com.vnext.w17jvm.heap.MyTest02.main(MyTest02.java:20)
         [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4032K->4011K(5632K)] 4032K->4011K(7680K), [Metaspace: 3506K->3506K(1056768K)], 0.0089354 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
         Heap
         PSYoungGen      total 2048K, used 61K [0x00000000ffd80000, 0x0000000100000000, 0x0000000100000000)
         eden space 1536K, 3% used [0x00000000ffd80000,0x00000000ffd8f5c0,0x00000000fff00000)
         from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
         to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
         ParOldGen       total 5632K, used 4011K [0x00000000ff800000, 0x00000000ffd80000, 0x00000000ffd80000)
         object space 5632K, 71% used [0x00000000ff800000,0x00000000ffbeaf80,0x00000000ffd80000)
         Metaspace       used 3538K, capacity 4500K, committed 4864K, reserved 1056768K
         class space    used 389K, capacity 392K, committed 512K, reserved 1048576K
         */
    }
}
