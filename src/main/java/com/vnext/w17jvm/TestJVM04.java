package com.vnext.w17jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * 虚拟机对于体积不大的对象 会优先把数据分配到TLAB区域中
 * @author leo
 * @version 2018/3/2 22:20
 * @since 1.0.0
 */
public class TestJVM04 {

    public static void main(String[] args) {

        // 注意与TestJVM04的区别

        //参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000
        //这种现象原因为：虚拟机对于体积不大的对象 会优先把数据分配到TLAB区域中，因此就失去了在老年代分配的机会

        //参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000 -XX:-UseTLAB
        // -XX:-UseTLAB , -UseTLAB表示:不使用TLAB区域

        Map<Integer, byte[]> m = new HashMap<Integer, byte[]>();
        for (int i = 0; i < 5 * 1024; i++) {
            byte[] b = new byte[1024]; // 1K
            m.put(i, b);
        }

        /**
         * 配置： -Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000 -XX:-UseTLAB
         * 产生如下结果：
         [GC (Allocation Failure) [DefNew: 8192K->835K(9216K), 0.0018467 secs] 8274K->917K(29696K), 0.0018936 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         Heap
         def new generation   total 9216K, used 999K [0x00000000fe200000, 0x00000000fec00000, 0x00000000fec00000)
         eden space 8192K,   2% used [0x00000000fe200000, 0x00000000fe2290e8, 0x00000000fea00000)
         from space 1024K,  81% used [0x00000000feb00000, 0x00000000febd0e40, 0x00000000fec00000)
         to   space 1024K,   0% used [0x00000000fea00000, 0x00000000fea00000, 0x00000000feb00000)
         tenured generation   total 20480K, used 82K [0x00000000fec00000, 0x0000000100000000, 0x0000000100000000)
         the space 20480K,   0% used [0x00000000fec00000, 0x00000000fec14918, 0x00000000fec14a00, 0x0000000100000000)
         Metaspace       used 3502K, capacity 4496K, committed 4864K, reserved 1056768K
         class space    used 385K, capacity 388K, committed 512K, reserved 1048576K
         */


        /**
         * 配置： -Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000
         * 产生如下结果：
         Heap
         def new generation   total 9216K, used 1542K [0x00000000fe200000, 0x00000000fec00000, 0x00000000fec00000)
         eden space 8192K,  18% used [0x00000000fe200000, 0x00000000fe381a70, 0x00000000fea00000)
         from space 1024K,   0% used [0x00000000fea00000, 0x00000000fea00000, 0x00000000feb00000)
         to   space 1024K,   0% used [0x00000000feb00000, 0x00000000feb00000, 0x00000000fec00000)
         tenured generation   total 20480K, used 6431K [0x00000000fec00000, 0x0000000100000000, 0x0000000100000000)
         the space 20480K,  31% used [0x00000000fec00000, 0x00000000ff247cf8, 0x00000000ff247e00, 0x0000000100000000)
         Metaspace       used 3502K, capacity 4496K, committed 4864K, reserved 1056768K
         class space    used 385K, capacity 388K, committed 512K, reserved 1048576K
         */
    }

}
