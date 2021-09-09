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
 * 类PartnerBO.java的实现描述：合作伙伴
 * 
 * @author zishao.zb 2016年5月18日 下午5:51:25
 */
public class PartnerBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = -796500464988573580L;
    /**
     * 标题
     */
    private String            title;
    /**
     * 内容
     */
    private String            detail;
    /**
     * 图片url
     */
    private String            imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
