package com.cozyBed.renting_Admin.Interceptor;

import com.cozyBed.renting_Admin.mapper.RentAccessMapper;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    private RentAccessMapper rentAccessMapper;

    public LoginInterceptor(RentAccessMapper rentAccessMapper){
        super();
        this.rentAccessMapper = rentAccessMapper;
    }
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
        String uType = (String)session.getAttribute("type");
        if(user!=null){
            if(!checkAccess(url,uType)){
                httpServletResponse.addHeader("FLAG", "-1");
                httpServletResponse.setHeader("SESSIONSTATUS", "TIMEOUT");
                httpServletResponse.setHeader("CONTEXTPATH", "http://localhost:7049/web/zf/html/login.html");//重定向目标地址
                httpServletResponse.setStatus(1001);
                log.debug("请求资源："+url+"，权限不足，进行拦截!");
                return false;
            }
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

    /**
     * 验证是否在访问权限中
     * @param url
     * @param type
     * @return
     */
    public boolean checkAccess(String url,String type){
        Integer userType = 0;
        if(ObjectUtil.isEmply(type)){
            return false;
        }
        if("cc0111".equals(type)){
            userType=1;
        }
        List<Map<String, Object>> rsList = rentAccessMapper.selectInfo(userType);
        for (Map<String, Object> temp: rsList){
            String access = (String) temp.get("access");
            if(url.indexOf(access)>=0){
                return true;
            }
        }
        return false;
    }
}
