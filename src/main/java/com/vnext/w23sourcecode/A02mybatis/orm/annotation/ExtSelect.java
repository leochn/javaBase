package com.vnext.w23sourcecode.A02mybatis.orm.annotation;

import java.lang.annotation.*;

/**
 * @Auther: LEO
 * @Date: 2019/1/22 08:06
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExtSelect {

    String value();

}
