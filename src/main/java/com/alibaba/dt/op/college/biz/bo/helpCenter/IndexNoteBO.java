/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.helpCenter;

import java.util.List;

import com.alibaba.dt.op.college.biz.util.Node;
import com.alibaba.dt.op.lang.model.BaseBO;

/**
 * 类IndexNoteBO.java的实现描述：指标注释
 * 
 * @author zishao.zb 2016年5月25日 上午11:40:02
 */
public class IndexNoteBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = -1261199467215242166L;
    private List<Node>        list;

    public List<Node> getList() {
        return list;
    }

    public void setList(List<Node> list) {
        this.list = list;
    }

}
