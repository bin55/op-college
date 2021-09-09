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

public class Node implements java.io.Serializable {

    private static final long serialVersionUID = -2721191232926604726L;

    private Integer           id;

    private Integer           parentId;

    private Node              parent;

    private List<Node>        children;

    private String            name;

    private Integer           level;

    private Integer           rootId;

    private Boolean           isLeaf;

    public Node(){
        super();
    }

    public Node(int id, int parentId, String name){
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
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
        Node other = (Node) obj;
        if (id.intValue() != other.id.intValue()) return false;
        if (parentId.intValue() != other.parentId.intValue()) return false;
        return true;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\"," + "\"children\":" + children + "}";
    }
}
