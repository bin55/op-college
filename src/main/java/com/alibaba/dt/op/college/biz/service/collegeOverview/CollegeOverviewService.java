/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.collegeOverview;

import java.util.List;

import com.alibaba.dt.op.college.biz.bo.collegeOverview.PartnerBO;
import com.alibaba.dt.op.college.biz.bo.collegeOverview.RecommendCourseBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.DataTipsBO;

/**
 * 类CollegeOverviewService.java的实现描述：学院概况
 * 
 * @author zishao.zb 2016年5月18日 上午9:43:10
 */
public interface CollegeOverviewService {

    /**
     * 产品功能课程推荐列表
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> productFeature();

    /**
     * 数据化运营课程推荐列表
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> dataManagement();

    /**
     * 新课速递课程推荐列表
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> newCourseDelivery();

    /**
     * 成功案例课程推荐列表
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> successCase();

    /**
     * 优秀讲师列表
     * 
     * @param
     * @return
     */
    public List<PartnerBO> excellentTeacher();

    /**
     * 合作机构列表
     * 
     * @param
     * @return
     */
    public List<PartnerBO> partners();

    /**
     * 数据小贴士列表
     * 
     * @param
     * @return
     */
    public List<DataTipsBO> dataTips();
}
