/*
 * OpenPlatform - project - alibaba DW DTeam 
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.college.biz.util.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.buc.sso.client.util.SimpleUserUtil;
import com.alibaba.buc.sso.client.vo.BucSSOUser;

/**
 * 类BucSSOHelper.java的实现描述：TODO 类实现描述
 * 
 * @author shenlin 2014年10月18日 下午4:55:21
 */
public class BucSSOHelper {

    /**
     * 判断是否已经登录
     */
    public static boolean isLogin(HttpServletRequest request) {
        if (getBucSSOUser(request) == null) {
            return false;
        }
        return true;
    }

    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public static String getUserAccount(HttpServletRequest request) {
        return getBucSSOUser(request).getAccount();
    }

    /**
     * 获取用户Id
     * 
     * @return 用户名
     */
    public static int getUserId(HttpServletRequest request) {
        return getBucSSOUser(request).getId();
    }

    /**
     * 获取用户花名
     * 
     * @author lancelot <junan.cja@alibaba-inc.com>
     * @date 2014年12月4日
     * @param request
     * @return
     */
    public static String getNickNameCn(HttpServletRequest request) {
        BucSSOUser bucSSOUser = getBucSSOUser(request);
        if (bucSSOUser != null) {
            return bucSSOUser.getNickNameCn();
        }
        return "";
    }

    /**
     * 获取用户名称，若没有花名，返回真名
     * 
     * @author lancelot <junan.cja@alibaba-inc.com>
     * @date 2014年12月5日
     * @param request
     * @return
     */
    public static String getName(HttpServletRequest request) {
        String nick = getNickNameCn(request);
        if (nick == null || "".equals(nick)) {
            return getBucSSOUser(request).getLastName();
        }

        return nick;
    }

    /**
     * 获取用户描述类
     * 
     * @return 用户名
     */
    public static BucSSOUser getBucSSOUser(HttpServletRequest request) {
        BucSSOUser user = null;
        try {
            user = SimpleUserUtil.getBucSSOUser(request);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return user;
    }
}
