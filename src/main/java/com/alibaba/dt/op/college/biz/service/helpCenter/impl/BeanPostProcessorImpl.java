/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.helpCenter.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import com.alibaba.dt.op.college.biz.service.helpCenter.PreloadService;

/**
 * 类BeanPostProcessorImpl.java的实现描述：bean动态代理
 * 
 * @author zishao.zb 2016年6月23日 下午9:11:42
 */
@Service
public class BeanPostProcessorImpl implements BeanPostProcessor {

    // Bean 实例化之后执行该方法
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PreloadService) {
            ((PreloadService) bean).loadData(); // 调用方法加载数据
        }
        return bean;
    }

    // Bean 实例化之前执行该方法
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
