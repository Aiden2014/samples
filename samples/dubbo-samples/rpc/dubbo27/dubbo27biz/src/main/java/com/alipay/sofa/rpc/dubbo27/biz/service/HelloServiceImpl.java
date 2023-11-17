/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.sofa.rpc.dubbo27.biz.service;

import com.alipay.sofa.rpc.dubbo27.model.HelloRequest;
import com.alipay.sofa.rpc.dubbo27.model.HelloResponse;
import com.alipay.sofa.rpc.dubbo27.model.HelloService;

/**
 *
 * @author syd
 * @version HelloServiceImpl.java, v 0.1 2023年11月02日 15:00 syd
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public HelloResponse sayHello(HelloRequest request) {
        HelloResponse response = new HelloResponse();
        response.setData(request.getName() + "->" + getClass().getName());
        return response;
    }
}