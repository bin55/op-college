/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.courseCenter;

import com.alibaba.dt.op.lang.model.BaseBO;

/**
 * 类CourseBO.java的实现描述：课程列表项
 * 
 * @author zishao.zb 2016年5月21日 下午6:04:03
 */
public class CourseBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = -3678717029411693960L;

    /**
     * 课程ID
     */
    private Integer           id;
    /**
     * 课程标题
     */
    private String            title;
    /**
     * 课程主题
     */
    private String            subject;
    /**
     * 课程分类
     */
    private String            category;
    /**
     * 讲师
     */
    private String            teacher;
    /**
     * 课程类型
     */
    private String            type;
    /**
     * 图片url
     */
    private String            imageUrl;
    /**
     * 视频url
     */
    private String            linkUrl;
    /**
     * 图文内容
     */
    private String            textContent;
    /**
     * 课程学习人次
     */
    private Integer           participantCount;
    /**
     * 课程描述
     */
    private String            description;
    /**
     * 更新时间
     */
    private String            gmtModify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(Integer participantCount) {
        this.participantCount = participantCount;
    }

    public String getGmtModify() {
        if (gmtModify != null) {
            return gmtModify.substring(0, 10);
        }
        return gmtModify;
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
