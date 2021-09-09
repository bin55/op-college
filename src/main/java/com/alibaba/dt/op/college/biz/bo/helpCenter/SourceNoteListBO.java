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
 * 类SourceNoteListBO.java的实现描述：来源列表
 * 
 * @author zishao.zb 2016年6月12日 下午11:40:03
 */
public class SourceNoteListBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = -1929608387571783001L;

    /**
     * 来源ID
     */
    private String            sourceId;
    /**
     * 来源名称
     */
    private String            name;
    /**
     * 来源路径
     */
    private List<String>      category;
    /**
     * 来源描述
     */
    private String            description;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
