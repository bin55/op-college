/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.bo.helpCenter;

import com.alibaba.dt.op.lang.model.BaseBO;

/**
 * 类FaqBO.java的实现描述：常见问题
 * 
 * @author zishao.zb 2016年5月25日 下午2:24:31
 */
public class FaqBO extends BaseBO {

    /**
     * 
     */
    private static final long serialVersionUID = 2129052656977051102L;
    /**
     * 问题id
     */
    private Integer           questonId;
    /**
     * 问题
     */
    private String            question;
    /**
     * 答案
     */
    private String            answer;
    /**
     * 分类ID
     */
    private Integer           categoryId;
    /**
     * 分类名称
     */
    private String            category;
    /**
     * 单店：s,多店：m
     */
    private String            singleShopFlag;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuestonId() {
        return questonId;
    }

    public void setQuestonId(Integer questonId) {
        this.questonId = questonId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSingleShopFlag() {
        return singleShopFlag;
    }

    public void setSingleShopFlag(String singleShopFlag) {
        this.singleShopFlag = singleShopFlag;
    }

}
