package com.vnext.w21springcontext.service.impl;

import com.vnext.w21springcontext.annotation.RpcService;
import com.vnext.w21springcontext.service.HelloService;

/**
 * @author leo
 * @version 2018/6/13 7:19
 * @since 1.0.0
 */
@RpcService("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "hi," + name;
    }
}