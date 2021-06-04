package com.meicai.ppblossom.theone.infrastructure.interceptors;


import com.meicai.ppblossom.theone.commons.constants.BasicConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: guohaibin
 * @Date: 2020/6/4
 * @Version 1.0
 * 拦截所有controller，增加自己的traceId，在日志打印出来
 */
@Slf4j
public class RequestTraceInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = UUID.randomUUID().toString();
        log.info("add_traceId:"+traceId);
        MDC.put(BasicConstants.traceId, traceId);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("clear_traceId:"+MDC.get(BasicConstants.traceId));
        MDC.clear();
    }
}
