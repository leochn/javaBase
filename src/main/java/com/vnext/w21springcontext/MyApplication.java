package com.vnext.w21springcontext;

import com.vnext.w21springcontext.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author leo
 * @version 2018/6/13 7:05
 * @since 1.0.0
 */
@SpringBootApplication
public class MyApplication  {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApplication.class, args);
        SpringUtil.setApplicationContext(context);
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//
//    }
}