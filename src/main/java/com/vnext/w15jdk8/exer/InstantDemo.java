package com.vnext.w15jdk8.exer;

import java.time.Instant;

/**
 * Instant瞬时时间 相当于以前的System.currentTimeMillis()
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 17:09:43
 */
public class InstantDemo {

    public static void main(String[] args) {
        Instant instant1 = Instant.now();
        System.out.println(instant1.getEpochSecond());
    }

}