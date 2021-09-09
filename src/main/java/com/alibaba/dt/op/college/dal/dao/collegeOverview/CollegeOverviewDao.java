/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.dal.dao.collegeOverview;

import java.util.List;

import com.alibaba.dt.op.college.biz.bo.collegeOverview.PartnerBO;
import com.alibaba.dt.op.college.biz.bo.collegeOverview.RecommendCourseBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.FaqBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteListBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteListBO;

/**
 * 类CollegeOverviewDao.java的实现描述：学院概况
 * 
 * @author zishao.zb 2016年5月18日 上午9:52:52
 */
public interface CollegeOverviewDao {

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
     * 数据小贴士指标信息
     * 
     * @param
     * @return
     */
    public List<IndexNoteListBO> dataTipsIndex();

    /**
     * 数据小贴士来源信息
     * 
     * @param
     * @return
     */
    public List<SourceNoteListBO> dataTipsSource();

    /**
     * 数据小贴士常见问题
     * 
     * @param
     * @return
     */
    public List<FaqBO> dataTipsFaq();
}
