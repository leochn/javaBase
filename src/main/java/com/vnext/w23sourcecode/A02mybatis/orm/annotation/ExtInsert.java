package com.vnext.w23sourcecode.A02mybatis.orm.annotation;

import java.lang.annotation.*;

/**
 * 自定义参数注解
 * @Auther: LEO
 * @Date: 2019/1/22 08:06
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExtInsert {
    String value();
}
