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
 * 类ResultPaginatedModel.java的实现描述：分页List返回结果
 * 
 * @author zishao.zb 2016年5月22日 下午3:57:56
 */
public class ResultPaginatedModel<T> implements ResultModel {

    private static final long serialVersionUID = 7562890547803633765L;

    // private Map<String, Object> data = new HashMap<String, Object>();

    // private int code = 0;
    private String            message;
    private String            errorStackTrace;

    private List<T>           data;
    private Integer           recordCount;

    public ResultPaginatedModel(){
    }

    public ResultPaginatedModel(List<T> list, int allPage){
        // this.data.put("record", list);
        // this.data.put("totalPage", allPage);
        this.setData(list);
        this.setRecordCount(allPage);
    }

    public ResultPaginatedModel(Errors errors){
        // this.code = errors.getCode();
        this.message = errors.getMessage();
    }

    public ResultPaginatedModel(int code, String message, String errorStackTrace){
        // this.code = code;
        this.message = message;
        this.errorStackTrace = errorStackTrace;
    }

    public ResultPaginatedModel(int code, String message){
        // this.code = code;
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

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

}
