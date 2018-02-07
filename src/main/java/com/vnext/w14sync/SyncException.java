package com.vnext.w14sync;

/**
 * @author leo
 * @version 2018/2/7 21:51
 * @since 1.0.0
 */
public class SyncException {
    /*线程异常
    * 出现异常，锁自动释放
    */
    private int i = 0;
    public synchronized void operation(){
        while (true){
            try {
                i++;
                Thread.sleep(80);
                System.out.println(Thread.currentThread().getName() + ", i=" + i);
                if (i == 10){
                    Integer.parseInt("a");
                    // throw new RuntimeException();
                }
                if (i == 20){
                    break;
                }
            } catch (Exception e) { // InterruptedException
                e.printStackTrace();
                System.out.println("log info i = " + i);
                // throw new RuntimeException();
                continue;
            }
        }
    }

    public static void main(String[] args) {
        final SyncException se = new SyncException();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.operation();
            }
        },"t1");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        se.operation();
    }


}
