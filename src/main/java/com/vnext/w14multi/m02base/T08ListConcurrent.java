package com.vnext.w14multi.m02base;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * List集合的并发测试，在同一时间多个线程无法对同一个List进行读取和增删，否则就会抛出并发异常，
 * 可以使用CopyOnWriteArrayList。
 * @version 2018/2/10 19:14
 * @since 1.0.0
 */
public class T08ListConcurrent {
    private static final int THREAD_POOL_MAX_NUM = 10;

    // 在同一时间多个线程无法对同一个List进行读取和增删，否则就会抛出并发异常。
    // private List<String> mList = new ArrayList<String>();

    private List<String> mList = new CopyOnWriteArrayList<>();

    public static void main(String args[]){
        new T08ListConcurrent().start();
    }

    private void initData() {
        for(int i = 0 ; i <= THREAD_POOL_MAX_NUM ; i ++){
            this.mList.add("...... Line "+(i+1)+" ......");
        }
    }
    private void start(){
        initData();
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_MAX_NUM);
        for(int i = 0 ; i < THREAD_POOL_MAX_NUM ; i ++){
            service.execute(new ListReader(this.mList));
            service.execute(new ListWriter(this.mList,i));
        }
        service.shutdown();
    }
    private class ListReader implements Runnable{
        private List<String> mList ;
        public  ListReader(List<String> list) {
            this.mList = list;
        }
        @Override
        public void run() {
            if(this.mList!=null){
                for(String str : this.mList){
                    System.out.println(Thread.currentThread().getName()+" : "+ str);
                }
            }
        }
    }
    private class ListWriter implements Runnable{
        private List<String> mList ;
        private int mIndex;
        public  ListWriter(List<String> list,int index) {
            this.mList = list;
            this.mIndex = index;
        }
        @Override
        public void run() {
            if(this.mList!=null){
                //this.mList.remove(this.mIndex);
                this.mList.add("...... add "+mIndex +" ......");
            }
        }
    }
}
