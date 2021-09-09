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
public class NodeUtil {

    private List<Integer> returnList = new ArrayList<Integer>();

    /**
     * 根据父节点的ID获取所有子节点
     * 
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @return String
     */
    public List<Integer> getChildNodes(List<Node> list, Integer parentId) {
        if (list == null && parentId == null) return null;
        for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
            Node node = (Node) iterator.next();
            // 1、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentId() != null && parentId == node.getId().intValue()) {
                recursionFn(list, node);
            }

            // 2、遍历父节点下的所有子节点
            // if (node.getParentId() == parentId) {
            // recursionFn(list, node);
            // }

        }
        return returnList;
    }

    private void recursionFn(List<Node> list, Node node) {
        List<Node> childList = getChildList(list, node);// 得到子节点列表
        if (hasChild(list, node)) {// 判断是否有子节点
            returnList.add(node.getId());
            Iterator<Node> it = childList.iterator();
            while (it.hasNext()) {
                Node n = (Node) it.next();
                recursionFn(list, n);
            }
        } else {
            returnList.add(node.getId());
        }
    }

    // 得到子节点列表
    private List<Node> getChildList(List<Node> list, Node node) {
        List<Node> nodeList = new ArrayList<Node>();
        Iterator<Node> it = list.iterator();
        while (it.hasNext()) {
            Node n = (Node) it.next();
            if (n.getParentId().intValue() == node.getId().intValue()) {
                nodeList.add(n);
            }
        }
        return nodeList;
    }

    // 判断是否有子节点
    private boolean hasChild(List<Node> list, Node node) {
        return getChildList(list, node).size() > 0 ? true : false;
    }

    // 本地模拟数据测试
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List<Node> nodeList = new ArrayList<Node>();
        Node node1 = new Node(1, 0, "实时直播");
        Node node2 = new Node(2, 0, "经营分析");
        Node node3 = new Node(3, 0, "市场行情");
        Node node4 = new Node(4, 1, "实时概况");
        Node node5 = new Node(5, 1, "实时来源");
        Node node6 = new Node(6, 3, "产品分析");
        Node node7 = new Node(7, 3, "品牌分析");
        Node node8 = new Node(8, 7, "品牌排行");
        Node node9 = new Node(9, 7, "品牌详情");
        Node node10 = new Node(10, 9, "交易指数");
        Node node11 = new Node(11, 9, "支付转化率");
        Node node12 = new Node(12, 8, "热销品牌榜");

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

        NodeUtil mt = new NodeUtil();
        System.out.println(mt.getChildNodes(nodeList, 1));

        long end = System.currentTimeMillis();
        System.out.println("用时:" + (end - start) + "ms");
    }
}
