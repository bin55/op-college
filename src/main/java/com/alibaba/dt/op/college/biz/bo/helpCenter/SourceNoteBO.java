/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.helpCenter;

import java.util.List;

import com.alibaba.dt.op.college.biz.util.SourceNode;
import com.alibaba.dt.op.lang.model.BaseBO;

/**
 * 类SourceNoteBO.java的实现描述：来源注释
 * 
 * @author zishao.zb 2016年6月12日 下午10:27:18
 */
public class SourceNoteBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = 794978987725273500L;
    private List<SourceNode>  list;

    public List<SourceNode> getList() {
        return list;
    }

    public void setList(List<SourceNode> list) {
        this.list = list;
    }

}
