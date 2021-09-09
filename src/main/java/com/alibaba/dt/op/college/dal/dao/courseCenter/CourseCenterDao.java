/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.dal.dao.courseCenter;

import java.util.List;

import com.alibaba.dt.op.college.biz.bo.collegeOverview.RecommendCourseBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.CourseBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.CourseDetailBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;

/**
 * 类CourseCenterDao.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月20日 下午6:00:31
 */
public interface CourseCenterDao {

    /**
     * 课程主题和分类对应关系列表
     * 
     * @param
     * @return
     */
    public List<MenuBO> getCategory();

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
    public List<CourseBO> courseList(String keyword, String subject, String category, String type);

    /**
     * 课程学习人次统计
     * 
     * @param courseId 课程ID
     * @return
     */
    public boolean count(Integer courseId);

    /**
     * 课程推荐
     * 
     * @param
     * @return
     */
    public List<RecommendCourseBO> courseRecommend();

    /**
     * 用户对课程打分
     * 
     * @param courseId
     * @param grade
     * @return
     */
    public boolean insertGrade(Long userId, Integer courseId, Float grade);

    /**
     * 判断用户是否对课程打过分
     * 
     * @param userId
     * @param courseId
     * @return
     */
    public Integer getUserCourse(Long userId, Integer courseId);

    /**
     * 更新用户对课程的评分
     * 
     * @param userId
     * @param courseId
     * @param grade
     * @return
     */
    public boolean updateGrade(Long userId, Integer courseId, Float grade);

    /**
     * 获取当前用户对课程的打分
     * 
     * @param userId
     * @param courseId
     * @return
     */
    public Integer getUserGrade(Long userId, Integer courseId);

    /**
     * 获取课程详情
     * 
     * @param courseId
     * @return
     */
    public CourseDetailBO getCourseDetail(Integer courseId);

    /**
     * 获取课程平均分
     * 
     * @param courseId
     * @return
     */
    public Float getCourseAvgScore(Integer courseId);

    /**
     * 获取课程相关联的课程
     * 
     * @param courseId
     * @return
     */
    public List<CourseBO> getRelevantCourse(Integer courseId);
}
