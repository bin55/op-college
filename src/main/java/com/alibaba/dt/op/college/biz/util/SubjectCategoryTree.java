/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 类SubjectCategoryTree.java的实现描述：构建主题分类菜单树
 * 
 * @author zishao.zb 2016年5月21日 下午5:42:38
 */
public class SubjectCategoryTree {

    @SuppressWarnings("unchecked")
    public List<SubjectCategoryNode> buildListToTree(List<SubjectCategoryNode> dirs) {
        List<SubjectCategoryNode> roots = findRoots(dirs);
        List<SubjectCategoryNode> notRoots = (List<SubjectCategoryNode>) CollectionUtils.subtract(dirs, roots);
        for (SubjectCategoryNode root : roots) {
            root.setCategory(findChildren(root, notRoots));
        }
        return roots;
    }

    public List<SubjectCategoryNode> findRoots(List<SubjectCategoryNode> allSubjectCategoryNodes) {
        List<SubjectCategoryNode> results = new ArrayList<SubjectCategoryNode>();
        for (SubjectCategoryNode SubjectCategoryNode : allSubjectCategoryNodes) {
            boolean isRoot = true;
            for (SubjectCategoryNode comparedOne : allSubjectCategoryNodes) {
                if (SubjectCategoryNode.getParentId().intValue() == comparedOne.getId().intValue()) {
                    isRoot = false;
                    break;
                }
            }
            if (isRoot) {
                SubjectCategoryNode.setLevel(0);
                results.add(SubjectCategoryNode);
                SubjectCategoryNode.setRootId(SubjectCategoryNode.getId());
            }
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    private List<SubjectCategoryNode> findChildren(SubjectCategoryNode root,
                                                   List<SubjectCategoryNode> allSubjectCategoryNodes) {
        List<SubjectCategoryNode> children = new ArrayList<SubjectCategoryNode>();

        for (SubjectCategoryNode comparedOne : allSubjectCategoryNodes) {
            if (comparedOne.getParentId().intValue() == root.getId().intValue()) {
                comparedOne.setParent(root);
                comparedOne.setLevel(root.getLevel() + 1);
                children.add(comparedOne);
            }
        }
        List<SubjectCategoryNode> notChildren = (List<SubjectCategoryNode>) CollectionUtils.subtract(allSubjectCategoryNodes,
                                                                                                     children);
        for (SubjectCategoryNode child : children) {
            List<SubjectCategoryNode> tmpChildren = findChildren(child, notChildren);
            if (tmpChildren == null || tmpChildren.size() < 1) {
                child.setIsLeaf(Boolean.TRUE);
            } else {
                child.setIsLeaf(Boolean.FALSE);
            }
            child.setCategory(tmpChildren);
        }
        return children;
    }

    public static void main(String[] args) {
        SubjectCategoryTree tb = new SubjectCategoryTree();
        List<SubjectCategoryNode> allSubjectCategoryNodes = new ArrayList<SubjectCategoryNode>();
        allSubjectCategoryNodes.add(new SubjectCategoryNode(1, 0, "节点1"));
        allSubjectCategoryNodes.add(new SubjectCategoryNode(2, 0, "节点2"));
        allSubjectCategoryNodes.add(new SubjectCategoryNode(3, 0, "节点3"));
        allSubjectCategoryNodes.add(new SubjectCategoryNode(4, 1, "节点4"));
        allSubjectCategoryNodes.add(new SubjectCategoryNode(5, 1, "节点5"));
        allSubjectCategoryNodes.add(new SubjectCategoryNode(6, 2, "节点6"));
        allSubjectCategoryNodes.add(new SubjectCategoryNode(7, 4, "节点7"));
        allSubjectCategoryNodes.add(new SubjectCategoryNode(8, 4, "节点8"));
        allSubjectCategoryNodes.add(new SubjectCategoryNode(9, 5, "节点9"));
        List<SubjectCategoryNode> roots = tb.buildListToTree(allSubjectCategoryNodes);
        for (SubjectCategoryNode n : roots) {
            System.out.println(n);
        }

    }
}
