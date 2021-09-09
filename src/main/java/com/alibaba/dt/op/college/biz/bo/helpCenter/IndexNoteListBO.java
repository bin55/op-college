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
 * 类IndexNoteListBO.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月27日 下午3:30:01
 */
public class IndexNoteListBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = -7027117412692652760L;
    /**
     * 指标ID
     */
    private Integer           indexId;
    /**
     * 指标的父ID
     */
    private Integer           indexParentId;
    /**
     * 指标名称
     */
    private String            name;
    /**
     * 指标路径
     */
    private List<String>      path;
    /**
     * 指标描述
     */
    private String            description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public Integer getIndexParentId() {
        return indexParentId;
    }

    public void setIndexParentId(Integer indexParentId) {
        this.indexParentId = indexParentId;
    }

}
