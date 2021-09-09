/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.helpCenter.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.FaqBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteListBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceMenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteListBO;
import com.alibaba.dt.op.college.biz.service.helpCenter.HelpCenterService;
import com.alibaba.dt.op.college.biz.service.helpCenter.MapService;
import com.alibaba.dt.op.college.biz.service.helpCenter.PreloadService;
import com.alibaba.dt.op.college.biz.util.Node;
import com.alibaba.dt.op.college.biz.util.SourceNode;
import com.alibaba.dt.op.college.dal.dao.helpCenter.HelpCenterDao;
import com.alibaba.dt.op.common.result.ResultPaginatedModel;
import com.alibaba.dt.op.common.util.PageUtil;

/**
 * 类HelpCenterServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月25日 下午2:54:53
 */
@Service
public class HelpCenterServiceImpl implements HelpCenterService {

    @Autowired
    private HelpCenterDao             helpCenterDao;

    @Autowired
    private PreloadService            preloadService;
    @Autowired
    private MapService                mapService;

    private static Map<Date, Integer> dateFlag = new HashMap<Date, Integer>();

    static {
        Date now = new Date();
        dateFlag.put(now, 0);
    }

    /**
     * 指标注释筛选
     * 
     * @param versionType 产品版本
     * @return
     */
    public List<MenuBO> indexNoteRelation(String versionType) {
        return helpCenterDao.indexNoteRelation(versionType);
    }

    /**
     * 指标注释菜单、指标关系
     * 
     * @param
     * @return
     */
    @Override
    public List<Node> menuIndexRelation() {
        List<MenuBO> menuBOList = helpCenterDao.menuIndexRelation();
        List<Node> nodeList = new ArrayList<Node>();
        for (int i = 0; i < menuBOList.size(); i++) {
            Integer id = menuBOList.get(i).getId();
            Integer parentId = menuBOList.get(i).getParentId();
            String name = menuBOList.get(i).getName();
            nodeList.add(new Node(id, parentId, name));
        }
        return nodeList;
    }

    /**
     * 来源注释菜单、指标关系
     * 
     * @param
     * @return
     */
    @Override
    public List<SourceNode> menuSourceRelation() {
        List<SourceMenuBO> menuBOList = helpCenterDao.menuSourceRelation();
        List<SourceNode> nodeList = new ArrayList<SourceNode>();
        for (int i = 0; i < menuBOList.size(); i++) {
            String id = menuBOList.get(i).getId();
            String parentId = menuBOList.get(i).getParentId();
            String name = menuBOList.get(i).getName();
            nodeList.add(new SourceNode(id, parentId, name));
        }
        return nodeList;
    }

    /**
     * 指标注释列表
     * 
     * @param keyword 搜索词
     * @param menuId 菜单ID
     * @param page 当前页数
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public ResultPaginatedModel<IndexNoteListBO> getIndexNoteList(String keyword, String versionType, Integer menuId,
                                                                  Integer pageStart, Integer pageSize) {
        List<IndexNoteListBO> indexNoteListBOList = new ArrayList<IndexNoteListBO>();
        Integer recordCount = 0;
        indexNoteListBOList = helpCenterDao.getIndexNoteList(keyword, versionType);
        if (menuId != 0) {
            Set<Integer> indexIdSet = new HashSet<Integer>();
            indexIdSet = mapService.getChildNodes(menuId);
            for (int i = 0; i < indexNoteListBOList.size(); i++) {
                if (!indexIdSet.contains(indexNoteListBOList.get(i).getIndexId())) {
                    indexNoteListBOList.remove(i);
                    i--;
                }
            }
        }

        Map<Integer, HashSet<Integer>> menuIndexMap = preloadService.menuIndexMap;
        Map<Integer, Integer> menuIdParentIdMap = preloadService.menuIdParentIdMap;
        Map<Integer, String> menuIdNameMap = preloadService.menuIdNameMap;
        // Map<Integer, HashSet<Integer>> menuIndexMap = mapService.getMenuIndexMap();
        // Map<Integer, Integer> menuIdParentIdMap = mapService.getMenuIdParentIdMap();
        // Map<Integer, String> menuIdNameMap = mapService.getMenuIdNameMap();

        for (IndexNoteListBO indexNoteListBO : indexNoteListBOList) {
            List<Integer> menuIdList = new ArrayList<Integer>();
            Set<Integer> menuIdSet = new HashSet<Integer>();
            Integer indexId = indexNoteListBO.getIndexId();
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
            indexNoteListBO.setPath(path);
        }

        // recordCount = indexNoteListBOList == null ? 0 : PageUtil.getAllPage(indexNoteListBOList.size(), pageSize);
        recordCount = indexNoteListBOList == null ? 0 : indexNoteListBOList.size();
        indexNoteListBOList = PageUtil.subPage(indexNoteListBOList, pageStart, pageSize);

        Date time = this.getTaskTime();
        Timer timer = new Timer();
        timer.schedule(new MyTaskImpl(), time);

        return new ResultPaginatedModel<IndexNoteListBO>(indexNoteListBOList, recordCount);
    }

    /**
     * 来源注释筛选
     * 
     * @param flowType 设备类型
     * @return
     */
    public List<SourceMenuBO> sourceNoteRelation(String deviceType) {
        return helpCenterDao.sourceNoteRelation(deviceType);
    }

    /**
     * 来源注释列表
     * 
     * @param keyword 搜索词
     * @param flowType 来源类型
     * @param menuId 来源菜单ID
     * @param page 当前页数
     * @param pageSize 每页记录数
     * @return
     */
    public ResultPaginatedModel<SourceNoteListBO> getSourceNoteList(String keyword, String flowType, String menuId,
                                                                    Integer pageStart,

                                                                    Integer pageSize) {
        List<SourceNoteListBO> sourceNoteListBOList = new ArrayList<SourceNoteListBO>();
        Integer recordCount = 0;
        sourceNoteListBOList = helpCenterDao.getSourceNoteList(keyword, flowType);
        if (!menuId.equals("0")) {
            Set<String> sourceIdSet = new HashSet<String>();
            sourceIdSet = mapService.getSourceChildNodes(menuId);
            for (int i = 0; i < sourceNoteListBOList.size(); i++) {
                if (!sourceIdSet.contains(sourceNoteListBOList.get(i).getSourceId())) {
                    sourceNoteListBOList.remove(i);
                    i--;
                }
            }
        }

        Map<String, HashSet<String>> menuIndexSourceMap = preloadService.menuIndexSourceMap;
        Map<String, String> menuIdParentIdSourceMap = preloadService.menuIdParentIdSourceMap;
        Map<String, String> menuIdNameSourceMap = preloadService.menuIdNameSourceMap;
        // Map<String, HashSet<String>> menuIndexSourceMap = mapService.getMenuIndexSourceMap();
        // Map<String, String> menuIdParentIdSourceMap = mapService.getMenuIdParentIdSourceMap();
        // Map<String, String> menuIdNameSourceMap = mapService.getMenuIdNameSourceMap();
        for (SourceNoteListBO sourceNoteListBO : sourceNoteListBOList) {
            List<String> menuIdList = new ArrayList<String>();
            Set<String> menuIdSet = new HashSet<String>();
            String sourceId = sourceNoteListBO.getSourceId();
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
            sourceNoteListBO.setCategory(path);
        }

        // recordCount = sourceNoteListBOList == null ? 0 : PageUtil.getAllPage(sourceNoteListBOList.size(), pageSize);
        recordCount = sourceNoteListBOList == null ? 0 : sourceNoteListBOList.size();
        sourceNoteListBOList = PageUtil.subPage(sourceNoteListBOList, pageStart, pageSize);

        return new ResultPaginatedModel<SourceNoteListBO>(sourceNoteListBOList, recordCount);
    }

    /**
     * 常见问题列表
     * 
     * @param faqCode 问题分类ID
     * @param keyword 搜索词
     * @param page 当前页
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public ResultPaginatedModel<FaqBO> getFaqList(String faqCategoryId, String keyword, Integer pageStart,
                                                  Integer pageSize) {
        List<FaqBO> faqBOList = new ArrayList<FaqBO>();
        Integer recordCount = 0;
        faqBOList = helpCenterDao.getFaqList(faqCategoryId, keyword);

        // recordCount = faqBOList == null ? 0 : PageUtil.getAllPage(faqBOList.size(), pageSize);
        recordCount = faqBOList == null ? 0 : faqBOList.size();
        faqBOList = PageUtil.subPage(faqBOList, pageStart, pageSize);

        return new ResultPaginatedModel<FaqBO>(faqBOList, recordCount);
    }

    /**
     * 主题类别列表
     * 
     * @param
     * @return
     */
    @Override
    public List<FaqBO> getFaqCategory() {
        return helpCenterDao.getFaqCategory();
    }

    public Date getTaskTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        return time;
    }

    public static void main(String args[]) {

    }

}

class MyTaskImpl extends TimerTask {

    @Override
    public void run() {
        PreloadService.getInstance().reloadData();
    }
}
