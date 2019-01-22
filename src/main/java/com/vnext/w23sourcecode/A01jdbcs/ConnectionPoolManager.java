package com.vnext.w23sourcecode.A01jdbcs;

import java.sql.Connection;

/**
 * 管理线程池
 * @Auther: LEO
 * @Date: 2019/1/20 07:32
 * @Description:
 */
public class ConnectionPoolManager {

    private static DbConfig dbConfig = new DbConfig();
    private static ConnectionPool connectionPool = new ConnectionPool(dbConfig);

    // 获取连接(重复利用机制)
    public static Connection getConnection() {
        return connectionPool.getConnection();
    }

    // 释放连接(可回收机制)
    public static void releaseConnection(Connection connection) {
        connectionPool.releaseConnection(connection);
    }
}
