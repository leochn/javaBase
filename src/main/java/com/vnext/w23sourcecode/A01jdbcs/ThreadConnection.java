package com.vnext.w23sourcecode.A01jdbcs;

import java.sql.Connection;

/**
 * @Auther: LEO
 * @Date: 2019/1/20 08:27
 * @Description:
 */
public class ThreadConnection implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Connection connection = ConnectionPoolManager.getConnection();
            System.out.println(Thread.currentThread().getName() + ",connection:" + connection);
            ConnectionPoolManager.releaseConnection(connection);
        }
    }
}
