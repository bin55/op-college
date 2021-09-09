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
 * 类CourseDetailBO.java的实现描述：课程详情BO
 * 
 * @author zishao.zb 2016年5月24日 下午2:34:34
 */
public class CourseDetailBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = 6517854912513408445L;
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
     * 课程简介
     */
    private String            description;
    /**
     * 课程类型
     */
    private String            type;
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
     * 课程评分
     */
    private Float             grade;
    /**
     * 当前用户的课程评分
     */
    private Integer           userGrade;
    /**
     * 更新时间
     */
    private String            gmtModify;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(Integer participantCount) {
        this.participantCount = participantCount;
    }

    public Float getGrade() {
        int j = (int) Math.round(grade * 10);
        Float grade = (float) (j / 10.00);
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getGmtModify() {
        return gmtModify.substring(0, 10);
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

}
