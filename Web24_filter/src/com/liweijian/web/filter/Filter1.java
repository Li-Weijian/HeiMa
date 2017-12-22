package com.liweijian.web.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: 过滤器
 *      1. 实现Filter接口
 *      2. 实现需要覆盖的方法
 *      3. 配置web.xml文件
 *
 * @Date:Create in 23:30 2017/12/14 0014
 */
public class Filter1 implements Filter {


    //服务器启动时创建Filter并执行初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter1 is run...");
        filterChain.doFilter(servletRequest, servletResponse);      //放行， 如果不调用此方法，则无法访问Servlet
    }


    //服务器关闭时执行Filter的销毁方法
    @Override
    public void destroy() {

    }
}
