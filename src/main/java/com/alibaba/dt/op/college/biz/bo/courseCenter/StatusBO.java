/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.courseCenter;

/**
 * 类StatusBO.java的实现描述：返回状态
 * 
 * @author zishao.zb 2016年5月23日 下午4:30:00
 */
public class StatusBO {

    /**
     * 操作结果状态
     */
    private boolean status;
    /**
     * 操作课程对象ID
     */
    private Integer courseId;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

}
