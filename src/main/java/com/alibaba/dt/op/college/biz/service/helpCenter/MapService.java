/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.helpCenter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 类MapService.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年6月23日 下午7:09:08
 */
public interface MapService {

    /**
     * 指标注释菜单与子节点关系
     */
    public Map<Integer, HashSet<Integer>> getMenuIndexMap();

    /**
     * 指标注释菜单与父菜单关系
     */
    public Map<Integer, Integer> getMenuIdParentIdMap();

    /**
     * 指标注释菜单ID与名称关系
     */
    public Map<Integer, String> getMenuIdNameMap();

    /**
     * 指标注释菜单ID下的全部子节点
     */
    public Set<Integer> getChildNodes(Integer menuId);

    /**
     * 来源注释菜单与子节点关系
     */
    public Map<String, HashSet<String>> getMenuIndexSourceMap();

    /**
     * 来源注释菜单与父菜单关系
     */
    public Map<String, String> getMenuIdParentIdSourceMap();

    /**
     * 来源注释菜单ID与名称关系
     */
    public Map<String, String> getMenuIdNameSourceMap();

    /**
     * 来源注释菜单ID下的全部子节点
     */
    public Set<String> getSourceChildNodes(String menuId);
}
