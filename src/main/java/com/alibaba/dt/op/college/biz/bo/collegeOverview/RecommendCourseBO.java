/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.collegeOverview;

import com.alibaba.dt.op.lang.model.BaseBO;

/**
 * 类ProductFeatureBO.java的实现描述：首页推荐课程
 * 
 * @author zishao.zb 2016年5月17日 下午9:46:24
 */
public class RecommendCourseBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = 6422522178613300944L;
    /**
     * 课程ID
     */
    private Integer           id;
    /**
     * 标题
     */
    private String            title;
    /**
     * 图片url
     */
    private String            imageUrl;
    /**
     * 内容
     */
    private String            detail;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
