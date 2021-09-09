/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.courseCenter;

import java.util.List;

import com.alibaba.dt.op.college.biz.util.SubjectCategoryNode;
import com.alibaba.dt.op.lang.model.BaseBO;

/**
 * 类CourseSubjectBO.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月20日 下午5:33:48
 */
public class CourseSubjectBO extends BaseBO {

    /**
     * 
     */
    private static final long         serialVersionUID = -3112198361082544499L;

    private List<SubjectCategoryNode> subject;

    public List<SubjectCategoryNode> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectCategoryNode> subject) {
        this.subject = subject;
    }
}
