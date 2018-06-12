package com.vnext.w21springcontext.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  // 注解用在类上
@Retention(RetentionPolicy.RUNTIME) // JVM将在运行期间保留,因此可以通过反射机制读取注解
@Component
public @interface RpcService {
    String value();
}
