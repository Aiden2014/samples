/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.biz.service;

import com.alipay.sofa.biz.facade.Param;
import com.alipay.sofa.biz.facade.Provider;
import com.alipay.sofa.biz.facade.Result;
import com.alipay.sofa.biz.facade.Student;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: yuanyuan
 * @date: 2023/9/25 3:27 下午
 */
@Service
public class StudentProvider implements Provider {

    @Override
    public Result provide(Param param, Param[] params, byte b, byte[] bs,
                          Map<String, Object> config, Class[] clazzs) {
        Result result = new Result();
        result.setSuccess(true);
        result.setPeople(new Student());
        return result;
    }
}
