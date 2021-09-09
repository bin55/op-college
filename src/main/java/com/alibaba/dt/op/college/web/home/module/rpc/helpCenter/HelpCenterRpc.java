/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.web.home.module.rpc.helpCenter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.extension.rpc.annotation.ResourceMapping;
import com.alibaba.citrus.extension.rpc.annotation.WebResource;
import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.FaqBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.IndexNoteListBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceMenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceNoteListBO;
import com.alibaba.dt.op.college.biz.service.helpCenter.HelpCenterService;
import com.alibaba.dt.op.college.biz.util.Node;
import com.alibaba.dt.op.college.biz.util.SourceNode;
import com.alibaba.dt.op.college.biz.util.SourceTreeBuilder;
import com.alibaba.dt.op.college.biz.util.TreeBuilder;
import com.alibaba.dt.op.common.result.ResultPaginatedModel;
import com.alibaba.dt.op.common.util.PageUtil;
import com.alibaba.nonda.databind.annotation.RequestParam;

/**
 * 类HelpCenterRpc.java的实现描述：帮助中心
 * 
 * @author zishao.zb 2016年5月25日 上午11:29:19
 */
@WebResource("helpCenter")
public class HelpCenterRpc {

    @Autowired
    private HttpServletRequest  request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HelpCenterService   helpCenterService;

    /**
     * 指标注释筛选
     * 
     * @param versionType 产品版本
     * @return
     */
    @ResourceMapping("indexNoteRelation")
    public IndexNoteBO indexNoteRelation(@RequestParam(name = "viewMode", defaultValue = "s") String versionType) {
        List<MenuBO> menuBOList = helpCenterService.indexNoteRelation(versionType);
        List<Node> nodeList = new ArrayList<Node>();
        TreeBuilder tb = new TreeBuilder();
        for (int i = 0; i < menuBOList.size(); i++) {
            Integer id = menuBOList.get(i).getId();
            Integer parentId = menuBOList.get(i).getParentId();
            String name = menuBOList.get(i).getName();
            nodeList.add(new Node(id, parentId, name));
        }
        List<Node> menuTreeNodeList = tb.buildListToTree(nodeList);
        List<Node> menuTreeNodeBOList = this.recurseMenu(menuTreeNodeList);
        IndexNoteBO indexNoteBO = new IndexNoteBO();
        indexNoteBO.setList(menuTreeNodeBOList);
        return indexNoteBO;
    }

    /**
     * 菜单、指标关系
     * 
     * @param
     * @return
     */
    @ResourceMapping("menuIndexRelation")
    public List<Node> menuIndexRelation() {
        return helpCenterService.menuIndexRelation();
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
    @ResourceMapping("getIndexNoteList")
    public ResultPaginatedModel<IndexNoteListBO> getIndexNoteList(@RequestParam(name = "keyword") String keyword,
                                                                  @RequestParam(name = "viewMode", defaultValue = "s") String versionType,
                                                                  @RequestParam(name = "menuId", defaultValue = "1") Integer menuId,
                                                                  @RequestParam(name = "page", defaultValue = "1") Integer currentPage,
                                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        return helpCenterService.getIndexNoteList(keyword, versionType, menuId,
                                                  PageUtil.getPageStart(currentPage, pageSize), pageSize);
    }

    /**
     * 来源注释筛选
     * 
     * @param flowType 设备类型
     * @return
     */
    @ResourceMapping("sourceNoteRelation")
    public SourceNoteBO sourceNoteRelation(@RequestParam(name = "flowType", defaultValue = "0") String deviceType) {
        List<SourceMenuBO> menuBOList = new ArrayList<SourceMenuBO>();
        menuBOList = helpCenterService.sourceNoteRelation(deviceType);
        List<SourceNode> nodeList = new ArrayList<SourceNode>();
        SourceTreeBuilder tb = new SourceTreeBuilder();
        for (int i = 0; i < menuBOList.size(); i++) {
            String id = menuBOList.get(i).getId();
            String parentId = menuBOList.get(i).getParentId();
            String name = menuBOList.get(i).getName();
            nodeList.add(new SourceNode(id, parentId, name));
        }
        List<SourceNode> menuTreeNodeList = tb.buildListToTree(nodeList);
        List<SourceNode> menuTreeNodeBOList = this.recurseSourceMenu(menuTreeNodeList);
        SourceNoteBO sourceNoteBO = new SourceNoteBO();
        sourceNoteBO.setList(menuTreeNodeBOList);
        return sourceNoteBO;
    }

    /**
     * 来源注释列表
     * 
     * @param keyword 搜索词
     * @param flowType 来源类型
     * @param categoryCode 来源菜单ID
     * @param page 当前页数
     * @param pageSize 每页记录数
     * @return
     */
    @ResourceMapping("getSourceNoteList")
    public ResultPaginatedModel<SourceNoteListBO> getSourceNoteList(@RequestParam(name = "keyword") String keyword,
                                                                    @RequestParam(name = "flowType", defaultValue = "1") String flowType,
                                                                    @RequestParam(name = "categoryCode", defaultValue = "0") String menuId,
                                                                    @RequestParam(name = "page", defaultValue = "1") Integer currentPage,
                                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return helpCenterService.getSourceNoteList(keyword, flowType, menuId,
                                                   PageUtil.getPageStart(currentPage, pageSize), pageSize);
    }

    /**
     * 常见问题列表
     * 
     * @param faqCategoryId 问题分类ID
     * @param keyword 搜索词
     * @param page 当前页
     * @param pageSize 每页记录数
     * @return
     */
    @ResourceMapping("getFaqList")
    public ResultPaginatedModel<FaqBO> getFaqList(@RequestParam(name = "faqCode", defaultValue = "0") String faqCategoryId,
                                                  @RequestParam(name = "keyword") String keyword,
                                                  @RequestParam(name = "page", defaultValue = "1") Integer currentPage,
                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        return helpCenterService.getFaqList(faqCategoryId, keyword, PageUtil.getPageStart(currentPage, pageSize),
                                            pageSize);
    }

    /**
     * 主题类别列表
     * 
     * @param
     * @return
     */
    @ResourceMapping("getFaqCategory")
    public List<FaqBO> getFaqCategory() {
        List<FaqBO> faqBOList = new ArrayList<FaqBO>();
        faqBOList = helpCenterService.getFaqCategory();
        return faqBOList;
    }

    private List<Node> recurseMenu(List<Node> menuTreeNodeList) {
        List<Node> menuNodeBOList = new ArrayList<Node>();
        if (!menuTreeNodeList.isEmpty()) {
            for (Node menuTreeNode : menuTreeNodeList) {
                Node node = new Node();
                node.setId(menuTreeNode.getId());
                node.setName(menuTreeNode.getName());
                node.setChildren(this.recurseMenu(menuTreeNode.getChildren()));
                menuNodeBOList.add(node);
            }
        }
        return menuNodeBOList;
    }

    private List<SourceNode> recurseSourceMenu(List<SourceNode> menuTreeNodeList) {
        List<SourceNode> menuNodeBOList = new ArrayList<SourceNode>();
        if (!menuTreeNodeList.isEmpty()) {
            for (SourceNode menuTreeNode : menuTreeNodeList) {
                SourceNode node = new SourceNode();
                node.setId(menuTreeNode.getId());
                node.setName(menuTreeNode.getName());
                node.setChildren(this.recurseSourceMenu(menuTreeNode.getChildren()));
                menuNodeBOList.add(node);
            }
        }
        return menuNodeBOList;
    }
}
