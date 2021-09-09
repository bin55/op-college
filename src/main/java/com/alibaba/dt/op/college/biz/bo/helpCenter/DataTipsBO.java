/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.helpCenter;

import java.util.List;

import com.alibaba.dt.op.lang.model.BaseBO;

/**
 * 类DataTipsBO.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年6月6日 下午3:31:40
 */
public class DataTipsBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = -5840805747836520746L;
    /**
     * 指标、来源、常见问题
     */
    private String            type;
    /**
     * 标题
     */
    private String            title;
    /**
     * 所属类别
     */
    private String            classify;
    /**
     * 目录层级
     */
    private List<String>      navigations;
    /**
     * 说明
     */
    private String            annotation;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public List<String> getNavigations() {
        return navigations;
    }

    public void setNavigations(List<String> navigations) {
        this.navigations = navigations;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

}
