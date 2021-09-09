/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.collegeOverview.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dt.op.college.biz.bo.collegeOverview.PartnerBO;
import com.alibaba.dt.op.college.biz.bo.collegeOverview.RecommendCourseBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.DataTipsBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.FaqBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteListBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteListBO;
import com.alibaba.dt.op.college.biz.service.collegeOverview.CollegeOverviewService;
import com.alibaba.dt.op.college.biz.service.helpCenter.PreloadService;
import com.alibaba.dt.op.college.biz.service.helpCenter.impl.HelpCenterServiceImpl;
import com.alibaba.dt.op.college.dal.dao.collegeOverview.CollegeOverviewDao;

/**
 * 类CollegeOverviewServiceImpl.java的实现描述：学院概况
 * 
 * @author zishao.zb 2016年5月18日 上午9:44:50
 */
@Service
public class CollegeOverviewServiceImpl implements CollegeOverviewService {

    @Autowired
    private CollegeOverviewDao    collegeOverviewDao;
    @Autowired
    private HelpCenterServiceImpl helpCenterServiceImpl;
    @Autowired
    private PreloadService        preloadService;

    /**
     * 产品功能课程推荐列表
     * 
     * @param
     * @return
     */
    @Override
    public List<RecommendCourseBO> productFeature() {
        return collegeOverviewDao.productFeature();
    }

    /**
     * 数据化运营课程推荐列表
     * 
     * @param
     * @return
     */
    @Override
    public List<RecommendCourseBO> dataManagement() {
        return collegeOverviewDao.dataManagement();
    }

    /**
     * 新课速递课程推荐列表
     * 
     * @param
     * @return
     */
    @Override
    public List<RecommendCourseBO> newCourseDelivery() {
        List<RecommendCourseBO> RecommendCourseBOList = collegeOverviewDao.newCourseDelivery();
        for (int i = 0; i < RecommendCourseBOList.size(); i++) {
            String title = RecommendCourseBOList.get(i).getTitle();
            title = title.replaceAll("\\u2028", "");
            // title = title.replaceAll("\\u0", "");
            RecommendCourseBOList.get(i).setTitle(title);
        }
        return RecommendCourseBOList;
    }

    /**
     * 成功案例课程推荐列表
     * 
     * @param
     * @return
     */
    @Override
    public List<RecommendCourseBO> successCase() {
        return collegeOverviewDao.successCase();
    }

    /**
     * 优秀讲师列表
     * 
     * @param
     * @return
     */
    public List<PartnerBO> excellentTeacher() {
        return collegeOverviewDao.excellentTeacher();
    }

    /**
     * 合作机构列表
     * 
     * @param
     * @return
     */
    public List<PartnerBO> partners() {
        return collegeOverviewDao.partners();
    }

    /**
     * 数据小贴士列表
     * 
     * @param
     * @return
     */
    public List<DataTipsBO> dataTips() {
        List<DataTipsBO> dataTipsBOList = new ArrayList<DataTipsBO>();
        List<IndexNoteListBO> indexNoteListBO = new ArrayList<IndexNoteListBO>();
        indexNoteListBO = collegeOverviewDao.dataTipsIndex();
        if (indexNoteListBO != null) {
            Integer indexId = indexNoteListBO.get(0).getIndexId();
            Map<Integer, HashSet<Integer>> menuIndexMap = preloadService.menuIndexMap;
            Map<Integer, Integer> menuIdParentIdMap = preloadService.menuIdParentIdMap;
            Map<Integer, String> menuIdNameMap = preloadService.menuIdNameMap;
            List<Integer> menuIdList = new ArrayList<Integer>();
            Set<Integer> menuIdSet = new HashSet<Integer>();
            for (Entry<Integer, HashSet<Integer>> entry : menuIndexMap.entrySet()) {
                if (menuIndexMap.get(entry.getKey()).contains(indexId)) {
                    menuIdSet.add(entry.getKey());
                }
            }
            Integer tmpParentId = 0;
            Iterator<Integer> it = menuIdSet.iterator();
            for (int i = 0; i < menuIdSet.size(); i++) {
                while (it.hasNext()) {
                    Integer menuID = it.next();
                    if (menuIdParentIdMap.get(menuID).intValue() == tmpParentId.intValue()) {
                        menuIdList.add(menuID);
                        tmpParentId = menuID;
                    }
                }
                it = menuIdSet.iterator();
            }
            List<String> path = new ArrayList<String>();
            for (Integer menuID : menuIdList) {
                String menuName = menuIdNameMap.get(menuID);
                path.add(menuName);
            }
            DataTipsBO dataTipsBO = new DataTipsBO();
            dataTipsBO.setType("0");
            dataTipsBO.setTitle(indexNoteListBO.get(0).getName());
            dataTipsBO.setClassify("所属模块");
            dataTipsBO.setNavigations(path);
            dataTipsBO.setAnnotation(indexNoteListBO.get(0).getDescription());
            dataTipsBOList.add(dataTipsBO);
        }

        List<SourceNoteListBO> sourceNoteListBO = new ArrayList<SourceNoteListBO>();
        sourceNoteListBO = collegeOverviewDao.dataTipsSource();
        if (sourceNoteListBO != null) {
            String sourceId = sourceNoteListBO.get(0).getSourceId();
            Map<String, HashSet<String>> menuIndexSourceMap = preloadService.menuIndexSourceMap;
            Map<String, String> menuIdParentIdSourceMap = preloadService.menuIdParentIdSourceMap;
            Map<String, String> menuIdNameSourceMap = preloadService.menuIdNameSourceMap;
            List<String> menuIdList = new ArrayList<String>();
            Set<String> menuIdSet = new HashSet<String>();
            for (Entry<String, HashSet<String>> entry : menuIndexSourceMap.entrySet()) {
                if (menuIndexSourceMap.get(entry.getKey()).contains(sourceId)) {
                    menuIdSet.add(entry.getKey());
                }
            }
            String tmpParentId = "0";
            Iterator<String> it = menuIdSet.iterator();
            for (int i = 0; i < menuIdSet.size(); i++) {
                while (it.hasNext()) {
                    String menuID = it.next();
                    if (menuIdParentIdSourceMap.get(menuID).equals(tmpParentId)) {
                        menuIdList.add(menuID);
                        tmpParentId = menuID;
                    }
                }
                it = menuIdSet.iterator();
            }
            List<String> path = new ArrayList<String>();
            for (String menuID : menuIdList) {
                String menuName = menuIdNameSourceMap.get(menuID);
                path.add(menuName);
            }
            DataTipsBO dataTipsBO = new DataTipsBO();
            dataTipsBO.setType("1");
            dataTipsBO.setTitle(sourceNoteListBO.get(0).getName());
            dataTipsBO.setClassify("所属分类");
            dataTipsBO.setNavigations(path);
            dataTipsBO.setAnnotation(sourceNoteListBO.get(0).getDescription());
            dataTipsBOList.add(dataTipsBO);
        }

        List<FaqBO> faqBOList = new ArrayList<FaqBO>();
        faqBOList = collegeOverviewDao.dataTipsFaq();
        if (faqBOList != null) {
            List<String> pathFaq = new ArrayList<String>();
            pathFaq.add(faqBOList.get(0).getCategory());
            DataTipsBO DataTipsBOFaq = new DataTipsBO();
            DataTipsBOFaq.setType("2");
            DataTipsBOFaq.setTitle(faqBOList.get(0).getQuestion());
            DataTipsBOFaq.setClassify("所属分类");
            DataTipsBOFaq.setNavigations(pathFaq);
            DataTipsBOFaq.setAnnotation(faqBOList.get(0).getAnswer());
            dataTipsBOList.add(DataTipsBOFaq);
        }

        return dataTipsBOList;
    }
}
