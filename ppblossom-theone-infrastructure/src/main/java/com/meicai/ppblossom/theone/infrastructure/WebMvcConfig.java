package com.meicai.ppblossom.theone.infrastructure;

import com.meicai.ppblossom.theone.infrastructure.interceptors.RequestTraceInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: guohaibin
 * @Date: 2020/06/03
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
//        registry.addInterceptor(traceInterceptor).addPathPatterns("/dmallladder/**","/api/gw/**");
//        registry.addInterceptor(metricInterceptor).addPathPatterns("/dmallladder/**","/api/gw/**");
        registry.addInterceptor(new RequestTraceInterceptor()).addPathPatterns("/dmallladder/**", "/api/gw/**");
    }
}
