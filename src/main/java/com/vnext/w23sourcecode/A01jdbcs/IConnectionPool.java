package com.vnext.w23sourcecode.A01jdbcs;

import java.sql.Connection;

/**
 * 数据库连接池
 * @Auther: LEO
 * @Date: 2019/1/20 07:26
 * @Description:
 */
public interface IConnectionPool {

    // 获取连接(重复利用机制)
    public Connection getConnection();

    // 释放连接(可回收机制)
    public void releaseConnection(Connection connection);
}
