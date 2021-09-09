/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.web.home.module.rpc.courseCenter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.extension.rpc.annotation.ResourceMapping;
import com.alibaba.citrus.extension.rpc.annotation.WebResource;
import com.alibaba.dt.op.college.biz.bo.courseCenter.CourseBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.CourseDetailBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.StatusBO;
import com.alibaba.dt.op.college.biz.service.courseCenter.CourseCenterService;
import com.alibaba.nonda.databind.annotation.RequestParam;

/**
 * 类CourseDetailRpc.java的实现描述：课程详情
 * 
 * @author zishao.zb 2016年5月24日 上午10:01:13
 */
@WebResource("courseDetail")
public class CourseDetailRpc {

    @Autowired
    private HttpServletRequest  request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private CourseCenterService courseCenterService;

    /**
     * 用户对课程打分
     * 
     * @param courseId
     * @param grade
     * @return
     */
    @ResourceMapping("updateGrade")
    public StatusBO updateGrade(@RequestParam(name = "courseId") Integer courseId,
                                @RequestParam(name = "grade") Float grade) {
        StatusBO statusBO = new StatusBO();
        Boolean statusResult = courseCenterService.updateGrade(courseId, grade);
        statusBO.setStatus(statusResult);
        return statusBO;
    }

    /**
     * 获取课程详情
     * 
     * @param courseId
     * @param grade
     * @return
     */
    @ResourceMapping("getCourseDetail")
    public CourseDetailBO getCourseDetail(@RequestParam(name = "courseId") Integer courseId) {
        CourseDetailBO courseDetailBO = new CourseDetailBO();
        courseDetailBO = courseCenterService.getCourseDetail(courseId);
        return courseDetailBO;
    }

    /**
     * 获取课程相关联的课程
     * 
     * @param courseId
     * @return
     */
    @ResourceMapping("getRelevantCourse")
    public List<CourseBO> getRelevantCourse(@RequestParam(name = "courseId") Integer courseId) {
        List<CourseBO> courseBOList = new ArrayList<CourseBO>();
        courseBOList = courseCenterService.getRelevantCourse(courseId);
        return courseBOList;
    }
}
