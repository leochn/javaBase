package com.vnext.w14multi.m01base;

/**
 * 多线程之间，数据的脏读
 * @author leo
 * @version 2018/2/7 21:23
 * @since 1.0.0
 */
public class T05DirtyRead {
    // 脏读
    /*
    对于对象的同步和异步的方法，我们在设计自己程序的时候，一定要考虑问题的整体，
    不然就会出现数据不一致的错误，很经典的就是脏读
    */
    private String username = "tone";
    private String password = "123";

    public synchronized void setValue(String username,String password){
        this.username = username;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("setValue最终得到：username=" + username + ";password="+ password);
    }

    /* synchronized */
    public void getValue(){
        System.out.println("getValue方法得到：username=" + username + ";password="+ password);
    }

    public static void main(String[] args) throws Exception {

        /**
         * 打印结果：
         * getValue方法得到：username=z3;password=123
         * setValue最终得到：username=z3;password=456
         */

        final T05DirtyRead dr = new T05DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dr.setValue("z3","456");
            }
        });
        t1.start();

        Thread.sleep(1000);
        dr.getValue();
    }

}
