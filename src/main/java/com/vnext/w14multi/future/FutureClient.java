package com.vnext.w14multi.future;

/**
 * @author leo
 * @version 2018/2/10 20:03
 * @since 1.0.0
 */
public class FutureClient {
    public Data request(final String request) {
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(request);
                futureData.setRealData(realData);
            }
        }).start();
        return futureData;
    }
}

