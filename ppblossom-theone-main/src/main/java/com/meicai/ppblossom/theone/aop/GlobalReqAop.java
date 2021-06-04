package com.meicai.ppblossom.theone.aop;

import com.alibaba.fastjson.JSONObject;
import com.meicai.ppblossom.theone.api.response.ApiJsonResult;
import com.meicai.ppblossom.theone.api.response.JsonResult;
import com.meicai.ppblossom.theone.commons.enums.ErrorCode;
import com.meicai.ppblossom.theone.commons.exception.BizException;
import com.meicai.ppblossom.theone.commons.exception.InvalidParamException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: guohaibin
 * @Date: 2020/5/4
 * @Version 1.0
 */
@Order(1)
@Component
@Aspect
@Slf4j
public class GlobalReqAop {

    @Pointcut("execution(* com.meicai.ppblossom.theone.controller..*Controller.*(..))")
    public void pointcut() {
    }


    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object result = null;
        String classNameAndMethodName = getClassNameAndMethodName(joinPoint);
        Object[] args = joinPoint.getArgs();

        Object[] arguments  = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            arguments[i] = args[i];
        }
        String parameter = "";
        if (arguments != null) {
            try {
                parameter = JSONObject.toJSONString(arguments);
            } catch (Exception e) {
                parameter = arguments.toString();
            }
        }
        try {
            result = joinPoint.proceed();
        } catch (InvalidParamException e) {
            result = JsonResult.failure(e.getErrorCode(), e.getMessage());
        } catch (BizException e) {
            result = JsonResult.failure(e.getCode(), e.getMessage());
        } catch (Throwable e) {
            log.error("api process request exception", e);
            result = JsonResult.failure(ErrorCode.SYSTEM_EXCEPTION.getCode(), ErrorCode.SYSTEM_EXCEPTION.getMessage());
        } finally {
            log.info("api {} cost:{},request:{},result:{}", classNameAndMethodName, System.currentTimeMillis() - startTime, parameter, JSONObject.toJSONString(result));
        }
        return result;
    }

    @Pointcut("execution(* com.meicai.ppblossom.theone.apiController..*Controller.*(..))")
    public void apiPointcut() {
    }

    @Around("apiPointcut()")
    public Object apiDoAround(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object result = null;
        String classNameAndMethodName = getClassNameAndMethodName(joinPoint);
        Object[] args = joinPoint.getArgs();
        Object[] arguments  = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            arguments[i] = args[i];
        }
        String parameter = "";
        if (arguments != null) {
            try {
                parameter = JSONObject.toJSONString(arguments);
            } catch (Exception e) {
                parameter = arguments.toString();
            }
        }
        try {
            result = joinPoint.proceed();
        } catch (InvalidParamException e) {
            result = ApiJsonResult.failure(e.getErrorCode(), e.getMessage());
        } catch (BizException e) {
            result = ApiJsonResult.failure(e.getCode(), e.getMessage());
        } catch (Throwable e) {
            log.error("api process request exception", e);
            result = ApiJsonResult.failure(ErrorCode.SYSTEM_EXCEPTION.getCode(), ErrorCode.SYSTEM_EXCEPTION.getMessage());
        } finally {
            log.info("api {} cost:{},request:{},result:{}", classNameAndMethodName, System.currentTimeMillis() - startTime,parameter, JSONObject.toJSONString(result));
        }
        return result;
    }

    private String getClassNameAndMethodName(ProceedingJoinPoint pjp) {
        StringBuilder sb = new StringBuilder();
        try {
            String className = pjp.getTarget().getClass().getName();
            String[] strArr = className.split("\\.");
            if (strArr.length > 0) {
                className = strArr[strArr.length - 1];
            }
            String methodName = pjp.getSignature().getName();
            sb.append(className).append("@").append(methodName);

            return sb.toString();
        } catch (Exception e) {
            log.error("aop Get class or method failed in aop", e);
        }

        return sb.toString();
    }
}
