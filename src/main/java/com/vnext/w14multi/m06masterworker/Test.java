package com.vnext.w14multi.m06masterworker;

import java.util.Random;

/**
 * @author leo
 * @since 2018/2/12 14:53
 */
public class Test {

    public static void main(String[] args) {
        Master master = new Master(new Worker(), 100);
        Random r = new Random();
        for(int i = 1; i <= 100; i++){
            Task t = new Task();
            t.setId(i);
            t.setPrice(r.nextInt(1000));
            master.submit(t);
        }
        master.execute();
        long start = System.currentTimeMillis();
        while(true){
            if(master.isComplete()){
                long end = System.currentTimeMillis() - start;
                int priceResult = master.getResult();
                System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
                break;
            }
        }

    }
}
