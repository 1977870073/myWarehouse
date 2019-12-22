package com.cozyBed.renting_Admin.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Title: LoginInterceptor</p>
 * <p>Description:登陆验证 </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/11
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        String type = httpServletRequest.getHeader("X-Requested-With");// XMLHttpRequest
        if(url.indexOf("login")>=0){
            log.debug("免过滤资源："+url);
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        String user = (String)session.getAttribute("user");
        if(user!=null){
            return true;
        }
        log.debug("请求资源："+url+"，未登录，进行拦截!");
        if ("XMLHttpRequest".equals(type)) {
            //是ajax请求
            // 异步请求下的重定向
            httpServletResponse.addHeader("FLAG", "-1");
            httpServletResponse.setHeader("SESSIONSTATUS", "TIMEOUT");
            httpServletResponse.setHeader("CONTEXTPATH", "http://localhost:7049/web/zf/html/login.html");//重定向目标地址
            httpServletResponse.setStatus(1000);
        } else {
            //非ajax请求，直接使用重定向
            httpServletResponse.sendRedirect("http://localhost:7049/web/zf/html/login.html");
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
