/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.dal.dao.collegeOverview.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dt.op.college.biz.bo.collegeOverview.PartnerBO;
import com.alibaba.dt.op.college.biz.bo.collegeOverview.RecommendCourseBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.FaqBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteListBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteListBO;
import com.alibaba.dt.op.college.dal.dao.collegeOverview.CollegeOverviewDao;
import com.alibaba.dt.op.common.dal.dao.BaseDao;

/**
 * 类CollegeOverviewDaoImpl.java的实现描述：学院概况
 * 
 * @author zishao.zb 2016年5月18日 上午9:53:32
 */
@Service
public class CollegeOverviewDaoImpl implements CollegeOverviewDao {

    public static final String namespace = CollegeOverviewDaoImpl.class.getName();
    @Autowired
    private BaseDao            baseDao;

    /**
     * 产品功能课程推荐列表
     * 
     * @param
     * @return
     */
    @Override
    public List<RecommendCourseBO> productFeature() {
        return baseDao.list(namespace + ".productFeature", null);
    }

    /**
     * 数据化运营课程推荐列表
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> dataManagement() {
        return baseDao.list(namespace + ".dataManagement", null);
    }

    /**
     * 新课速递课程推荐列表
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> newCourseDelivery() {
        return baseDao.list(namespace + ".newCourseDelivery", null);
    }

    /**
     * 成功案例课程推荐列表
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> successCase() {
        return baseDao.list(namespace + ".successCase", null);
    }

    /**
     * 优秀讲师列表
     * 
     * @param
     * @return
     */
    public List<PartnerBO> excellentTeacher() {
        return baseDao.list(namespace + ".excellentTeacher", null);
    }

    /**
     * 合作机构列表
     * 
     * @param
     * @return
     */
    public List<PartnerBO> partners() {
        return baseDao.list(namespace + ".partners", null);
    }

    /**
     * 数据小贴士指标信息
     * 
     * @param
     * @return
     */
    public List<IndexNoteListBO> dataTipsIndex() {
        return baseDao.list(namespace + ".dataTipsIndex", null);
    }

    /**
     * 数据小贴士来源信息
     * 
     * @param
     * @return
     */
    public List<SourceNoteListBO> dataTipsSource() {
        return baseDao.list(namespace + ".dataTipsSource", null);
    }

    /**
     * 数据小贴士常见问题
     * 
     * @param
     * @return
     */
    public List<FaqBO> dataTipsFaq() {
        return baseDao.list(namespace + ".dataTipsFaq", null);
    }
}
