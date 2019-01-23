package com.vnext.w23sourcecode.A02mybatis.orm.mybatis;

import com.vnext.w23sourcecode.A02mybatis.entity.OrgUser;
import com.vnext.w23sourcecode.A02mybatis.mapper.OrgUserMapper;
import com.vnext.w23sourcecode.A02mybatis.sql.SqlSession;

/**
 * @Auther: LEO
 * @Date: 2019/1/22 18:11
 * @Description:
 */
public class TestInvocationHandler {

    public static void main(String[] args) {

//        // 测试使用动态代理技术虚拟调用方法
//        TestMapper testMapper = SqlSession.getTestMapper(TestMapper.class);
//        testMapper.testInvocation();


        // 使用动态代理技术虚拟调用方法
        OrgUserMapper userMapper = SqlSession.getMapper(OrgUserMapper.class);
        OrgUser selectUser = userMapper.selectUser("tone", 18);
        System.out.println(
                "结果:" + selectUser.getUserName() + "," + selectUser.getUserAge() + ",id:" + selectUser.getId());
        // // 先走拦截invoke
        // int insertUserResult = userMapper.insertUser("张三", 644064);
        // System.out.println("insertUserResult:" + insertUserResult);



    }
}
