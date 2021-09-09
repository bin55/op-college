/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.common.result;

import java.util.List;

import com.alibaba.dt.op.common.enums.Errors;
import com.alibaba.fastjson.JSON;

/**
 * 类ResultPaginatModel.java的实现描述：分页List返回结果
 * 
 * @author zishao.zb 2016年6月7日 下午9:11:50
 */
public class ResultPaginatModel<T> implements ResultModel {

    private static final long serialVersionUID = 7562890547803633765L;

    private String            message;
    private String            errorStackTrace;

    private List<T>           data;
    private Integer           totalRecord;

    public ResultPaginatModel(){
    }

    public ResultPaginatModel(List<T> list, int allPage){
        this.setData(list);
        this.setTotalRecord(allPage);
    }

    public ResultPaginatModel(Errors errors){
        this.message = errors.getMessage();
    }

    public ResultPaginatModel(int code, String message, String errorStackTrace){
        this.message = message;
        this.errorStackTrace = errorStackTrace;
    }

    public ResultPaginatModel(int code, String message){
        this.message = message;
    }

    @Override
    public void setErrorStackTrace(String errorStackTrace) {
        this.errorStackTrace = errorStackTrace;
    }

    @Override
    public String getErrorStackTrace() {
        return errorStackTrace;
    }

    @Override
    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

}
