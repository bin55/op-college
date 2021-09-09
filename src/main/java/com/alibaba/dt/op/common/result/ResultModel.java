/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.common.result;

import java.io.Serializable;

/**
 * 类ResultModel.java的实现描述：标识接口
 * 
 * @author zishao.zb 2016年5月22日 下午3:58:46
 */
public interface ResultModel extends Serializable {

    // public void setCode(int code);

    public void setMessage(String message);

    public void setErrorStackTrace(String errorStackTrace);

    public String getErrorStackTrace();

    public String toJsonString();

}
