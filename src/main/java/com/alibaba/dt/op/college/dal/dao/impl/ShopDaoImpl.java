///*
// * OpenPlatform - project - alibaba DW DTeam 
// * Copyright 2015 Alibaba.com All right reserved. This software is the
// * confidential and proprietary information of Alibaba.com ("Confidential
// * Information"). You shall not disclose such Confidential Information and shall
// * use it only in accordance with the terms of the license agreement you entered
// * into with Alibaba.com.
// */
//package com.alibaba.dt.op.college.dal.dao.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.alibaba.dt.op.common.dal.dao.BaseDao;
//import com.alibaba.dt.op.college.dal.dao.ShopDao;
//import com.alibaba.dt.op.college.dal.dataobject.ShopDO;
//
///**
// * 类ShopDaoImpl.java的实现描述：店铺DAO实现类
// * 
// * @author jianjiang.fangjj 2015年6月23日 下午10:15:11
// */
//@Service
//public class ShopDaoImpl implements ShopDao {
//
//    private static final String namespace = ShopDaoImpl.class.getName();
//    @Autowired
//    private BaseDao             baseDao;
//
//    /*
//     * (non-Javadoc)
//     * @see com.alibaba.dt.op.college.dal.dao.ShopDao#listShop(java.lang.Long)
//     */
//    @Override
//    public List<ShopDO> listShop(Long cateId) {
//        return baseDao.list(namespace + ".listShop", cateId);
//    }
// }
