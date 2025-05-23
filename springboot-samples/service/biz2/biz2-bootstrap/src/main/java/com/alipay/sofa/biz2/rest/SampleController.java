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
package com.alipay.sofa.biz2.rest;

import com.alipay.sofa.base.facade.AppService;
import com.alipay.sofa.base.facade.SampleService;
import com.alipay.sofa.biz.facade.Param;
import com.alipay.sofa.biz.facade.Provider;
import com.alipay.sofa.biz.facade.Result;
import com.alipay.sofa.koupleless.common.api.AutowiredFromBase;
import com.alipay.sofa.koupleless.common.api.AutowiredFromBiz;
import com.alipay.sofa.koupleless.common.api.SpringServiceFinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SampleController {

    @AutowiredFromBase(name = "sampleServiceImplNew")
    private SampleService              sampleServiceImplNew;

    @AutowiredFromBase(name = "sampleServiceImpl")
    private SampleService              sampleServiceImpl;

    @AutowiredFromBase
    private List<SampleService>        sampleServiceList;

    @AutowiredFromBase
    private Map<String, SampleService> sampleServiceMap;

    @AutowiredFromBase
    private AppService                 appService;

    @AutowiredFromBiz(bizName = "biz1", bizVersion = "0.0.1-SNAPSHOT", name = "studentProvider")
    private Provider                   studentProvider;

    @AutowiredFromBiz(bizName = "biz1", name = "teacherProvider")
    private Provider                   teacherProvider;

    @AutowiredFromBiz(bizName = "biz1", bizVersion = "0.0.1-SNAPSHOT")
    private List<Provider>             providers;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {

        sampleServiceImplNew.service();

        sampleServiceImpl.service();

        for (SampleService sampleService : sampleServiceList) {
            sampleService.service();
        }

        for (String beanName : sampleServiceMap.keySet()) {
            sampleServiceMap.get(beanName).service();
        }

        appService.getAppName();

        SampleService sampleServiceImplFromFinder = SpringServiceFinder.getBaseService(
            "sampleServiceImpl", SampleService.class);
        String result = sampleServiceImplFromFinder.service();
        System.out.println(result);

        Map<String, SampleService> sampleServiceMapFromFinder = SpringServiceFinder
            .listBaseServices(SampleService.class);
        for (String beanName : sampleServiceMapFromFinder.keySet()) {
            String result1 = sampleServiceMapFromFinder.get(beanName).service();
            System.out.println(result1);
        }

        Result provide = studentProvider.provide(new Param(), new Param[] { new Param() },
            (byte) 1, new byte[] { 1 }, new HashMap<>(), new Class[] {});

        Result provide1 = teacherProvider.provide(new Param(), new Param[] { new Param() },
            (byte) 1, new byte[] { 1 }, new HashMap<>(), new Class[] {});

        for (Provider provider : providers) {
            Result provide2 = provider.provide(new Param(), new Param[] { new Param() }, (byte) 1,
                new byte[] { 1 }, new HashMap<>(), new Class[] {});
        }

        Provider teacherProvider1 = SpringServiceFinder.getModuleService("biz1", "0.0.1-SNAPSHOT",
            "teacherProvider", Provider.class);
        Result result1 = teacherProvider1.provide(new Param(), new Param[] { new Param() },
            (byte) 1, new byte[] { 1 }, new HashMap<>(), new Class[] {});

        Map<String, Provider> providerMap = SpringServiceFinder.listModuleServices("biz1",
            "0.0.1-SNAPSHOT", Provider.class);
        for (String beanName : providerMap.keySet()) {
            Result result2 = providerMap.get(beanName).provide(new Param(),
                new Param[] { new Param() }, (byte) 1, new byte[] { 1 }, new HashMap<>(),
                new Class[] {});
        }

        return "hello to ark biz2 dynamic deploy";
    }
}
