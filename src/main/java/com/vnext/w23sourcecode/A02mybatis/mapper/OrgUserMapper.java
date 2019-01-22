package com.vnext.w23sourcecode.A02mybatis.mapper;

import com.vnext.w23sourcecode.A02mybatis.entity.OrgUser;
import com.vnext.w23sourcecode.A02mybatis.orm.annotation.ExtInsert;
import com.vnext.w23sourcecode.A02mybatis.orm.annotation.ExtParam;
import com.vnext.w23sourcecode.A02mybatis.orm.annotation.ExtSelect;

/**
 * @Auther: LEO
 * @Date: 2019/1/22 08:05
 * @Description:
 */
public interface OrgUserMapper {

    @ExtInsert("insert into org_user (user_name,user_age) values(#{userName},#{userAge})")
    public int insertUser(@ExtParam("userName") String userName, @ExtParam("userAge") Integer userAge);

    @ExtSelect("select * from org_user where user_name=#{userName} and user_age=#{userAge} ")
    OrgUser selectUser(@ExtParam("userName") String name, @ExtParam("userAge") Integer userAge);

}
