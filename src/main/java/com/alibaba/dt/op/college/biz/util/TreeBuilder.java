/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.util;

/**
 * 类TreeBuilder.java的实现描述：构建节点树
 * 
 * @author zishao.zb 2016年3月31日 下午1:39:19
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class TreeBuilder {

    @SuppressWarnings("unchecked")
    public List<Node> buildListToTree(List<Node> dirs) {
        List<Node> roots = findRoots(dirs);
        List<Node> notRoots = (List<Node>) CollectionUtils.subtract(dirs, roots);
        for (Node root : roots) {
            root.setChildren(findChildren(root, notRoots));
        }
        return roots;
    }

    public List<Node> findRoots(List<Node> allNodes) {
        List<Node> results = new ArrayList<Node>();
        for (Node node : allNodes) {
            Boolean isRoot = true;
            for (Node comparedOne : allNodes) {
                if (node.getParentId() == comparedOne.getId()) {
                    isRoot = false;
                    break;
                }
            }
            if (isRoot) {
                node.setLevel(0);
                results.add(node);
                node.setRootId(node.getId());
            }
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    private List<Node> findChildren(Node root, List<Node> allNodes) {
        List<Node> children = new ArrayList<Node>();

        for (Node comparedOne : allNodes) {
            if (comparedOne.getParentId() == root.getId()) {
                comparedOne.setParent(root);
                comparedOne.setLevel(root.getLevel() + 1);
                children.add(comparedOne);
            }
        }
        List<Node> notChildren = (List<Node>) CollectionUtils.subtract(allNodes, children);
        for (Node child : children) {
            List<Node> tmpChildren = findChildren(child, notChildren);
            if (tmpChildren == null || tmpChildren.size() < 1) {
                child.setIsLeaf(Boolean.TRUE);
            } else {
                child.setIsLeaf(Boolean.FALSE);
            }
            child.setChildren(tmpChildren);
        }
        return children;
    }

    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        List<Node> allNodes = new ArrayList<Node>();
        allNodes.add(new Node(1, 0, "节点1"));
        allNodes.add(new Node(2, 0, "节点2"));
        allNodes.add(new Node(3, 0, "节点3"));
        allNodes.add(new Node(4, 2, "节点4"));
        allNodes.add(new Node(5, 2, "节点5"));
        allNodes.add(new Node(6, 1, "节点6"));
        allNodes.add(new Node(7, 1, "节点7"));
        allNodes.add(new Node(8, 3, "节点8"));
        allNodes.add(new Node(9, 3, "节点9"));
        allNodes.add(new Node(10, 9, "节点9"));
        allNodes.add(new Node(11, 9, "节点9"));
        allNodes.add(new Node(12, 11, "节点9"));
        allNodes.add(new Node(13, 11, "节点9"));
        allNodes.add(new Node(14, 10, "节点9"));
        allNodes.add(new Node(15, 10, "节点9"));

        List<Node> roots = tb.buildListToTree(allNodes);
        for (Node n : roots) {
            System.out.println(n);
        }

        NodeUtil nodeUtil = new NodeUtil();
        List<Integer> menuIdList = nodeUtil.getChildNodes(allNodes, 8);
        System.out.println(menuIdList.toString());

    }
}
