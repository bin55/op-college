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

public class SourceTreeBuilder {

    @SuppressWarnings("unchecked")
    public List<SourceNode> buildListToTree(List<SourceNode> dirs) {
        List<SourceNode> roots = findRoots(dirs);
        List<SourceNode> notRoots = (List<SourceNode>) CollectionUtils.subtract(dirs, roots);
        for (SourceNode root : roots) {
            root.setChildren(findChildren(root, notRoots));
        }
        return roots;
    }

    public List<SourceNode> findRoots(List<SourceNode> allSourceNodes) {
        List<SourceNode> results = new ArrayList<SourceNode>();
        for (SourceNode SourceNode : allSourceNodes) {
            boolean isRoot = true;
            for (SourceNode comparedOne : allSourceNodes) {
                if (SourceNode.getParentId().equals(comparedOne.getId())) {
                    isRoot = false;
                    break;
                }
            }
            if (isRoot) {
                SourceNode.setLevel(0);
                results.add(SourceNode);
                SourceNode.setRootId(SourceNode.getId());
            }
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    private List<SourceNode> findChildren(SourceNode root, List<SourceNode> allSourceNodes) {
        List<SourceNode> children = new ArrayList<SourceNode>();

        for (SourceNode comparedOne : allSourceNodes) {
            if (comparedOne.getParentId().equals(root.getId())) {
                comparedOne.setParent(root);
                comparedOne.setLevel(root.getLevel() + 1);
                children.add(comparedOne);
            }
        }
        List<SourceNode> notChildren = (List<SourceNode>) CollectionUtils.subtract(allSourceNodes, children);
        for (SourceNode child : children) {
            List<SourceNode> tmpChildren = findChildren(child, notChildren);
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
        SourceTreeBuilder tb = new SourceTreeBuilder();
        List<SourceNode> allSourceNodes = new ArrayList<SourceNode>();
        allSourceNodes.add(new SourceNode("1", "0", "节点1"));
        allSourceNodes.add(new SourceNode("2", "0", "节点2"));
        allSourceNodes.add(new SourceNode("3", "0", "节点3"));
        allSourceNodes.add(new SourceNode("4", "2", "节点4"));
        allSourceNodes.add(new SourceNode("5", "2", "节点5"));
        allSourceNodes.add(new SourceNode("6", "1", "节点6"));
        allSourceNodes.add(new SourceNode("7", "1", "节点7"));
        allSourceNodes.add(new SourceNode("8", "3", "节点8"));
        allSourceNodes.add(new SourceNode("9", "3", "节点9"));
        allSourceNodes.add(new SourceNode("10", "9", "节点9"));
        allSourceNodes.add(new SourceNode("11", "9", "节点9"));
        allSourceNodes.add(new SourceNode("12", "11", "节点9"));
        allSourceNodes.add(new SourceNode("13", "11", "节点9"));
        allSourceNodes.add(new SourceNode("14", "10", "节点9"));
        allSourceNodes.add(new SourceNode("15", "10", "节点9"));

        List<SourceNode> roots = tb.buildListToTree(allSourceNodes);
        for (SourceNode n : roots) {
            System.out.println(n);
        }

        SourceNodeUtil SourceNodeUtil = new SourceNodeUtil();
        List<String> menuIdList = SourceNodeUtil.getChildNodes(allSourceNodes, "8");
        System.out.println(menuIdList.toString());

    }
}
