package com.vnext.w17jvm.jvm02heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 调试OOM，定位OOM
 * @author leo
 * @version 2018/3/1 23:01
 * @since 1.0.0
 */
public class MyTest03 {

    /**修改JVM的配置
     * -Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
     */

    byte[] bytes = new byte[1 * 1024 * 1024]; //1MB

    public static void main(String[] args) {
        List<MyTest03> list = new ArrayList<>();
        try {
            for (int i = 0; i <= 40; i++) {
                list.add(new MyTest03());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        /**
         * 异常信息:
         java.lang.OutOfMemoryError: Java jvm02heap space
         Dumping jvm02heap to java_pid8584.hprof ...
         Heap dump file created [6918100 bytes in 0.054 secs]
         Exception in thread "main" java.lang.OutOfMemoryError: Java jvm02heap space
         at com.vnext.w17jvm.jvm02heap.MyTest03.<init>(MyTest03.java:18)
         at com.vnext.w17jvm.jvm02heap.MyTest03.main(MyTest03.java:24)
         */
    }

}
