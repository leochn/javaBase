package com.vnext.w14multi.m01base;

/**
 * 重入锁:synchronized 锁重入
 * @author leo
 * @version 2018/2/7 21:37
 * @since 1.0.0
 */
public class T07SyncDubbo {

    static class Main{
        public int i = 10;
        public synchronized void operationSup(){
            try {
                i--;
                System.out.println("Test print i =" + i);
                Thread.sleep(100);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main{
        public synchronized void operationSub(){
            try {
                while (i > 0) {
                    i--;
                    System.out.println("Sub print i =" + i);
                    Thread.sleep(100);
                    this.operationSup();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        /**
         * 可重入锁即自己可以再次获取自己的内部锁，反之不可重入锁就造成死锁了而且在继承环境中子类可以调用父类的同步方法。
         *
         * 运行结果：
         * Sub print i =9
         * Test print i =8
         * Sub print i =7
         * Test print i =6
         * Sub print i =5
         * Test print i =4
         * Sub print i =3
         * Test print i =2
         * Sub print i =1
         * Test print i =0
         */


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Sub sub = new Sub();
                sub.operationSub();
            }
        });
        t1.start();
    }

}
