package com.vnext.w17jvm.jvm02heap;

/**
 * @author leo
 * @version 2018/3/1 22:23
 * @since 1.0.0
 */
public class MyTest01 {

    public static void main(String[] args) {
        /**
         * JVM参数的含义：
           -Xms: 设置初始分配大小，默认为物理内存的 1/64,
           -Xmx: 最大分配内存，默认为物理内存的 1/4.
           -XX:+PrintGCDetails: 输出详细的GC处理日志.（包括各个区的情况）
           -Xmn: 新生代大小
         */

        // 总结：在实际工作中，我们可以直接将初始化的堆大小与最大堆大小设置相等，这样的好处是可以减少程序运行时的垃圾回收次数，从而提高性能。


        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("maxMemory=" + maxMemory + "(字节)，" + ((double)maxMemory / 1024/1024) + "MB");
        System.out.println("totalMemory=" + totalMemory + "(字节)，" + ((double)totalMemory /1024/1024) + "MB");

        /**jdk8
         在默认配置下：内存分配如下，打印输出如下：
             maxMemory=1886912512(字节)，1799.5MB
             totalMemory=128974848(字节)，123.0MB
         */

        /** jdk8
         idea的配置：菜单栏中,Run -> Edit Configurations...
            Configuration 中，VM options设置为: -Xms1024m -Xmx1024m -XX:+PrintGCDetails
         eclipse配置：右键 -> Run Configuration... -> Arguments -> VM arguments 中进行设置。

         打印输出如下：
         maxMemory=1029177344(字节)，981.5MB
         totalMemory=1029177344(字节)，981.5MB
         Heap
         PSYoungGen      total 305664K, used 20971K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
         eden space 262144K, 8% used [0x00000000eab00000,0x00000000ebf7afb8,0x00000000fab00000)
         from space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
         to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
         ParOldGen       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
         object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
         Metaspace       used 3519K, capacity 4496K, committed 4864K, reserved 1056768K
         class space    used 386K, capacity 388K, committed 512K, reserved 1048576K

         */

        /**
         * 计算如下：
         (PSYoungGen + ParOldGen)/1024   ---->  (305664 + 699392) / 1024 = 981.5
          */














    }

}
