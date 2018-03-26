package com.vnext.w12thread;

/**
 * @author leo
 * @since 2018/2/8 9:39
 */
public class TestProduceConsume {
    /*
     * 生产者/消费者问题
     * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
     * 店员一次只能持有固定数量的产品(比如:20），
     * 如果生产者试图生产更多的产品，店员会叫生产者停一下， 如果店中有空位放产品了再通知生产者继续生产；
     * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
        分析：
        1.是否涉及到多线程的问题？是！生产者、消费者
        2.是否涉及到共享数据？有！考虑线程的安全
        3.此共享数据是谁？即为产品的数量
        4.是否涉及到线程的通信呢？存在这生产者与消费者的通信
     */

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);
        Thread t1 = new Thread(p1,"生产者1");
        Thread t2 = new Thread(p1,"生产者2");
        Thread t3 = new Thread(p1,"生产者3");
        Thread t4 = new Thread(p1,"生产者4");
        Thread tc1 = new Thread(c1,"消费者1");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        tc1.start();
    }

}


// 永远在循环（loop）里调用 wait 和 notify
class Clerk{
    private int product;

    // 进货
    public synchronized void addProduct(){
        if (product >= 20){
            System.out.println("产品已满！");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            product++;
            System.out.println(Thread.currentThread().getName() + ",生产了第" + product + "个产品");
            notifyAll();
        }
    }

    // 卖货
    public synchronized void saleProduct(){
        if (product <= 0) {
            System.out.println("缺货！");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + ",消费了第" + product + "个产品");
            product--;
            notifyAll();
        }
    }
}

// 生产者
class Producer implements Runnable{
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生成产品...");
        /*while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }*/
        for (int i = 0; i < 20 ; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

// 消费者
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者消费产品...");
       /* while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.saleProduct();
        }*/

        for (int i = 0; i <20 ; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.saleProduct();
        }

    }
}
