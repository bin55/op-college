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
import com.alibaba.dt.op.college.biz.bo.collegeOverview.RecommendCourseBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.CourseBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.CourseSubjectBO;
import com.alibaba.dt.op.college.biz.bo.courseCenter.StatusBO;
import com.alibaba.dt.op.college.biz.service.courseCenter.CourseCenterService;
import com.alibaba.dt.op.college.biz.util.SubjectCategoryNode;
import com.alibaba.dt.op.college.biz.util.SubjectCategoryTree;
import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;
import com.alibaba.dt.op.common.result.ResultPaginatModel;
import com.alibaba.dt.op.common.util.PageUtil;
import com.alibaba.nonda.databind.annotation.RequestParam;

/**
 * 类CourseCenter.java的实现描述：课程中心
 * 
 * @author zishao.zb 2016年5月20日 上午11:17:26
 */
@WebResource("courseCenter")
public class CourseCenterRpc {

    @Autowired
    private HttpServletRequest  request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private CourseCenterService courseCenterService;

    /**
     * 课程主题和分类对应关系列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("getCategory")
    public CourseSubjectBO getCategory() {
        List<MenuBO> menuBOList = courseCenterService.getCategory();
        List<SubjectCategoryNode> SubjectCategoryNodeList = new ArrayList<SubjectCategoryNode>();
        SubjectCategoryTree tb = new SubjectCategoryTree();
        for (int i = 0; i < menuBOList.size(); i++) {
            Integer id = menuBOList.get(i).getId();
            Integer parentId = menuBOList.get(i).getParentId();
            String name = menuBOList.get(i).getName();
            SubjectCategoryNodeList.add(new SubjectCategoryNode(id, parentId, name));
        }
        List<SubjectCategoryNode> menuSubjectCategoryNodeList = tb.buildListToTree(SubjectCategoryNodeList);
        List<SubjectCategoryNode> menuSubjectCategoryNodeBOList = recurseMenu(menuSubjectCategoryNodeList);
        CourseSubjectBO courseSubjectBO = new CourseSubjectBO();
        courseSubjectBO.setSubject(menuSubjectCategoryNodeBOList);
        return courseSubjectBO;
    }

    /**
     * 课程列表
     * 
     * @param keyword 搜索关键词
     * @param subject 主题
     * @param category 分类
     * @param type 课程类型
     * @param orderField 排序字段，默认按更新时间
     * @param orderDesc 排序，默认降序
     * @param pageSize 每页显示条数
     * @param currentPage 当前第几页
     * @return
     */
    @ResourceMapping("courseList")
    public ResultPaginatModel<CourseBO> courseList(@RequestParam(name = "keyword") String keyword,
                                                   @RequestParam(name = "subject") String subject,
                                                   @RequestParam(name = "category") String category,
                                                   @RequestParam(name = "type") String type,
                                                   @RequestParam(name = "sortFiled", defaultValue = "gmtModify") String orderField,
                                                   @RequestParam(name = "sort", defaultValue = "desc") String orderDesc,
                                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                   @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage) {
        return courseCenterService.courseList(keyword, subject, category, type, orderField, orderDesc,
                                              PageUtil.getPageStart(currentPage, pageSize), pageSize);
    }

    /**
     * 课程学习人次统计
     * 
     * @param courseId 课程ID
     * @return
     */
    @ResourceMapping("count")
    public StatusBO count(@RequestParam(name = "courseId") Integer courseId) {
        StatusBO statusBO = new StatusBO();
        Boolean statusResult = courseCenterService.count(courseId);
        statusBO.setStatus(statusResult);
        return statusBO;
    }

    /**
     * 课程推荐
     * 
     * @param
     * @return
     */
    @ResourceMapping("courseRecommend")
    public List<RecommendCourseBO> courseRecommend() {
        List<RecommendCourseBO> recommendCourseBOList = new ArrayList<RecommendCourseBO>();
        recommendCourseBOList = courseCenterService.courseRecommend();
        return recommendCourseBOList;
    }

    private List<SubjectCategoryNode> recurseMenu(List<SubjectCategoryNode> menuSubjectCategoryNodeList) {
        List<SubjectCategoryNode> menuSubjectCategoryNodeBOList = new ArrayList<SubjectCategoryNode>();
        if (!menuSubjectCategoryNodeList.isEmpty()) {
            for (SubjectCategoryNode menuSubjectCategoryNode : menuSubjectCategoryNodeList) {
                SubjectCategoryNode SubjectCategoryNode = new SubjectCategoryNode();
                SubjectCategoryNode.setId(menuSubjectCategoryNode.getId());
                SubjectCategoryNode.setName(menuSubjectCategoryNode.getName());
                SubjectCategoryNode.setCategory(this.recurseMenu(menuSubjectCategoryNode.getCategory()));
                menuSubjectCategoryNodeBOList.add(SubjectCategoryNode);
            }
        }
        return menuSubjectCategoryNodeBOList;
    }
}
