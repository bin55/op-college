/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.common.util;

import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * 类PageUtil.java的实现描述：分页工具类
 * 
 * @author zishao.zb 2016年5月22日 下午4:01:09
 */
public class PageUtil {

    /**
     * 截取list分页，从pageStart开始(含)，取pageLimit条
     * 
     * @param list
     * @param pageStart
     * @param pageLimit
     * @return
     */
    public static <T> List<T> subPage(List<T> list, int pageStart, int pageLimit) {
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        // 分页处理
        int toIndex = (pageStart + pageLimit) < list.size() ? (pageStart + pageLimit) : list.size();
        return list.subList(pageStart, toIndex);
    }

    /**
     * 对应数据库分页，计算当前页开始行号，行号从0开始
     * 
     * @param currentPage 当前第几页（从第1页开始）
     * @param pageLimit 每页多少条记录
     * @return
     */
    public static int getPageStart(int currentPage, int pageLimit) {
        int pageStart = 0;
        if (currentPage > 0) {
            pageStart = (currentPage - 1) * pageLimit;
        }
        return pageStart;
    }

    /**
     * 计算总页数
     * 
     * @param total 总记录数
     * @param pageLimit 每页多少条记录
     * @return
     */
    public static int getAllPage(int total, int pageLimit) {
        int allPage = total / pageLimit;
        if (total % pageLimit != 0) {
            allPage++;
        }
        return allPage;
    }
}
