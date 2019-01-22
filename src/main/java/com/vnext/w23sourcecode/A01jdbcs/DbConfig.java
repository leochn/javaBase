package com.vnext.w23sourcecode.A01jdbcs;

import lombok.Data;

/**
 * 外部配置文件信息
 * @Auther: LEO
 * @Date: 2019/1/20 07:19
 * @Description:
 */
@Data
public class DbConfig {
    /**
     * 空闲线程数：初始化线程，还么有被使用
     * 活动线程数：正在被使用线程
     * 最大线程数：限制最多可创建的
     */

    /* 链接属性 */
    private String driverName = "com.mysql.jdbc.Driver";

    private String url = "jdbc:mysql://127.0.0.1:3306/testdb?useSSL=false";

    private String userName = "root";

    private String password = "123qwe!@#";

    private String poolName = "thread01";// 连接池名字

    private int minConnections = 1; // 空闲池，最小连接数

    private int maxConnections = 10; // 空闲池，最大连接数

    private int maxActiveConnections = 100;// 最大允许的连接数，和数据库对应

    private int initConnections = 5;// 初始化连接数

    private long connTimeOut = 1000;// 重复获得连接的频率

    private long connectionTimeOut = 1000 * 60 * 20;// 连接超时时间，默认20分钟
}
