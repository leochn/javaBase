package com.vnext.w17jvm.jvm02heap;

/**
 * @author leo
 * @version 2018/3/2 20:03
 * @since 1.0.0
 */
public class MyTest05 {

    public static void main(String[] args) {

        //第一次配置
        //-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        //第二次配置
        //-Xms20m -Xmx20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        //第三次配置
        //-XX:NewRatio=老年代/新生代
        //-Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        byte[] b = null;
        //连续向系统申请10MB空间
        for(int i = 0 ; i <10; i ++){
            b = new byte[1*1024*1024];
        }
    }
}
