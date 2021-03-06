package com.cozyBed.renting_Admin.Interceptor;

import com.cozyBed.renting_Admin.mapper.RentAccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.Interceptor
 * @ClassName: InterceptorConfig
 * @Description: java类作用描述
 * @Author: zy
 * @CreateDate: 2019/12/22 21:42
 * @Version: 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private RentAccessMapper rentAccessMapper;
    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(rentAccessMapper)).addPathPatterns("/**");
    }
}
