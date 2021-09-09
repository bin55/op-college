///*
// * Copyright 2014 Alibaba.com All right reserved. This software is the
// * confidential and proprietary information of Alibaba.com ("Confidential
// * Information"). You shall not disclose such Confidential Information and shall
// * use it only in accordance with the terms of the license agreement you entered
// * into with Alibaba.com.
// */
//package com.alibaba.dt.op.college.web.home.module.rpc;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.alibaba.citrus.extension.rpc.annotation.ResourceMapping;
//import com.alibaba.citrus.extension.rpc.annotation.WebResource;
//import com.alibaba.dt.op.college.biz.service.ShopService;
//import com.alibaba.dt.op.college.dal.dataobject.ShopDO;
//import com.alibaba.nonda.databind.annotation.RequestParam;
//import com.alibaba.nonda.databind.annotation.RequestParams;
///**
// * 类ShopOverviewRpc.java的实现描述：店铺概况
// * 
// * @author jianjiang.fangjj 2014年12月17日 下午1:17:33
// */
//@WebResource(value = "shop")
//public class ShopRpc {
//    @Autowired
//    private HttpServletRequest  request;
//    @Autowired
//    private HttpServletResponse response;
//    @Autowired
//    private ShopService         shopService;
//    /**
//     * 根据一级行业id获取店铺信息列表
//     * 
//     * @return
//     */
//    @ResourceMapping("/listShop")
//    public List<ShopDO> listShop(@RequestParam(name = "cateId", defaultValue = "0") Long cateId) {
//        return shopService.listShop(cateId);
//    }
//    /**
//     * 新增店铺信息（入库操作，需要增加csrfToken校验（默飞为false），可以在此设置）
//     * 
//     * @return
//     */
//    @ResourceMapping(value = "/addShop")
//    public void addShop(@RequestParams ShopDO shop) {
//        // 实现shopService.addShop(shop);
//    }
// }
