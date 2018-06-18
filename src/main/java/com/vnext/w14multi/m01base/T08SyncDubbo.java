package com.vnext.w14multi.m01base;

/**
 * 重入锁:synchronized 锁重入
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 20:40:57
 */
public class T08SyncDubbo {

    public static void main(String[] args) {

        /**
         * 在继承关系中，同步是不可继承的，虽然在父类中方法是同步的，但是子类重写之后，方法不同步了，同步没有继承性。
         *
         * 运行结果：
         * A Son i 9
         * B Son i 8
         * B Son i 7
         * A Son i 6
         * B Son i 4
         * A Son i 4
         * B Son i 3
         * A Son i 3
         * B Son i 2
         * A Son i 2
         * B Son i 1
         * A Son i 1
         * A Son i 0
         */

        Son son = new Son();
        MyThreadA a = new MyThreadA(son);
        MyThreadB b = new MyThreadB(son);
        a.setName("A");
        b.setName("B");
        a.start();
        b.start();
    }
}


class Father {
    public int i = 10;

    public synchronized void operate() {
        i--;
        System.out.println("Father i " + i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son extends Father {
    public void operate() {
        try {
            while (i > 0) {
                i--;
                System.out.println(Thread.currentThread().getName() + " Son i " + i);
                Thread.sleep(100);
                operate();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadA extends Thread {
    private Son son;

    public MyThreadA(Son son) {
        this.son = son;
    }

    @Override
    public void run() {
        son.operate();
    }
}

class MyThreadB extends Thread {
    private Son son;

    public MyThreadB(Son son) {
        this.son = son;
    }

    @Override
    public void run() {
        son.operate();
    }
}