/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.helpCenter;

import java.util.List;

import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.FaqBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteListBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceMenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteListBO;
import com.alibaba.dt.op.college.biz.util.Node;
import com.alibaba.dt.op.college.biz.util.SourceNode;
import com.alibaba.dt.op.common.result.ResultPaginatedModel;

/**
 * 类HelpCenterService.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月25日 下午2:42:30
 */
public interface HelpCenterService {

    /**
     * 指标注释筛选
     * 
     * @param versionType 产品版本
     * @return
     */
    public List<MenuBO> indexNoteRelation(String versionType);

    /**
     * 指标注释菜单、指标关系
     * 
     * @param
     * @return
     */
    public List<Node> menuIndexRelation();

    /**
     * 来源注释菜单、指标关系
     * 
     * @param
     * @return
     */
    public List<SourceNode> menuSourceRelation();

    /**
     * 指标注释列表
     * 
     * @param keyword 搜索词
     * @param menuId 菜单ID
     * @param page 当前页数
     * @param pageSize 每页记录数
     * @return
     */
    public ResultPaginatedModel<IndexNoteListBO> getIndexNoteList(String keyword, String versionType, Integer menuId,
                                                                  Integer pageStart,

                                                                  Integer pageSize);

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
     * @param menuId 来源菜单ID
     * @param page 当前页数
     * @param pageSize 每页记录数
     * @return
     */
    public ResultPaginatedModel<SourceNoteListBO> getSourceNoteList(String keyword, String flowType, String menuId,
                                                                    Integer pageStart, Integer pageSize);

    /**
     * 常见问题列表
     * 
     * @param faqCode 问题分类ID
     * @param keyword 搜索词
     * @param page 当前页
     * @param pageSize 每页记录数
     * @return
     */
    public ResultPaginatedModel<FaqBO> getFaqList(String faqCategoryId, String keyword, Integer currentPage,
                                                  Integer pageSize);

    /**
     * 主题类别列表
     * 
     * @param
     * @return
     */
    public List<FaqBO> getFaqCategory();
}
