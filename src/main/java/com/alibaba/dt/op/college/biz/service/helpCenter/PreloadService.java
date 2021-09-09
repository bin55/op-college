/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.service.helpCenter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 类TestService.java的实现描述：数据预加载服务
 * 
 * @author zishao.zb 2016年6月23日 下午7:07:57
 */
@Service
public class PreloadService {

    /**
     * 指标注释菜单与子节点关系
     */
    public Map<Integer, HashSet<Integer>> menuIndexMap            = new HashMap<Integer, HashSet<Integer>>();
    /**
     * 指标注释菜单与父菜单关系
     */
    public Map<Integer, Integer>          menuIdParentIdMap       = new HashMap<Integer, Integer>();
    /**
     * 指标注释菜单ID与名称关系
     */
    public Map<Integer, String>           menuIdNameMap           = new HashMap<Integer, String>();
    /**
     * 来源注释菜单与子节点关系
     */
    public Map<String, HashSet<String>>   menuIndexSourceMap      = new HashMap<String, HashSet<String>>();
    /**
     * 来源注释菜单与父菜单关系
     */
    public Map<String, String>            menuIdParentIdSourceMap = new HashMap<String, String>();
    /**
     * 来源注释菜单ID与名称关系
     */
    public Map<String, String>            menuIdNameSourceMap     = new HashMap<String, String>();

    @Autowired
    private MapService                    mapService;

    public PreloadService(){
        super();
    }

    private static WebApplicationContext springContext;
    public static ServletContext         _servletContext; // 取servletContext
    private static PreloadService        _instance;

    public static PreloadService getInstance() {
        springContext = WebApplicationContextUtils.getWebApplicationContext(_servletContext);
        if (null == _instance) {
            _instance = (PreloadService) springContext.getBean("preloadService");
        }
        return _instance;

    }

    /**
     * Spring 容器初始化时加载
     */
    public void loadData() {
        menuIndexMap = mapService.getMenuIndexMap();
        menuIdParentIdMap = mapService.getMenuIdParentIdMap();
        menuIdNameMap = mapService.getMenuIdNameMap();
        menuIndexSourceMap = mapService.getMenuIndexSourceMap();
        menuIdParentIdSourceMap = mapService.getMenuIdParentIdSourceMap();
        menuIdNameSourceMap = mapService.getMenuIdNameSourceMap();
    }

    /**
     * 重新加载数据
     */
    public void reloadData() {
        menuIndexMap.clear();
        menuIdParentIdMap.clear();
        menuIdNameMap.clear();
        menuIndexSourceMap.clear();
        menuIdParentIdSourceMap.clear();
        menuIdNameSourceMap.clear();
        this.loadData();
    }

    public MapService getMapService() {
        return mapService;
    }

    public void setMapService(MapService mapService) {
        this.mapService = mapService;
    }
}
