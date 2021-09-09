/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.util;

import java.util.List;

/**
 * 类SubjectCategoryNode.java的实现描述：TODO 类实现描述
 * 
 * @author zishao.zb 2016年5月21日 下午5:00:06
 */
public class SubjectCategoryNode implements java.io.Serializable {

    private static final long         serialVersionUID = 4542341843546616609L;

    private Integer                   id;

    private Integer                   parentId;

    private SubjectCategoryNode       parent;

    private List<SubjectCategoryNode> category;

    private String                    name;

    private Integer                   level;

    private Integer                   rootId;

    private Boolean                   isLeaf;

    public SubjectCategoryNode(){
        super();
    }

    public SubjectCategoryNode(int id, int parentId, String name){
        super();
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public SubjectCategoryNode getParent() {
        return parent;
    }

    public void setParent(SubjectCategoryNode parent) {
        this.parent = parent;
    }

    public List<SubjectCategoryNode> getCategory() {
        return category;
    }

    public void setCategory(List<SubjectCategoryNode> category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + parentId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SubjectCategoryNode other = (SubjectCategoryNode) obj;
        if (id.intValue() != other.id.intValue()) return false;
        if (parentId.intValue() != other.parentId.intValue()) return false;
        return true;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\"," + "\"children\":" + category + "}";
    }
}
