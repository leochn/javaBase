package com.vnext.w14multi.m08ThreadPoolExecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author leo
 * @version 2018/2/13 7:04
 * @since 1.0.0
 */
public class MyRejected implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("任务" + r.toString() + ",被拒绝,请自定义处理..");
    }
}
