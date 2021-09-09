/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.util;

/**
 * 类Node.java的实现描述：节点信息
 * 
 * @author zishao.zb 2016年3月31日 下午1:38:25
 */
import java.util.List;

public class SourceNode implements java.io.Serializable {

    private static final long serialVersionUID = -2721191232926604726L;

    private String            id;

    private String            parentId;

    private SourceNode        parent;

    private List<SourceNode>  children;

    private String            name;

    private Integer           level;

    private String            rootId;

    private Boolean           isLeaf;

    public SourceNode(){
        super();
    }

    public SourceNode(String id, String parentId, String name){
        super();
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
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

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public SourceNode getParent() {
        return parent;
    }

    public void setParent(SourceNode parent) {
        this.parent = parent;
    }

    public List<SourceNode> getChildren() {
        return children;
    }

    public void setChildren(List<SourceNode> children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((children == null) ? 0 : children.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((isLeaf == null) ? 0 : isLeaf.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        result = prime * result + ((rootId == null) ? 0 : rootId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SourceNode other = (SourceNode) obj;
        if (children == null) {
            if (other.children != null) return false;
        } else if (!children.equals(other.children)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (isLeaf == null) {
            if (other.isLeaf != null) return false;
        } else if (!isLeaf.equals(other.isLeaf)) return false;
        if (level == null) {
            if (other.level != null) return false;
        } else if (!level.equals(other.level)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (parent == null) {
            if (other.parent != null) return false;
        } else if (!parent.equals(other.parent)) return false;
        if (parentId == null) {
            if (other.parentId != null) return false;
        } else if (!parentId.equals(other.parentId)) return false;
        if (rootId == null) {
            if (other.rootId != null) return false;
        } else if (!rootId.equals(other.rootId)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\"," + "\"children\":" + children + "}";
    }
}
