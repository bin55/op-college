/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.dal.dao.helpCenter.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.FaqBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteListBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceMenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteListBO;
import com.alibaba.dt.op.college.dal.dao.helpCenter.HelpCenterDao;
import com.alibaba.dt.op.common.dal.dao.BaseDao;

/**
 * 类HelpCenterDaoImpl.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月25日 下午4:03:05
 */
@Service
public class HelpCenterDaoImpl implements HelpCenterDao {

    private static final String namespace = HelpCenterDaoImpl.class.getName();
    @Autowired
    private BaseDao             baseDao;

    /**
     * 指标注释筛选
     * 
     * @param versionType 产品版本
     * @return
     */
    public List<MenuBO> indexNoteRelation(String versionType) {
        return baseDao.list(namespace + ".indexNoteRelation", versionType);
    }

    /**
     * 菜单、指标关系
     * 
     * @param
     * @return
     */
    public List<MenuBO> menuIndexRelation() {
        return baseDao.list(namespace + ".menuIndexRelation", null);
    }

    /**
     * 来源注释菜单、指标关系
     * 
     * @param
     * @return
     */
    public List<SourceMenuBO> menuSourceRelation() {
        return baseDao.list(namespace + ".menuSourceRelation", null);
    }

    /**
     * 取得指标注释菜单ID
     * 
     * @param
     * @return
     */
    public List<MenuBO> menuId() {
        return baseDao.list(namespace + ".menuId", null);
    }

    /**
     * 取得来源注释菜单ID
     * 
     * @param
     * @return
     */
    public List<SourceMenuBO> menuSourceId() {
        return baseDao.list(namespace + ".menuSourceId", null);
    }

    /**
     * 指标注释列表
     * 
     * @param keyword 搜索词
     * @param menuId 菜单ID
     * @return
     */
    public List<IndexNoteListBO> getIndexNoteList(String keyword, String versionType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("keyword", keyword);
        params.put("versionType", versionType);
        return baseDao.list(namespace + ".getIndexNoteList", params);
    }

    /**
     * 来源注释筛选
     * 
     * @param flowType 设备类型
     * @return
     */
    public List<SourceMenuBO> sourceNoteRelation(String deviceType) {
        return baseDao.list(namespace + ".sourceNoteRelation", deviceType);
    }

    /**
     * 来源注释列表
     * 
     * @param keyword 搜索词
     * @param flowType 来源类型
     * @return
     */
    public List<SourceNoteListBO> getSourceNoteList(String keyword, String flowType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("keyword", keyword);
        params.put("flowType", flowType);
        return baseDao.list(namespace + ".getSourceNoteList", params);
    }

    /**
     * 常见问题列表
     * 
     * @param faqCode 问题分类ID
     * @param keyword 搜索词
     * @return
     */
    public List<FaqBO> getFaqList(String faqCategoryId, String keyword) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("faqCategoryId", faqCategoryId);
        params.put("keyword", keyword);
        return baseDao.list(namespace + ".getFaqList", params);
    }

    /**
     * 主题类别列表
     * 
     * @param
     * @return
     */
    public List<FaqBO> getFaqCategory() {
        return baseDao.list(namespace + ".getFaqCategory", null);
    }
}
