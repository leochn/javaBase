package com.vnext.w23sourcecode.A02mybatis.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Auther: LEO
 * @Date: 2019/1/22 08:08
 * @Description:
 */
public class JdbcUtilTest {

    public static void main(String[] args) throws SQLException {

//         #{ mybatis 替换成?
//         insert 语句...
//         String inserSql = "insert into org_user (user_name,user_age) values(?,?)";
//         ArrayList<Object> arrayList = new ArrayList<>();
//         arrayList.add("lily");
//         arrayList.add(20);
//         int insert = JDBCUtil.insert(inserSql, false, arrayList);
//         System.out.println("insert:" + insert);

        // 查询语句
        ArrayList<Object> array = new ArrayList<>();
        array.add("tone");
        array.add(18);
        ResultSet res = JDBCUtil.query("select * from org_user where user_name=? and user_age=? ", array);
        while (res.next()) {
            Integer id = res.getInt("id");
            String userName = res.getString("user_name");
            System.out.println("id:" + id + ",user_name:" + userName);
        }
    }
}
