/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.dal.dao.helpCenter;

import java.util.List;

import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.FaqBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteListBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceMenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteListBO;

/**
 * 类HelpCenterDao.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月25日 下午3:34:07
 */
public interface HelpCenterDao {

    /**
     * 指标注释筛选
     * 
     * @param versionType 产品版本
     * @return
     */
    public List<MenuBO> indexNoteRelation(String versionType);

    /**
     * 菜单、指标关系
     * 
     * @param
     * @return
     */
    public List<MenuBO> menuIndexRelation();

    /**
     * 来源注释菜单、指标关系
     * 
     * @param
     * @return
     */
    public List<SourceMenuBO> menuSourceRelation();

    /**
     * 取得指标注释菜单ID
     * 
     * @param
     * @return
     */
    public List<MenuBO> menuId();

    /**
     * 取得来源注释菜单ID
     * 
     * @param
     * @return
     */
    public List<SourceMenuBO> menuSourceId();

    /**
     * 指标注释列表
     * 
     * @param keyword 搜索词
     * @param menuId 菜单ID
     * @return
     */
    public List<IndexNoteListBO> getIndexNoteList(String keyword, String versionType);

    /**
     * 来源注释筛选
     * 
     * @param flowType 设备类型
     * @return
     */
    public List<SourceMenuBO> sourceNoteRelation(String deviceType);

    /**
     * 来源注释列表
     * 
     * @param keyword 搜索词
     * @param flowType 来源类型
     * @return
     */
    public List<SourceNoteListBO> getSourceNoteList(String keyword, String flowType);

    /**
     * 常见问题列表
     * 
     * @param faqCode 问题分类ID
     * @param keyword 搜索词
     * @return
     */
    public List<FaqBO> getFaqList(String faqCategoryId, String keyword);

    /**
     * 主题类别列表
     * 
     * @param
     * @return
     */
    public List<FaqBO> getFaqCategory();
}
