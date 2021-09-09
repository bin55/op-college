/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 类NodeUtil.java的实现描述：递归遍历一个节点的所有子节点
 * 
 * @author zishao.zb 2016年5月29日 下午2:31:53
 */
public class SourceNodeUtil {

    private List<String> returnList = new ArrayList<String>();

    /**
     * 根据父节点的ID获取所有子节点
     * 
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @return String
     */
    public List<String> getChildNodes(List<SourceNode> list, String parentId) {
        if (list == null && parentId == null) return null;
        for (Iterator<SourceNode> iterator = list.iterator(); iterator.hasNext();) {
            SourceNode node = (SourceNode) iterator.next();
            // 1、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentId() != null && parentId.equals(node.getId())) {
                recursionFn(list, node);
            }

            // 2、遍历父节点下的所有子节点
            // if (node.getParentId() == parentId) {
            // recursionFn(list, node);
            // }

        }
        return returnList;
    }

    private void recursionFn(List<SourceNode> list, SourceNode node) {
        List<SourceNode> childList = getChildList(list, node);// 得到子节点列表
        if (hasChild(list, node)) {// 判断是否有子节点
            returnList.add(node.getId());
            Iterator<SourceNode> it = childList.iterator();
            while (it.hasNext()) {
                SourceNode n = (SourceNode) it.next();
                recursionFn(list, n);
            }
        } else {
            returnList.add(node.getId());
        }
    }

    // 得到子节点列表
    private List<SourceNode> getChildList(List<SourceNode> list, SourceNode node) {
        List<SourceNode> nodeList = new ArrayList<SourceNode>();
        Iterator<SourceNode> it = list.iterator();
        while (it.hasNext()) {
            SourceNode n = (SourceNode) it.next();
            if (n.getParentId().equals(node.getId())) {
                nodeList.add(n);
            }
        }
        return nodeList;
    }

    // 判断是否有子节点
    private boolean hasChild(List<SourceNode> list, SourceNode node) {
        return getChildList(list, node).size() > 0 ? true : false;
    }

    // 本地模拟数据测试
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List<SourceNode> nodeList = new ArrayList<SourceNode>();
        SourceNode node1 = new SourceNode("1", "0", "实时直播");
        SourceNode node2 = new SourceNode("2", "0", "经营分析");
        SourceNode node3 = new SourceNode("3", "0", "市场行情");
        SourceNode node4 = new SourceNode("4", "1", "实时概况");
        SourceNode node5 = new SourceNode("5", "1", "实时来源");
        SourceNode node6 = new SourceNode("6", "3", "产品分析");
        SourceNode node7 = new SourceNode("7", "3", "品牌分析");
        SourceNode node8 = new SourceNode("8", "7", "品牌排行");
        SourceNode node9 = new SourceNode("9", "7", "品牌详情");
        SourceNode node10 = new SourceNode("10", "9", "交易指数");
        SourceNode node11 = new SourceNode("11", "9", "支付转化率");
        SourceNode node12 = new SourceNode("12", "8", "热销品牌榜");

        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        nodeList.add(node5);
        nodeList.add(node6);
        nodeList.add(node7);
        nodeList.add(node8);
        nodeList.add(node9);
        nodeList.add(node10);
        nodeList.add(node11);
        nodeList.add(node12);

        SourceNodeUtil mt = new SourceNodeUtil();
        System.out.println(mt.getChildNodes(nodeList, "1"));

        long end = System.currentTimeMillis();
        System.out.println("用时:" + (end - start) + "ms");
    }
}
