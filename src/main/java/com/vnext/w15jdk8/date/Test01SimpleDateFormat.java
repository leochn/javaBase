package com.vnext.w15jdk8.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 22:11:34
 */
public class Test01SimpleDateFormat {


    public static void main(String[] args) throws Exception {

//        // 1.传统的日期存在线程安全问题
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//
////        Callable<Date> task = new Callable<Date>() {
////
////            @Override
////            public Date call() throws Exception {
////                return sdf.parse("20161121");
////            }
////
////        };
//
//        Callable<Date> task = () -> {
//            return sdf.parse("20171121");
//        };
//
//        ExecutorService pool = Executors.newFixedThreadPool(10);
//
//        List<Future<Date>> results = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            results.add(pool.submit(task));
//        }
//
//        for (Future<Date> m04future : results) {
//            System.out.println(m04future.get());
//        }
//        pool.shutdown();



//        // 2.解决多线程安全问题
////        Callable<Date> task = () -> {
////            return DateFormatThreadLocal.convert("20171121");
////        };
////        ExecutorService pool = Executors.newFixedThreadPool(10);
////        List<Future<Date>> results = new ArrayList<>();
////        for (int i = 0; i < 10; i++) {
////            results.add(pool.submit(task));
////        }
////        for (Future<Date> m04future : results) {
////            System.out.println(m04future.get());
////        }
////        pool.shutdown();

        // 3.jak8 api
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = () -> {
            return LocalDate.parse("20171121", dtf);
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();

    }
}