package com.meicai.ppblossom.theone.commons.datasource;


import com.meicai.ppblossom.theone.commons.annotation.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 任务流转详情aop
 * 基于JDK
 */
@Aspect
@Component
@Order(-1)
public class DataSourceAspect {


    @Before(value = "@annotation(com.meicai.ppblossom.theone.commons.annotation.TargetDataSource)")
    public void methodBefore(JoinPoint joinPoint) throws Exception {
        Object target = joinPoint.getTarget();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        // 执行方法名
        String methodName = methodSignature.getName();
        // 方法参数
        Class[] parameterTypes = methodSignature.getParameterTypes();
        // 获取方法
        Method method = target.getClass().getDeclaredMethod(methodName,parameterTypes);
        if (null != method && method.isAnnotationPresent(TargetDataSource.class)) {
            TargetDataSource targetDataSource = method.getAnnotation(TargetDataSource.class);
            if(null != targetDataSource){
                DataSourceHolder.removeDataSource();
                DataSourceHolder.setDataSource(targetDataSource.value().getCode());
            }
        }
    }

    @Before(value = "@within(com.meicai.ppblossom.theone.commons.annotation.TargetDataSource)")
    public void classBefore(JoinPoint joinPoint) throws Exception {
        //反射获取Method 方法一
        Object target = joinPoint.getTarget();
        Class<?> clazz = target.getClass();
        TargetDataSource annotation = clazz.getAnnotation(TargetDataSource.class);
        DataSourceHolder.removeDataSource();
        DataSourceHolder.setDataSource(annotation.value().getCode());
    }


    @After(value = "@annotation(com.meicai.ppblossom.theone.commons.annotation.TargetDataSource)")
    public void methodAfter(JoinPoint joinPoint) throws Exception {
        DataSourceHolder.removeDataSource();
    }

    @After(value = "@within(com.meicai.ppblossom.theone.commons.annotation.TargetDataSource)")
    public void classAfter(JoinPoint joinPoint) throws Exception {
        DataSourceHolder.removeDataSource();
    }



}
