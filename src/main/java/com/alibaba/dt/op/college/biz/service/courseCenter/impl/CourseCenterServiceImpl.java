/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.courseCenter.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dt.op.college.biz.bo.collegeOverview.RecommendCourseBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.CourseBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.CourseDetailBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;
import com.alibaba.dt.op.college.biz.service.courseCenter.CourseCenterService;
import com.alibaba.dt.op.college.dal.dao.courseCenter.CourseCenterDao;
import com.alibaba.dt.op.common.result.ResultPaginatModel;
import com.alibaba.dt.op.common.util.PageUtil;
import com.alibaba.dt.op.eauthclient.web.helper.LoginHelper;
import com.alibaba.dt.op.lang.exception.BizException;
import com.alibaba.dt.op.lang.exception.error.SystemErrors;
import com.alibaba.dt.op.lang.util.collection.SortUtil;

/**
 * 类CourseCenterServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月20日 下午5:57:50
 */
@Service
public class CourseCenterServiceImpl implements CourseCenterService {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CourseCenterDao    courseCenterDao;

    /**
     * 课程主题和分类对应关系列表
     * 
     * @param
     * @return
     */
    public List<MenuBO> getCategory() {
        return courseCenterDao.getCategory();
    }

    /**
     * 课程列表
     * 
     * @param keyword 搜索关键词
     * @param subject 主题
     * @param category 分类
     * @param type 课程类型
     * @param orderDesc 排序方向
     * @param orderField 排序字段
     * @param pageSize 每页显示条数
     * @param currentPage 当前第几页
     * @return
     */
    public ResultPaginatModel<CourseBO> courseList(String keyword, String subject, String category, String type,
                                                   String orderField, String orderDesc, Integer pageStart,
                                                   Integer pageSize) {

        List<CourseBO> courseBOList = new ArrayList<CourseBO>();
        Integer allPage = 0;
        courseBOList = courseCenterDao.courseList(keyword, subject, category, type);
        List<CourseBO> courseBOFilterList = new ArrayList<CourseBO>();
        for (CourseBO courseBO : courseBOList) {
            Integer id = courseBO.getId();
            int count = 0;
            for (int i = 0; i < courseBOFilterList.size(); i++) {
                if (courseBOFilterList.get(i).getId().intValue() == id.intValue()) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                courseBOFilterList.add(courseBO);
            }
        }
        if (!orderDesc.equalsIgnoreCase("desc")) {
            List<CourseBO> tempInverted = new ArrayList<CourseBO>();
            for (int i = courseBOFilterList.size() - 1; i > -1; --i) {
                tempInverted.add(courseBOFilterList.get(i));
            }
            courseBOFilterList = SortUtil.sortByAsc(tempInverted, orderField);
        } else {
            courseBOFilterList = SortUtil.sortByDesc(courseBOFilterList, orderField);
        }

        allPage = courseBOFilterList == null ? 0 : PageUtil.getAllPage(courseBOFilterList.size(), pageSize);
        courseBOFilterList = PageUtil.subPage(courseBOFilterList, pageStart, pageSize);

        return new ResultPaginatModel<CourseBO>(courseBOFilterList, allPage);
    }

    /**
     * 课程学习人次统计
     * 
     * @param courseId 课程ID
     * @return
     */
    public boolean count(Integer courseId) {
        return courseCenterDao.count(courseId);
    }

    /**
     * 课程推荐
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> courseRecommend() {
        return courseCenterDao.courseRecommend();
    }

    /**
     * 用户对课程打分
     * 
     * @param courseId
     * @param grade
     * @return
     */
    @Override
    public boolean updateGrade(Integer courseId, Float grade) {
        Long userId = null;
        try {
            userId = LoginHelper.getLoginUserId(request);
        } catch (Exception e) {
            throw new BizException(SystemErrors.USER_NO_LOGIN);
        }
        boolean flag = courseCenterDao.getUserCourse(userId, courseId) != 0 ? true : false;
        if (!flag) {
            return courseCenterDao.insertGrade(userId, courseId, grade);

        }
        return courseCenterDao.updateGrade(userId, courseId, grade);
    }

    /**
     * 获取当前用户对课程的打分
     * 
     * @param userId
     * @return
     */
    public Integer getUserGrade(Long userId, Integer courseId) {
        return courseCenterDao.getUserGrade(userId, courseId);
    }

    /**
     * 获取课程详情
     * 
     * @param courseId
     * @param grade
     * @return
     */
    public CourseDetailBO getCourseDetail(Integer courseId) {
        CourseDetailBO courseDetailBO = new CourseDetailBO();
        courseDetailBO = courseCenterDao.getCourseDetail(courseId);
        Float avgScore = courseCenterDao.getCourseAvgScore(courseId);
        if (courseDetailBO != null) {
            Long userId = null;
            try {
                userId = LoginHelper.getLoginUserId(request);
            } catch (Exception e) {
                throw new BizException(SystemErrors.USER_NO_LOGIN);
            }
            Integer grade = this.getUserGrade(userId, courseId);
            if (grade == null) {
                grade = 0;
            }
            courseDetailBO.setUserGrade(grade);
            courseDetailBO.setGrade(avgScore);
        }
        return courseDetailBO;
    }

    /**
     * 获取课程相关联的课程
     * 
     * @param courseId
     * @return
     */
    public List<CourseBO> getRelevantCourse(Integer courseId) {
        return courseCenterDao.getRelevantCourse(courseId);
    }
}
