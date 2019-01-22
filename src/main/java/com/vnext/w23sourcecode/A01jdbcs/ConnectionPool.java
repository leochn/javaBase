package com.vnext.w23sourcecode.A01jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Vector;

/**
 * =====核心参数=====
 * 1.空闲线程:容器没有被使用的连接存放
 * 2.活动线程:容器正在使用的连接
 * =====核心步骤=====
 * 1.初始化线程池(初始化空闲线程)
 * 2.调用getConnection方法,获取连接
 * 3.先去freeConnection获取当前连接,存放在activeConnection
 * 4.调用releaseConnection方法,释放连接,资源回收
 * 5.获取activeConnection集合连接,转移到 freeConnection集合中
 *
 * @Auther: LEO
 * @Date: 2019/1/20 07:31
 * @Description:
 */
public class ConnectionPool implements IConnectionPool {

    // 使用线程安全的集合,空闲线程:容器中没有被使用的连接存放
    private List<Connection> freeConnection = new Vector<Connection>();

    // 使用线程安全的集合,活动线程:容器正在使用的连接
    private List<Connection> activeConnection = new Vector<Connection>();

    private DbConfig dbConfig;

    private int countConne = 0;

    public ConnectionPool(DbConfig dbConfig) {
        // 获取配置文件信息
        this.dbConfig = dbConfig;
        init();
    }

    // 初始化线程池(初始化空闲线程)
    private void init() {
        if (dbConfig == null) {
            try {
                throw new Exception("没有配置DbConfig......");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 1.获取初始化连接数
        for (int i = 0; i < dbConfig.getInitConnections(); i++) {
            // 2.创建Connection连接
            Connection newConnection = newConnection();
            if (newConnection != null) {
                // 3.存放在freeConnection集合
                freeConnection.add(newConnection);
            }else{
                //
                try {
                    throw new Exception("初始化connect连接错误......");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 创建Connection连接
    private synchronized Connection newConnection() {
        try {
            //Class.forName(dbConfig.getDriverName());
            Connection connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUserName(),dbConfig.getPassword());
            countConne++;
            return connection;
        } catch (Exception e) {
            return null;
        }

    }

    // 判断连接是否可用
    public boolean isAvailable(Connection connection) {
        try {
            if (connection == null || connection.isClosed()) {
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;

    }

    // 调用getConnection方法,获取连接
    @Override
    public synchronized Connection getConnection() {
        try {
            Connection connection = null;
            // 思考：怎么知道当前创建的连接>最大连接数
            if (countConne < dbConfig.getMaxActiveConnections()) {
                // 小于最大活动连接数
                // 1.判断空闲线程是否有数据
                if (freeConnection.size() > 0) {
                    // 空闲线程有存在连接
                    // 拿到删再除
                    connection = freeConnection.remove(0);// 等同于: freeConnection.get(0);freeConnection.remove(0)
                } else {
                    // 创建新的连接
                    connection = newConnection();
                }
                // 判断连接是否可用
                boolean available = isAvailable(connection);
                if (available) {
                    // 存放在活动线程池
                    activeConnection.add(connection);
                    countConne++;
                } else {
                    countConne--;
                    connection = getConnection(); // 怎么使用重试？ 递归算法
                }
            } else {
                // 大于最大活动连接数，进行等待
                wait(dbConfig.getConnTimeOut());
                // 重试
                connection = getConnection();
            }
            return connection;
        } catch (Exception e) {
            return null;
        }
    }



    // 释放连接,回收
    @Override
    public synchronized void releaseConnection(Connection connection) {

        try {
            // 1.判断连接是否可用
            if (isAvailable(connection)) {
                // 2.判断空闲线程是否已满
                if (freeConnection.size() < dbConfig.getMaxConnections()) {
                    // 空闲线程没有满
                    freeConnection.add(connection);// 回收连接
                } else {
                    // 空闲线程已经满
                    connection.close();
                }
                activeConnection.remove(connection);
                countConne--;
                notifyAll();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
