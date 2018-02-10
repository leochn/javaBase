package com.vnext.w14multi;

/**
 * @author leo
 * @version 2018/2/10 20:32
 * @since 1.0.0
 */
public class FutureData implements Data {

    private RealData realData;

    private boolean isReady = false;

    public synchronized String getRequest() {
        //  如果没有装载好，程序就一直处于阻塞状态
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /* 装载好直接获取数据即可 */
        return this.realData.getRequest();
    }

    public synchronized void setRealData(RealData realData) {
        // 已经装载完毕，就直接返回
        if (isReady) {
            return;
        }
        // 如果没有装载，进行装载真实对象
        this.realData = realData;
        isReady = true;
        // 进行通知
        notify();
    }
}
