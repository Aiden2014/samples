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
package com.alipay.sofa.logging.log4j2.base.impl;

import com.alipay.sofa.logging.log4j2.base.facade.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {
    private static Logger      LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public String service() {
        String appName = applicationContext.getId();

        LOGGER.info("{} web test: into a service", appName);
        return "A Sample Service";
    }
}
