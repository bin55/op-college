/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.dt.op.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import com.alibaba.dt.op.college.biz.service.helpCenter.PreloadService;

/**
 * 类MainServlet.java的实现描述：获取PreloadService实例的ServletContext
 * 
 * @author zishao.zb 2016年7月11日 下午5:37:31
 */
public class MainServlet extends HttpServlet {

    /**
     * 
     */
    private static final long     serialVersionUID = 474232942137468703L;
    private WebApplicationContext springContext;
    private ServletContext        context;

    public void init() throws ServletException {
        this.context = this.getServletContext();
        // this.springContext = WebApplicationContextUtils.getWebApplicationContext(context);
        PreloadService._servletContext = this.getServletContext();
    }

    public MainServlet(){
        super();
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }

    /**
     * The doGet method of the servlet. <br>
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC /-//W3C//DTD HTML 4.01 Transitional//EN/>");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    /**
     * The doPost method of the servlet. <br>
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC /-//W3C//DTD HTML 4.01 Transitional//EN/>");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public WebApplicationContext getSpringContext() {
        return springContext;
    }

    public void setSpringContext(WebApplicationContext springContext) {
        this.springContext = springContext;
    }

}
