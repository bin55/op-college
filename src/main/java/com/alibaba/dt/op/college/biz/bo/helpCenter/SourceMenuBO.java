/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.helpCenter;

import com.alibaba.dt.op.lang.model.BaseBO;

/**
 * 类MenuBO.java的实现描述：菜单节点
 * 
 * @author zishao.zb 2016年5月20日 下午5:50:26
 */
public class SourceMenuBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = 3618048968925690741L;
    /**
     * 菜单ID
     */
    private String            id;
    /**
     * 父菜单ID
     */
    private String            parentId;
    /**
     * 菜单名称
     */
    private String            name;
    /**
     * 菜单类型,0:菜单,1:指标
     */
    private String            type;
    /**
     * 节点类型,Y:叶子节点,N:非叶子节点
     */
    private String            isLeaf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

}
