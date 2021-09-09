/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.web.home.module.rpc.collegeOverview;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.extension.rpc.annotation.ResourceMapping;
import com.alibaba.citrus.extension.rpc.annotation.WebResource;
import com.alibaba.dt.op.college.biz.bo.collegeOverview.PartnerBO;
import com.alibaba.dt.op.college.biz.bo.collegeOverview.RecommendCourseBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.DataTipsBO;
import com.alibaba.dt.op.college.biz.service.collegeOverview.CollegeOverviewService;

/**
 * 类CollegeOverview.java的实现描述：学院概况
 * 
 * @author zishao.zb 2016年5月17日 下午9:38:57
 */
@WebResource("collegeOverview")
public class CollegeOverviewRpc {

    @Autowired
    private HttpServletRequest     request;
    @Autowired
    private HttpServletResponse    response;

    @Autowired
    private CollegeOverviewService collegeOverviewService;

    /**
     * 产品功能课程推荐列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("/productFeature")
    public List<RecommendCourseBO> productFeature() {
        List<RecommendCourseBO> recommendCourseBOList = new ArrayList<RecommendCourseBO>();
        recommendCourseBOList = collegeOverviewService.productFeature();
        return recommendCourseBOList;
    }

    /**
     * 数据化运营课程推荐列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("/dataManagement")
    public List<RecommendCourseBO> dataManagement() {
        List<RecommendCourseBO> recommendCourseBOList = new ArrayList<RecommendCourseBO>();
        recommendCourseBOList = collegeOverviewService.dataManagement();
        return recommendCourseBOList;
    }

    /**
     * 新课速递课程推荐列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("/newCourseDelivery")
    public List<RecommendCourseBO> newCourseDelivery() {
        List<RecommendCourseBO> recommendCourseBOList = new ArrayList<RecommendCourseBO>();
        recommendCourseBOList = collegeOverviewService.newCourseDelivery();
        return recommendCourseBOList;
    }

    /**
     * 成功案例课程推荐列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("/successCase")
    public List<RecommendCourseBO> successCase() {
        List<RecommendCourseBO> recommendCourseBOList = new ArrayList<RecommendCourseBO>();
        recommendCourseBOList = collegeOverviewService.successCase();
        return recommendCourseBOList;
    }

    /**
     * 优秀讲师列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("excellentTeacher")
    public List<PartnerBO> excellentTeacher() {
        List<PartnerBO> partnerBOList = new ArrayList<PartnerBO>();
        partnerBOList = collegeOverviewService.excellentTeacher();
        return partnerBOList;
    }

    /**
     * 合作机构列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("partners")
    public List<PartnerBO> partners() {
        List<PartnerBO> partnerBOList = new ArrayList<PartnerBO>();
        partnerBOList = collegeOverviewService.partners();
        return partnerBOList;
    }

    /**
     * 数据小贴士列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("dataTips")
    public List<DataTipsBO> dataTips() {
        List<DataTipsBO> dataTipsBOList = new ArrayList<DataTipsBO>();
        dataTipsBOList = collegeOverviewService.dataTips();
        return dataTipsBOList;
    }
}
