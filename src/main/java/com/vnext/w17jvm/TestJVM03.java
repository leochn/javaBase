package com.vnext.w17jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * 大对象,新生代eden区无法装入时,也会直接进入老年代
 * @author leo
 * @version 2018/3/2 22:12
 * @since 1.0.0
 */
public class TestJVM03 {

    public static void main(String[] args) {

        // -XX:PretenureSizeThreshold=1024000 < 1023 * 1000

        //参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1024000

        // 大对象(新生代eden区无法装入时，也会直接进入老年代)。JVM里有个参数可以设置对象的大小超过在指定的大小之后，直接晋升老年代

        Map<Integer, byte[]> m = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            byte[] b = new byte[1024 * 1024]; // 1M
            m.put(i, b);
        }

        /**
         Heap
         def new generation   total 9216K, used 2887K [0x00000000fe200000, 0x00000000fec00000, 0x00000000fec00000)
         eden space 8192K,  35% used [0x00000000fe200000, 0x00000000fe4d1f30, 0x00000000fea00000)
         from space 1024K,   0% used [0x00000000fea00000, 0x00000000fea00000, 0x00000000feb00000)
         to   space 1024K,   0% used [0x00000000feb00000, 0x00000000feb00000, 0x00000000fec00000)
         tenured generation   total 20480K, used 5120K [0x00000000fec00000, 0x0000000100000000, 0x0000000100000000)
         the space 20480K,  25% used [0x00000000fec00000, 0x00000000ff100050, 0x00000000ff100200, 0x0000000100000000)
         Metaspace       used 3500K, capacity 4496K, committed 4864K, reserved 1056768K
         class space    used 385K, capacity 388K, committed 512K, reserved 1048576K
         */
    }
}
