package com.vnext.w15jdk8.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 可重复注解
 * @author leo
 * @version 2018/2/28 21:26
 * @since 1.0.0
 */
@Repeatable(MyAnnotations.class) // 重复注解需要加上 @Repeatable 注解
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "vnext";
}
