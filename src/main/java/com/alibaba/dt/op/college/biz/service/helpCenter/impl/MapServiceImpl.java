/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.helpCenter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dt.op.college.biz.bo.courseCenter.MenuBO;
import com.alibaba.dt.op.college.biz.bo.helpCenter.SourceMenuBO;
import com.alibaba.dt.op.college.biz.service.helpCenter.MapService;
import com.alibaba.dt.op.college.biz.util.Node;
import com.alibaba.dt.op.college.biz.util.NodeUtil;
import com.alibaba.dt.op.college.biz.util.SourceNode;
import com.alibaba.dt.op.college.biz.util.SourceNodeUtil;
import com.alibaba.dt.op.college.dal.dao.helpCenter.HelpCenterDao;

/**
 * 类MapServiceImpl.java的实现描述：获取菜单指标
 * 
 * @author zishao.zb 2016年6月23日 下午7:10:10
 */
@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private HelpCenterDao helpCenterDao;

    /**
     * 取得每一个菜单的全部子节点
     * 
     * @param
     * @return
     */
    @Override
    public Map<Integer, HashSet<Integer>> getMenuIndexMap() {
        Map<Integer, HashSet<Integer>> menuIndexMap = new HashMap<Integer, HashSet<Integer>>();
        List<MenuBO> menuBOList = helpCenterDao.menuId();
        for (MenuBO menuBO : menuBOList) {
            Integer menuId = menuBO.getId();
            menuIndexMap.put(menuId, (HashSet<Integer>) this.getChildNodes(menuId));
        }
        return menuIndexMap;
    }

    /**
     * 菜单与父菜单关系
     * 
     * @param
     * @return
     */
    @Override
    public Map<Integer, Integer> getMenuIdParentIdMap() {
        Map<Integer, Integer> menuIdParentIdMap = new HashMap<Integer, Integer>();
        List<MenuBO> menuBOList = helpCenterDao.menuId();
        for (MenuBO menuBO : menuBOList) {
            Integer menuId = menuBO.getId();
            Integer parentId = menuBO.getParentId();
            menuIdParentIdMap.put(menuId, parentId);
        }
        return menuIdParentIdMap;
    }

    /**
     * 菜单ID与名称关系
     * 
     * @param
     * @return
     */
    @Override
    public Map<Integer, String> getMenuIdNameMap() {
        Map<Integer, String> menuIdNameMap = new HashMap<Integer, String>();
        List<MenuBO> menuBOList = helpCenterDao.menuId();
        for (MenuBO menuBO : menuBOList) {
            Integer menuId = menuBO.getId();
            String name = menuBO.getName();
            menuIdNameMap.put(menuId, name);
        }
        return menuIdNameMap;
    }

    /**
     * 菜单ID下的全部子节点
     */
    public Set<Integer> getChildNodes(Integer menuId) {
        // 取得menuId下的所有子节点ID
        NodeUtil nodeUtil = new NodeUtil();
        List<Integer> menuIdList = nodeUtil.getChildNodes(this.menuIndexRelation(), menuId);
        List<MenuBO> menuBOList = helpCenterDao.menuIndexRelation();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < menuBOList.size(); i++) {
            map.put(menuBOList.get(i).getId(), menuBOList.get(i).getType());
        }
        Set<Integer> indexIdSet = new HashSet<Integer>();
        for (Integer id : menuIdList) {
            if (map.get(id).equals("1")) {
                indexIdSet.add(id);
            }
        }
        return indexIdSet;
    }

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
     * 来源注释菜单与子节点关系
     */
    @Override
    public Map<String, HashSet<String>> getMenuIndexSourceMap() {
        Map<String, HashSet<String>> menuIndexSourceMap = new HashMap<String, HashSet<String>>();
        List<SourceMenuBO> menuBOList = helpCenterDao.menuSourceId();
        for (SourceMenuBO sourceMenuBO : menuBOList) {
            String menuId = sourceMenuBO.getId();
            menuIndexSourceMap.put(menuId, (HashSet<String>) this.getSourceChildNodes(menuId));
        }
        return menuIndexSourceMap;
    }

    /**
     * 来源注释菜单与父菜单关系
     */
    @Override
    public Map<String, String> getMenuIdParentIdSourceMap() {
        Map<String, String> menuIdParentIdSourceMap = new HashMap<String, String>();
        List<SourceMenuBO> menuBOList = helpCenterDao.menuSourceId();
        for (SourceMenuBO sourceMenuBO : menuBOList) {
            String menuId = sourceMenuBO.getId();
            String parentId = sourceMenuBO.getParentId();
            menuIdParentIdSourceMap.put(menuId, parentId);
        }
        return menuIdParentIdSourceMap;
    }

    /**
     * 来源注释菜单ID与名称关系
     */
    @Override
    public Map<String, String> getMenuIdNameSourceMap() {
        Map<String, String> menuIdNameSourceMap = new HashMap<String, String>();
        List<SourceMenuBO> menuBOList = helpCenterDao.menuSourceId();
        for (SourceMenuBO sourceMenuBO : menuBOList) {
            String menuId = sourceMenuBO.getId();
            String name = sourceMenuBO.getName();
            menuIdNameSourceMap.put(menuId, name);
        }
        return menuIdNameSourceMap;
    }

    /**
     * 来源注释菜单ID下的全部子节点
     */
    @Override
    public Set<String> getSourceChildNodes(String menuId) {
        // 取得menuId下的所有子节点ID
        SourceNodeUtil nodeUtil = new SourceNodeUtil();
        List<String> menuIdList = nodeUtil.getChildNodes(this.menuSourceRelation(), menuId);

        List<SourceMenuBO> menuBOList = helpCenterDao.menuSourceRelation();
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < menuBOList.size(); i++) {
            map.put(menuBOList.get(i).getId(), menuBOList.get(i).getIsLeaf());
        }
        Set<String> sourceIdSet = new HashSet<String>();
        for (String id : menuIdList) {
            if (map.get(id).equals("Y")) {
                sourceIdSet.add(id);
            }
        }
        return sourceIdSet;
    }

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
}
